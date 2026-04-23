package com.example.backend_api_team10.service;

import java.util.List;

import com.example.backend_api_team10.entity.Meal;
import com.example.backend_api_team10.entity.Provider;
import com.example.backend_api_team10.repository.MealRepo;
import com.example.backend_api_team10.repository.ProviderRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MealService {
    
    private final MealRepo mealRepo;

    @Autowired
    private  ProviderRepo providerRepo;

    public MealService(MealRepo mealRepo, ProviderRepo providerRepo){
        this.mealRepo = mealRepo;
        this.providerRepo = providerRepo;
    }

    public Meal createMeal(Meal meal) {

        Long provider_id = meal.getProvider().getProviderId();

        Provider provider = providerRepo.findById(provider_id)
            .orElseThrow(() -> new RuntimeException("Provider not found"));

        meal.setProvider(provider);

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

    public Meal updateMeal(Long meal_id, Meal updatedMeal){
        Meal existingMeal = getMealById(meal_id);
        if (existingMeal != null) {
            existingMeal.setDescription(updatedMeal.getDescription());
            existingMeal.setPrice(updatedMeal.getPrice());
            existingMeal.setImageUrl(updatedMeal.getImageUrl());
            return mealRepo.save(existingMeal);
        } else {
            return null;
        }
    }

    public void deleteMeal(Long meal_id){
        mealRepo.deleteById(meal_id);
    }

}
