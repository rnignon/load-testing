package com.loadtesting.order.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "orders")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Order {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int quantity;

    private Order(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public static Order createOrder(String name, int quantity) {
        return new Order(name, quantity);
    }
}
