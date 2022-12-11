package com.example.kitchen.controller;

import com.example.kitchen.model.Dish;
import com.example.kitchen.service.KitchenService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/kitchen")
public class KitchenController {

  private final KitchenService kitchenService;

  /**
   * Get all dishes available for ordering
   */
  @GetMapping("/dishes/all")
  public ResponseEntity<List<Dish>> getAvailableDishes() {
    return ResponseEntity.ok().body(kitchenService.getAllAvailableDishes());
  }
}
