package com.kittu13.inventory_service.model;

import jakarta.persistence.*;
import lombok.*;

@Table(name="inventory_t")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Setter
@Getter
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private String skuCode;
    private Integer quantity;
}
