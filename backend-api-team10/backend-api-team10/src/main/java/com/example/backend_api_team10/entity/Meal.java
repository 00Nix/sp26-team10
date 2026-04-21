package com.example.backend_api_team10.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "meals")
public class Meal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long meal_id;
    
    @Column(nullable = false)
    private String name;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @Column(nullable = false, length = 1000)
    private String description;

    @Column(nullable = false)
    private String image_url;

    private String diet;
    private String portion_size;

    @ManyToOne
    @JoinColumn(name = "provider_id", nullable = false)
    @JsonIgnoreProperties({"meals", "mealPlans", "reviewReplies"})
    private Provider provider;

    @OneToMany(mappedBy = "meal", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties({"meal"})
    private List<MealPlanMeal> mealPlanMeal = new ArrayList<>();

    public Meal(){
    }

    public Meal(String name, BigDecimal price, String description, String image_url,String diet, String portion_size, Provider provider, List<MealPlanMeal> mealPlanMeal){
        this.name = name;
        this.price = price;
        this.description = description;
        this.image_url = image_url;
        this.diet = diet;
        this.portion_size = portion_size;
        this.provider = provider;
        this.mealPlanMeal = mealPlanMeal;

    }

    // setters and getters

    public void setMealId(Long meal_id){
        this.meal_id = meal_id;
    }

    public Long getMealId(){
        return meal_id;
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

    public void setImageUrl(String image_url){
        this.image_url = image_url;
    }

    public String getImageUrl(){
        return image_url;
    }

    public void setDiet(String diet){
        this.diet = diet;
    }

    public String getDiet(){
        return diet;
    }

    public void setPortionSize(String portion_size){
        this.portion_size = portion_size;
    }

    public String getPortionSize(){
        return portion_size;
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
