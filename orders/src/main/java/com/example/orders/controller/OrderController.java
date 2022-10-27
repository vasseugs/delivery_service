package com.example.orders.controller;

import com.example.orders.model.Product;
import com.example.orders.service.OrderService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {

  private final OrderService orderService;

  /**
   * Get all dishes available for ordering
   */
  @GetMapping("/all")
  public ResponseEntity<List<Product>> getAvailableDishes() {
    return ResponseEntity.ok().body(orderService.getAvailableProducts());
  }
}
