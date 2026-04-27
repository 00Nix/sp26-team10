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

import com.example.backend_api_team10.entity.Meal;
import com.example.backend_api_team10.service.MealService;

@RestController
@RequestMapping("/api/meals")
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
    public List<Meal> getMealByName(String name){
        return mealService.getMealByName(name);
    }

    @PostMapping("/")
    public Meal createMeal(@RequestBody Meal meal){
        return mealService.createMeal(meal);
    }

    @PutMapping("/{meal_id}")
    public Meal updateMeal(@PathVariable String name, @RequestBody Meal meal){
        return mealService.updateMeal(name, meal);
    }
    
    @DeleteMapping("/{meal_id}")
    public void deleteMeal(@PathVariable Long meal_id){
        mealService.deleteMeal(meal_id);
    }

}
