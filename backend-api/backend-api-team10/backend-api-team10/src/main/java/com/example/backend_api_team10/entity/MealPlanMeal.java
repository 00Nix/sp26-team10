package com.example.backend_api_team10.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "mealPlanMeal")
public class MealPlanMeal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long mealPlan_mealId;

    @ManyToOne
    @JoinColumn(name = "plan_id", nullable = false)
    @JsonIgnoreProperties({"mealPlanMeal"})
    private MealPlan mealPlan;

    @ManyToOne
    @JoinColumn(name = "meal_id", nullable = false)
    private Meal meal;

    @Column(nullable = false)
    private int quantity;

    public MealPlanMeal() {
    }

    public MealPlanMeal(MealPlan mealPlan, Meal meal, int quantity) {
        this.mealPlan = mealPlan;
        this.meal = meal;
        this.quantity = quantity;
    }

    // setters and getters

    public void setMealPlanMealId(Long mealPlan_mealId){
        this.mealPlan_mealId = mealPlan_mealId;
    }

    public Long getMeanPlanMealId(){
        return mealPlan_mealId;
    }

    public void setMealPlan(MealPlan mealPlan){
        this.mealPlan = mealPlan;
    }

    public MealPlan getMealPlan(){
        return mealPlan;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    public int getQuantity(){
        return quantity;
    }
}
