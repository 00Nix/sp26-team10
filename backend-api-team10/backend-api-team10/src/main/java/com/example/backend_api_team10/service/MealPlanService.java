package com.example.backend_api_team10.service;

import java.util.List;

import com.example.backend_api_team10.entity.MealPlan;
import com.example.backend_api_team10.entity.MealPlanMeal;
import com.example.backend_api_team10.entity.Meal;
import com.example.backend_api_team10.repository.MealPlanRepo;
import com.example.backend_api_team10.service.MealService;

import org.springframework.stereotype.Service;

@Service
public class MealPlanService {
    
    private final MealPlanRepo mealPlanRepo;
    private final MealService mealService;

    public MealPlanService(MealPlanRepo mealPlanRepo, MealService mealService) {
        this.mealPlanRepo = mealPlanRepo;
        this.mealService = mealService;
    }

    public MealPlan createMealPlanWithMeals(MealPlan mealPlan, List<Long> mealIds) {
        if (mealIds != null) {
            for (Long mealId : mealIds) {
                Meal meal = mealService.getMealById(mealId);

                MealPlanMeal mealPlanMeal = new MealPlanMeal();
                mealPlanMeal.setMealPlan(mealPlan);
                mealPlanMeal.setMeal(meal);
                mealPlanMeal.setQuantity(1);

                mealPlan.getMealPlanMeal().add(mealPlanMeal);
            }
        }
        
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

    public MealPlan updateMealPlanWithMeals(Long plan_id, MealPlan updatedMealPlan, List<Long> mealIds) {
        
        MealPlan existing = mealPlanRepo.findById(plan_id).orElse(null);
        
        if (existing == null) {
            return null;
        }
        
        existing.setName(updatedMealPlan.getName());
        existing.setDescription(updatedMealPlan.getDescription());
        existing.setPrice(updatedMealPlan.getPrice());
        existing.setDiet(updatedMealPlan.getDiet());
        existing.setIsPremade(updatedMealPlan.getIsPremade());

        existing.getMealPlanMeal().clear();

        if (mealIds != null) {
            for (Long mealId : mealIds) {
                Meal meal = mealService.getMealById(mealId);

                MealPlanMeal mealPlanMeal = new MealPlanMeal();
                mealPlanMeal.setMealPlan(existing);
                mealPlanMeal.setMeal(meal);
                mealPlanMeal.setQuantity(1);

                existing.getMealPlanMeal().add(mealPlanMeal);
            }
        }
        
        return mealPlanRepo.save(existing);

    }

    public void deleteMealPlan(Long plan_id){
        mealPlanRepo.deleteById(plan_id);
    }

}
