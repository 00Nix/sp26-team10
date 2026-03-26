package com.example.backend_api_team10.controller;

import com.example.backend_api_team10.entity.MealPlan;
import com.example.backend_api_team10.service.MealPlanService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/meal-plans")
public class MealPlanController {
    private final MealPlanService mealPlanService;

    public MealPlanController(MealPlanService mealPlanService) {
        this.mealPlanService = mealPlanService;
    }

    @GetMapping
    public List<MealPlan> getAllMealPlans() {
        return mealPlanService.getAllMealPlans();
    }

    @GetMapping("/{plan_id}")
    public MealPlan getMealPlanById(@PathVariable Long plan_id) {
        return mealPlanService.getMealPlanById(plan_id);
    }

    @GetMapping("/{name}")
    public List<MealPlan> getMealPlansByName(@PathVariable String name) {
        return mealPlanService.getMealPlanByName(name);
    }

    @PostMapping
    public MealPlan createMealPlan(@RequestBody MealPlan mealPlan) {
        return mealPlanService.createMealPlan(mealPlan);
    }

    @PutMapping("/{id}")
    public MealPlan updateMealPlan(@PathVariable Long id, @RequestBody MealPlan mealPlan) {
        return mealPlanService.updateMealPlan(id, mealPlan);
    }

    @DeleteMapping("/{id}")
    public void deleteMealPlan(@PathVariable Long plan_id) {
        mealPlanService.deleteMealPlan(plan_id);
    }
}
