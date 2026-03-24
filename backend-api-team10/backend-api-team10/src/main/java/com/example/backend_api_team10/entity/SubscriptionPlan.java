package com.example.backend_api_team10.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "subscription_plan")
public class SubscriptionPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subscription_id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @Column(nullable = false, length = 1000)
    private String description;

    @Column(nullable = false, length = 1000)
    private String features;

    @Column(nullable = false)
    private int duration_weeks;

    @OneToMany(mappedBy = "subscriptionPlan", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties({"subscriptionPlan"})
    private List<CustomerSubscription> customerSubscriptions = new ArrayList<>();

    public SubscriptionPlan(){
    }

    public SubscriptionPlan(String name, BigDecimal price, String description, String features, int duration_weeks){
        this.name = name;
        this.price = price;
        this.description = description;
        this.features = features;
        this.duration_weeks = duration_weeks;
    }

    // setters and getters

    public void setSubscriptionId(Long subscription_id){
        this.subscription_id = subscription_id;
    }

    public Long getSubscriptionId(){
        return subscription_id;
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

    public void setFeatures(String features){
        this.features = features;
    }

    public String getFeatures(){
        return features;
    }

    public void setDurationWeeks(int duration_weeks){
        this.duration_weeks = duration_weeks;
    }

    public int getDurationWeeks(){
        return duration_weeks;
    }

    public void setCustomerSubscriptions(List<CustomerSubscription> customerSubscriptions){
        this.customerSubscriptions = customerSubscriptions;
    }

    public List<CustomerSubscription> getCustomerSubscriptions(){
        return customerSubscriptions;
    }
}
