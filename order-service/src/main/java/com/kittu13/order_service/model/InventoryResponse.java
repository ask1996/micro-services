package com.kittu13.order_service.model;

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
