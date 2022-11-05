package com.example.orders.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents an order in devilery service
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {

  private Long userId;
  private List<OrderItem> items;
}
