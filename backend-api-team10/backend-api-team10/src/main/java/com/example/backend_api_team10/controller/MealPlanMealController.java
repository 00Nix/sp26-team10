package com.example.backend_api_team10.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend_api_team10.entity.MealPlanMeal;
import com.example.backend_api_team10.service.MealPlanMealService;

@RestController
@RequestMapping("/api/meal-plan-meals")
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