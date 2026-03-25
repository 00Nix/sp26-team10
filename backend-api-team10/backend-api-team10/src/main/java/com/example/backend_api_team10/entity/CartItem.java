package com.example.backend_api_team10.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table(name = "cart_items")
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId;

    @ManyToOne
    @JoinColumn(name = "cart_id", nullable = false)
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "meal_id")
    private Meal meal;

    @ManyToOne
    @JoinColumn(name = "plan_id")
    private MealPlan mealPlan;

    private int quantity;

    public CartItem() {}

    public CartItem(Cart cart, Meal meal, MealPlan mealPlan, int quantity) {
        this.cart = cart;
        this.meal = meal;
        this.mealPlan = mealPlan;
        this.quantity = quantity;        
    }
    public Long getItemId() {
        return itemId;
    }
    public Cart getCart() {
        return cart;
    }
    public void setCart(Cart cart) {
        this.cart = cart;
    }
    public Meal getMeal() {
        return meal;
    }
    public void setMeal(Meal meal) {
        this.meal = meal;
    }
    public MealPlan getMealPlan() {
        return mealPlan;
    }
    public void setMealPlan(MealPlan mealPlan) {
        this.mealPlan = mealPlan;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
}
