package com.example.backend_api_team10.service;

import java.util.List;

import com.example.backend_api_team10.entity.MealPlanMeal;
import com.example.backend_api_team10.repository.MealPlanMealRepo;

import org.springframework.stereotype.Service;

@Service
public class MealPlanMealService {
    
    private final MealPlanMealRepo mealPlanMealRepo;

    public MealPlanMealService(MealPlanMealRepo mealPlanMealRepo) {
        this.mealPlanMealRepo = mealPlanMealRepo;
    }

    public MealPlanMeal createMealPlanMeal(MealPlanMeal mealPlanMeal) {
        return mealPlanMealRepo.save(mealPlanMeal);
    }

    public List<MealPlanMeal> getAllMealPlanMeals(){
        return mealPlanMealRepo.findAll();
    }

    public MealPlanMeal getMealPlanMealById(Long mealPlan_mealId){
        return mealPlanMealRepo.findById(mealPlan_mealId).orElse(null);
    }

    public MealPlanMeal updateMealPlanMeal(Long mealPlan_mealId, MealPlanMeal updated){
        MealPlanMeal existing = mealPlanMealRepo.findById(mealPlan_mealId).orElse(null);
        if (existing != null) {
            existing.setMealPlanMealId(updated.getMealPlanMealId());
            return mealPlanMealRepo.save(existing);
        } else {
            return null;
        }
    }

    public void deleteMealPlanMeal(Long mealPlan_mealId){
        mealPlanMealRepo.deleteById(mealPlan_mealId);
    }

}
