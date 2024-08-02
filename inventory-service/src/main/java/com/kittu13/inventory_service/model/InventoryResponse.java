package com.kittu13.inventory_service.model;

import jakarta.persistence.Entity;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Setter
@Getter
public class InventoryResponse {
    boolean inStock;
    String skuCode;
}
