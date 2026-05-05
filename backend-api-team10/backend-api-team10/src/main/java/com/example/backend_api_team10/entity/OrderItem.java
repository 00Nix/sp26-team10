package com.example.backend_api_team10.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "order_item")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_item_id") 
    private Long orderItemId;

    @Column(name = "order_id", nullable = false)
    private Long orderId;

    @ManyToOne
    @JoinColumn(name = "meal_id", nullable = false)
    private Meal meal;

    @ManyToOne
    @JoinColumn(name = "plan_id", nullable = false)
    private SubscriptionPlan plan;

    @Column(nullable = false)
    private Integer quantity;

    @Column(name = "item_total", nullable = false)
    private BigDecimal itemTotal;

    public OrderItem() {
    }
    public OrderItem(Long orderId, Meal meal, SubscriptionPlan plan,
        Integer quantity, BigDecimal itemTotal) {

            this.orderId = orderId;
            this.meal = meal;
            this.plan = plan;
            this.quantity = quantity;
            this.itemTotal = itemTotal;

        }
    public Long getOrderItemId() {
        return orderItemId;
    }
    public Long getOrderId() {
        return orderId;
    }
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
    public Meal getMeal() {
        return meal;
    }
    public void setMeal(Meal meal) {
        this.meal = meal;
    }
    public SubscriptionPlan getPlan() {
        return plan;
    }
    public void setPlan(SubscriptionPlan plan) {
        this.plan = plan;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    public BigDecimal getItemTotal() {
        return itemTotal;
    }
    public void setItemTotal(BigDecimal itemTotal) {
        this.itemTotal = itemTotal;
    }
    
    
    


    
}
