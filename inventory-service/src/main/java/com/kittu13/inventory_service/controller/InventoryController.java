package com.kittu13.inventory_service.controller;


import com.kittu13.inventory_service.model.Inventory;
import com.kittu13.inventory_service.model.InventoryResponse;
import com.kittu13.inventory_service.services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/inventory")
public class InventoryController {

    @Autowired
    InventoryService inventoryService;

    @GetMapping
    public List<InventoryResponse> getInventorybySku(@RequestParam("skuCode") List<String> skuCode){
        System.out.println("I am called");
        return inventoryService.isInstock(skuCode);
    }
}
