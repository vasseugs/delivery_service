package com.example.orders.service;

import com.example.orders.entity.OrderEntity;
import com.example.orders.model.Order;
import com.example.orders.repository.OrderItemRepository;
import com.example.orders.repository.OrderRepository;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

  private final OrderRepository orderRepository;
  private final OrderItemRepository orderItemRepository;

  public Long createNewOrder(Order order) {
    var orderEntity = orderRepository.save(OrderEntity.builder()
        .userId(order.getUserId())
        .createdAt(Timestamp.from(Instant.now()))
        .build());

    var orderItemEntities = order.getItems()
        .stream()
        .map(item -> item.toEntity(orderEntity.getId()))
        .collect(Collectors.toList());

    orderItemRepository.saveAll(orderItemEntities);
    return orderEntity.getId();
  }

  public Order getOrderById(Long orderId) {
    return orderRepository.findById(orderId)
        .map(OrderEntity::toOrder)
        .orElseThrow(() ->
            new NoSuchElementException(String.format("Order with id \"%d\" not found", orderId)));
  }
}
