package com.example.kitchen.service;

import com.example.kitchen.client.OrdersClient;
import com.example.kitchen.entity.DishEntity;
import com.example.kitchen.model.Dish;
import com.example.kitchen.repository.DishesRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KitchenService {

  private final OrdersClient ordersClient;

  private final DishesRepository dishesRepository;

  public List<Dish> getAllAvailableDishes() {
    return dishesRepository.findAll()
        .stream()
        .map(DishEntity::toDish)
        .collect(Collectors.toList());
  }

  /**
   * Cooks order with the specified id and requests its items from Order service
   */
  public void cookOrder(Long orderId) {
    var order = ordersClient.getOrderById(orderId);
    System.out.println("Получен заказ c id " + orderId);
  }
}
