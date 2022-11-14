package com.example.orders.controller;

import com.example.orders.model.Product;
import com.example.orders.service.ProductService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/products")
public class ProductsController {

  private final ProductService productService;

  /**
   * Get all dishes available for ordering
   */
  @GetMapping("/all")
  public ResponseEntity<List<Product>> getAvailableProducts() {
    return ResponseEntity.ok().body(productService.getAvailableProducts());
  }
}
