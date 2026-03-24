package com.example.backend_api_team10.repository;

import com.example.backend_api_team10.entity.MealPlanMeal;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MealPlanMealRepo extends JpaRepository<MealPlanMeal, Long> {
    List<MealPlanMeal> findByMealPlanMealId(Long mealPlan_mealId);
}
