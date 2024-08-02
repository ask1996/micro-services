package com.kittu13.order_service.clients;


import com.kittu13.order_service.model.InventoryResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("inventory-service")
public interface InventoryService {
    @GetMapping("api/inventory")
    public List<InventoryResponse> getInventorybySku(@RequestParam("skuCode") List<String> skuCode);
}
