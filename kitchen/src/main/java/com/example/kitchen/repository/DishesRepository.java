package com.example.kitchen.repository;

import com.example.kitchen.entity.DishEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DishesRepository extends JpaRepository<DishEntity, Long> {

}
