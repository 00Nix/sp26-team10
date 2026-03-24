package com.example.backend_api_team10.controller;

import com.example.backend_api_team10.entity.Meal;
import com.example.backend_api_team10.service.MealService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/meals")
public class MealController {
    
    private final MealService mealService;

    public MealController(MealService mealService){
        this.mealService = mealService;
    }

    @GetMapping
    public List<Meal> getAllMeals(){
        return mealService.getAllMeals();
    }

    @GetMapping("/{name}")
    public Meal getMealByName(String name){
        return mealService.getMealByName(name);
    }

    @PostMapping
    public Meal createMeal(@RequestBody Meal meal){
        return mealService.createMeal(meal);
    }

    @PutMapping("/{meal_id}")
    public Meal updateMeal(@PathVariable Long meal_id, @RequestBody Meal meal){
        return mealService.updateMeal(meal_id, meal);
    }

    @DeleteMapping("/{meal_id}")
    public void deleteMeal(@PathVariable Long meal_id){
        mealService.deleteMeal(meal_id);
    }

}
