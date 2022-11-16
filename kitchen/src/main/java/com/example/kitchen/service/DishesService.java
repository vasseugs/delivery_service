package com.example.kitchen.service;

import com.example.kitchen.entity.DishEntity;
import com.example.kitchen.model.Dish;
import com.example.kitchen.repository.DishesRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DishesService {

  private final DishesRepository dishesRepository;

  public List<Dish> getAllAvailableDishes() {
    return dishesRepository.findAll()
        .stream()
        .map(DishEntity::toDish)
        .collect(Collectors.toList());
  }

}
