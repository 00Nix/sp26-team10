package com.example.backend_api_team10.service;

import java.util.List;

import com.example.backend_api_team10.entity.Meal;
import com.example.backend_api_team10.repository.MealRepo;

import org.springframework.stereotype.Service;

@Service
public class MealService {
    
    private final MealRepo mealRepo;

    public MealService(MealRepo mealRepo) {
        this.mealRepo = mealRepo;
    }

    public Meal createMeal(Meal meal) {
        return mealRepo.save(meal);
    }

    public List<Meal> getAllMeals(){
        return mealRepo.findAll();
    }

    public List<Meal> getMealByName(String name){
        return mealRepo.findByName(name);
    }

    public Meal getMealById(Long meal_id){
        return mealRepo.findById(meal_id).orElse(null);
    }

    public Meal updateMeal(String name, Meal updatedMeal){
       List <Meal> existing = mealRepo.findByName(name);
        if (existing != null && !existing.isEmpty()) {
            Meal meal = existing.get(0);
            meal.setDescription(updatedMeal.getDescription());
            meal.setPrice(updatedMeal.getPrice());
            meal.setImageUrl(updatedMeal.getImageUrl());
            return mealRepo.save(meal);
        } else {
            return null;
        }
    }

    public void deleteMeal(Long meal_id){
        mealRepo.deleteById(meal_id);
    }

}
