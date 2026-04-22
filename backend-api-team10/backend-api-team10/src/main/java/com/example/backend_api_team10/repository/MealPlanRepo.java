package com.example.backend_api_team10.repository;

import com.example.backend_api_team10.entity.MealPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.math.BigDecimal;
import java.util.List;

public interface MealPlanRepo extends JpaRepository<MealPlan, Long> {
    @Query("SELECT mp FROM MealPlan mp WHERE mp.plan_id = :plan_id")
    List<MealPlan> findByPlanId(Long plan_id);
    List<MealPlan> findByName(String name);

    List<MealPlan> findByPrice(BigDecimal price);

    List<MealPlan> findByDiet(String diet);

    @Query("SELECT m.diet, COUNT(m) FROM MealPlan m GROUP BY m.diet")
    List<Object[]> countMealPlansByDiet();

}
