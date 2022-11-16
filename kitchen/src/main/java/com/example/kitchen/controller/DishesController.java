package com.example.kitchen.controller;

import com.example.kitchen.model.Dish;
import com.example.kitchen.service.DishesService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/dishes")
public class DishesController {

  private final DishesService dishesService;

  /**
   * Get all dishes available for ordering
   */
  @GetMapping("/all")
  public ResponseEntity<List<Dish>> getAvailableDishes() {
    return ResponseEntity.ok().body(dishesService.getAllAvailableDishes());
  }
}
