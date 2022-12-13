package com.example.kitchen.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Represents an item of an order
 */

@Getter
@AllArgsConstructor
public class OrderItem {

  private Long dishId;
  private int amount;
}
