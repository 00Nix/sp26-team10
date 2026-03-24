package com.example.backend_api_team10.service;

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

    public Meal getMealByName(String name){
        return mealRepo.findByName(name);
    }

    public Meal getMealById(Long meal_id){
        return mealRepo.findById(meal_id).orElse(null);
    }

    public Meal updateMeal(String name, Meal updatedMeal){
        Meal existing = mealRepo.findByName(name);
        if (existing != null) {
            existing.setDescription(updatedMeal.getDescription());
            existing.setPrice(updatedMeal.getPrice());
            existing.setImageUrl(updatedMeal.getImageUrl());
            return mealRepo.save(existing);
        } else {
            return null;
        }
    }

    public void deleteMeal(Long meal_id){
        mealRepo.deleteById(meal_id);
    }

}
