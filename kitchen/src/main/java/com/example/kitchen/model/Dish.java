package com.example.kitchen.model;

import com.example.kitchen.entity.DishEntity;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents a single dish the kitchen can cook
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Dish {

  private String name;
  private BigDecimal cost;

  public DishEntity toEntity() {
    return DishEntity.builder()
        .name(this.name)
        .cost(this.cost)
        .build();
  }

}
