package com.kittu13.order_service.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name="orders_t")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Setter
@Getter
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String orderNUmber;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    List<OrderLineItem> orderLineItems;
}
