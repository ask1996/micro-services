package com.kittu13.inventory_service.services;

import com.kittu13.inventory_service.model.Inventory;
import com.kittu13.inventory_service.model.InventoryResponse;
import com.kittu13.inventory_service.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository repository;

    public List<InventoryResponse> isInstock(List<String> skuCode){
        return repository.findBySkuCodeIn(skuCode).stream().map(inventory -> maptoRes(inventory)).toList();
    }

    private InventoryResponse maptoRes(Inventory inventory){
        if(inventory.getQuantity() > 0) {
            return InventoryResponse.builder().skuCode(inventory.getSkuCode()).inStock(true).build();
        }
        return InventoryResponse.builder().skuCode(inventory.getSkuCode()).inStock(false).build();
    }

}
