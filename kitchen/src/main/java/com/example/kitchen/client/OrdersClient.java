package com.example.kitchen.client;

import com.example.kitchen.model.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

/**
 * A client which does requests to Orders service
 */

@RequiredArgsConstructor
public class OrdersClient {

  private final RestTemplate restTemplate;

  @Value("${orders.host}")
  private final String ordersHost;

  public Order getOrderById(Long id) {
    return restTemplate.getForObject(ordersHost + "/orders/" + id, Order.class);
  }
}
