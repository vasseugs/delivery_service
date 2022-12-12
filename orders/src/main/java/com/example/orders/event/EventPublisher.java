package com.example.orders.event;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EventPublisher {

  private final RabbitTemplate rabbitTemplate;

  @Value("${order.exchange.name}")
  private final String orderExchangeName;

  @Value("${order.created.key}")
  private final String orderCreatedRoutingKey;

  public void send(OrderCreatedEvent orderCreatedEvent) {
    rabbitTemplate.convertAndSend(orderExchangeName, orderCreatedRoutingKey, orderCreatedEvent);
  }
}
