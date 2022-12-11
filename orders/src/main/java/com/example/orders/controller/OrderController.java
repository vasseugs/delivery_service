package com.example.orders.controller;

import com.example.orders.model.Order;
import com.example.orders.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {

  private final OrderService orderService;

  @PostMapping("/create")
  public ResponseEntity<Long> createNewOrder(@RequestBody Order order) {
    return ResponseEntity.ok(orderService.createNewOrder(order));
  }

  @GetMapping("/{orderId}")
  public ResponseEntity<Order> getOrderById(@PathVariable Long orderId) {
    return ResponseEntity.ok(orderService.getOrderById(orderId));
  }
}
