package com.example.kitchen.event;

import com.example.kitchen.service.KitchenService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EventHandler {

  private final KitchenService kitchenService;

  @RabbitListener(queues = "${order.queue}")
  void handleOrderCreated(OrderCreatedEvent event) {
    kitchenService.cookOrder(event.getOrderId());
  }
}
