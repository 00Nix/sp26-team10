package com.example.backend_api_team10.repository;

import com.example.backend_api_team10.entity.MealPlan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface MealPlanRepo extends JpaRepository<MealPlan, Long> {
    List<MealPlan> findByPlanId(Long plan_id);

    List<MealPlan> findByName(String name);

    List<MealPlan> findByPrice(BigDecimal price);

    List<MealPlan> findByDiet(String diet);

}
