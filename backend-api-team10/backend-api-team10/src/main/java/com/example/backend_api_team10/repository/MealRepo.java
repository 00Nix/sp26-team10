package com.example.backend_api_team10.repository;

import com.example.backend_api_team10.entity.MealPlan;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import com.example.backend_api_team10.entity.Meal;

public interface MealRepo extends JpaRepository<Meal, Long> {
    List<Meal> findByMealId(Long meal_id);

    List<Meal> findByName(String name);

    List<Meal> findByDiet(String diet);
}
