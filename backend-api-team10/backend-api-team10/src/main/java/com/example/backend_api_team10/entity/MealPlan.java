package com.example.backend_api_team10.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "meal_plans")
public class MealPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long plan_id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @Column(nullable = false, length = 1000)
    private String description;

    private String diet;
    private Boolean is_premade;

    @ManyToOne
    @JoinColumn(name = "provider_id", nullable = false)
    @JsonIgnoreProperties({"meal", "mealPlan", "reviewReply"})
    private Provider provider;

    @OneToMany(mappedBy = "mealPlan", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties({"mealPlan"})
    private List<MealPlanMeal> mealPlanMeal = new ArrayList<>();

    public MealPlan(){
    }

    public MealPlan(String name, BigDecimal price, String description, String diet, Boolean is_premade, Provider provider, List<MealPlanMeal> mealPlanMeal){
        this.name = name;
        this.price = price;
        this.description = description;
        this.diet = diet;
        this.is_premade = is_premade;
        this.provider = provider;
        this.mealPlanMeal = mealPlanMeal;

    }

    // setters and getters

    public void setMealPlanId(Long plan_id){
        this.plan_id = plan_id;
    }

    public Long getMealPlanId(){
        return plan_id;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setPrice(BigDecimal price){
        this.price = price;
    }

    public BigDecimal getPrice(){
        return price;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getDescription(){
        return description;
    }

    public void setDiet(String diet){
        this.diet = diet;
    }

    public String getDiet(){
        return diet;
    }

    public void setIsPremade(Boolean is_premade){
        this.is_premade = is_premade;
    }

    public Boolean getIsPremade(){
        return is_premade;
    }

    public void setProvider(Provider provider){
        this.provider = provider;
    }

    public Provider getProvider(){
        return provider;
    }

    public void setMealPlanMeal(List<MealPlanMeal> mealPlanMeal){
        this.mealPlanMeal = mealPlanMeal;
    }

    public List<MealPlanMeal> getMealPlanMeal(){
        return mealPlanMeal;
    }
}
