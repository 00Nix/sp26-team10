package com.example.backend_api_team10.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "favorites")
public class Favorite {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long favoriteId;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "meal_id", nullable = false)
    private Meal meal;

    public Favorite() {}

    public Favorite(Customer customer, Meal meal) {
        this.customer = customer;
        this.meal = meal;
    }

    public Long getFavoriteId() {
        return favoriteId;
    }
    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public Meal getMeal() {
        return meal;
    }
    public void setMeal(Meal meal) {
        this.meal = meal;
    }


    
}
