package com.kittu13.order_service.services;

import com.kittu13.order_service.clients.InventoryService;
import com.kittu13.order_service.model.InventoryResponse;
import com.kittu13.order_service.model.Order;
import com.kittu13.order_service.model.OrderLineItem;
import com.kittu13.order_service.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import static java.util.Arrays.asList;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private WebClient.Builder webClientBuilder;

    @Autowired
    private InventoryService client;

    public String createOrder(Order order){

        Order dto = new Order();
        dto.setOrderNUmber(UUID.randomUUID().toString());
        dto.setOrderLineItems(order.getOrderLineItems());
        List<String> skuCodes = order.getOrderLineItems().stream().map(OrderLineItem::getSkuCode).toList();
        List<InventoryResponse> result = client.getInventorybySku(skuCodes);
        boolean allInStock = false;
        if (result != null) {
            allInStock = result.stream().allMatch(InventoryResponse::isInStock);
        }
        if(allInStock){
            orderRepository.save(dto);
            return "Order placed";

        } else {
          throw new IllegalArgumentException("Product out of order");
        }
    }

    public List<Order> getOrders() {
      return orderRepository.findAll();
    }
}
