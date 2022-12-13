package com.example.kitchen.event;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * An event indicating that an order has been created
 */

@Getter
@RequiredArgsConstructor
public class OrderCreatedEvent {

  private final Long orderId;
}
