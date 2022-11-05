package com.example.orders.model;

import com.example.orders.entity.OrderItemEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem {

  private Product product;
  private int amount;

  public OrderItemEntity toEntity(Long orderId) {
    return OrderItemEntity.builder()
        .orderId(orderId)
        .product(this.product.toEntity())
        .amount(this.amount)
        .build();
  }
}
