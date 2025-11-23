package com.loadtesting.order.controller;

import com.loadtesting.order.entity.Order;
import com.loadtesting.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<Order> createOrder(
            @RequestParam String name,
            @RequestParam int quantity
    ) {
        Order order = orderService.createOrder(name, quantity);
        return ResponseEntity.ok(order);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(
            @PathVariable("id") Long id
    ) {
        Order order = orderService.getOrderById(id);
        return ResponseEntity.ok(order);
    }
}
