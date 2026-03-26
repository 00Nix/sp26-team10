package com.example.backend_api_team10.controller;

import com.example.backend_api_team10.entity.MealPlanMeal;
import com.example.backend_api_team10.service.MealPlanMealService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/meal-plan-meals")
public class MealPlanMealController {
    
     private final MealPlanMealService mealPlanMealService;

    public MealPlanMealController(MealPlanMealService mealPlanMealService) {
        this.mealPlanMealService = mealPlanMealService;
    }

    @GetMapping
    public List<MealPlanMeal> getAllMealPlanMeals() {
        return mealPlanMealService.getAllMealPlanMeals();
    }

    @GetMapping("/{mealPlan_mealId}")
    public MealPlanMeal getMealPlanMealById(@PathVariable Long mealPlan_mealId) {
        return mealPlanMealService.getMealPlanMealById(mealPlan_mealId);
    }

    @PostMapping
    public MealPlanMeal createMealPlanMeal(@RequestBody MealPlanMeal mealPlanMeal) {
        return mealPlanMealService.createMealPlanMeal(mealPlanMeal);
    }

    @PutMapping("/{mealPlan_mealId}")
    public MealPlanMeal updateMealPlanMeal(@PathVariable Long mealPlan_mealId, @RequestBody MealPlanMeal mealPlanMeal) {
        return mealPlanMealService.updateMealPlanMeal(mealPlan_mealId, mealPlanMeal);
    }

    @DeleteMapping("/{mealPlan_mealId}")
    public void deleteMealPlanMeal(@PathVariable Long mealPlan_mealId) {
        mealPlanMealService.deleteMealPlanMeal(mealPlan_mealId);
    }
}