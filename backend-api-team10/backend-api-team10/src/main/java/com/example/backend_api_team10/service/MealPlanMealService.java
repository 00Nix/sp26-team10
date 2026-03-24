package com.example.backend_api_team10.service;

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

    public MealPlanMeal getMealPlanMealById(Long id){
        return mealPlanMealRepo.findById(id).orElse(null);
    }

    public MealPlanMeal updateMealPlanMeal(Long id, MealPlanMeal updated){
        MealPlanMeal existing = mealPlanMealRepo.findById(id).orElse(null);
        if (existing != null) {
            existing.setMeal(updated.getMeal());
            return mealPlanMealRepo.save(existing);
        } else {
            return null;
        }
    }

    public void deleteMealPlanMeal(Long id){
        mealPlanMealRepo.deleteById(id);
    }

}
