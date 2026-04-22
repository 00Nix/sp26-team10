package com.example.backend_api_team10.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "provider")
public class Provider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long provider_id;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;


    @Column(nullable = false)
    private String name;

    private String phone;

    @Column(length = 1000)
    private String biography;

    @OneToMany(mappedBy = "provider", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("provider")
    private List<Meal> meals = new ArrayList<>();

    @OneToMany(mappedBy = "provider", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("provider")
    private List<MealPlan> mealPlans = new ArrayList<>();

    @OneToMany(mappedBy = "provider", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("provider")
    private List<ReviewReply> reviewReplies = new ArrayList<>();

    public Provider() {
    }

    public Provider(User user, String name, String phone, String biography) {
        this.user = user;
        this.name = name;
        this.phone = phone;
        this.biography = biography;
    }

    // setters and getters

    public void setUser(User user){
        this.user = user;
    }

    public User getUser(){
        return user;
    }

    public void setProviderId(Long provider_id){
        this.provider_id = provider_id;
    }

    public Long getProviderId(){
        return provider_id;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }

    public String getPhone(){
        return phone;
    }

    public void setBiography(String biography){
        this.biography = biography;
    }

    public String getBiography(){
        return biography;
    }

    public void setMeals(List<Meal> meals){
        this.meals = meals;
    }

    public List<Meal> getMeals(){
        return meals;
    }

    public void setMealPlans(List<MealPlan> mealPlans){
        this.mealPlans = mealPlans;
    }

    public List<MealPlan> getMealPlans(){
        return mealPlans;
    }
    
    public void setReviewReplies(List<ReviewReply> reviewReplies){
        this.reviewReplies = reviewReplies;
    }

    public List<ReviewReply> getReviewReplies(){
        return reviewReplies;
    }
}
