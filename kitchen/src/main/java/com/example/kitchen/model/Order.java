package com.example.kitchen.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Represents an order in devilery service
 */

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Order {

  private Long userId;
  private List<OrderItem> items;
}
