package com.example.orders.model;

import com.example.orders.entity.OrderItemEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents an item of an order
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem {

  private Long dishId;
  private int amount;

  public OrderItemEntity toEntity(Long orderId) {
    return OrderItemEntity.builder()
        .orderId(orderId)
        .dishId(this.dishId)
        .amount(this.amount)
        .build();
  }
}
