package com.example.backend_api_team10.service;

import java.util.List;

import com.example.backend_api_team10.entity.MealPlan;
import com.example.backend_api_team10.repository.MealPlanRepo;

import org.springframework.stereotype.Service;

@Service
public class MealPlanService {
    
    private final MealPlanRepo mealPlanRepo;

    public MealPlanService(MealPlanRepo mealPlanRepo) {
        this.mealPlanRepo = mealPlanRepo;
    }

    public MealPlan createMealPlan(MealPlan mealPlan) {
        return mealPlanRepo.save(mealPlan);
    }

    public List<MealPlan> getAllMealPlans(){
        return mealPlanRepo.findAll();
    }

    public List<MealPlan> getMealPlanByName(String name){
        return mealPlanRepo.findByName(name);
    }

    public MealPlan getMealPlanById(Long plan_id){
        return mealPlanRepo.findById(plan_id).orElse(null);
    }

    public MealPlan updateMealPlan(Long plan_id, MealPlan updatedMealPlan){
        MealPlan existing = mealPlanRepo.findById(plan_id).orElse(null);
        if (existing != null) {
            existing.setName(updatedMealPlan.getName());
            existing.setDescription(updatedMealPlan.getDescription());
            existing.setPrice(updatedMealPlan.getPrice());
            existing.setMealPlanMeal(updatedMealPlan.getMealPlanMeal());
            return mealPlanRepo.save(existing);
        } else {
            return null;
        }
    }

    public void deleteMealPlan(Long plan_id){
        mealPlanRepo.deleteById(plan_id);
    }

}
