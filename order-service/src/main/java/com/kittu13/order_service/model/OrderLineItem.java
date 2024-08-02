package com.kittu13.order_service.model;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Table(name="orders_line_items")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Setter
@Getter
public class OrderLineItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer quantity;
    private String skuCode;
    private BigDecimal price;

//    @ManyToOne
//    @JoinColumn(name=@)
//    private Order order;

}
