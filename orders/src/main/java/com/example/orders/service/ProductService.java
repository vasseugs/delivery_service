package com.example.orders.service;

import com.example.orders.entity.ProductEntity;
import com.example.orders.model.Product;
import com.example.orders.repository.ProductRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

  private final ProductRepository productRepository;

  public List<Product> getAvailableProducts() {
    return productRepository.findAll()
        .stream()
        .map(ProductEntity::toProduct)
        .collect(Collectors.toList());
  }
}
