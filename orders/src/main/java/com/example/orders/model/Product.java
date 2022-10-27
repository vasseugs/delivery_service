package com.example.orders.model;

import com.example.orders.entity.ProductEntity;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Represents anything that can be ordered - food, drinks etc.
 */

@Data
@AllArgsConstructor
public class Product {

  private String name;
  private BigDecimal cost;

  public ProductEntity toEntity() {
    return ProductEntity.builder()
        .name(this.name)
        .cost(this.cost)
        .build();
  }
}
