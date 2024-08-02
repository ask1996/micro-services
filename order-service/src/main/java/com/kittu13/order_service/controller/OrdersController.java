package com.kittu13.order_service.controller;


import com.kittu13.order_service.model.Order;
import com.kittu13.order_service.services.OrderService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping(value = "/api/orders")
@CircuitBreaker(name = "inventory", fallbackMethod = "fallbackMethod")
public class OrdersController {

    @Autowired
    OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CompletableFuture<String> createOrder(@RequestBody Order order){
        return CompletableFuture.supplyAsync(() -> orderService.createOrder(order));
    }

    @GetMapping
    public List<Order> getOrders(){
        return orderService.getOrders();
    }


    public  CompletableFuture<String> fallbackMethod(Order order, RuntimeException runtimeException){
        return CompletableFuture.supplyAsync(() -> "Oops! some exception");
    }
}
