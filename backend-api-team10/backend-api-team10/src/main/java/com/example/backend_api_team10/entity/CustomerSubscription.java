package com.example.backend_api_team10.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "customer_subscription")
public class CustomerSubscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customer_sub_id;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    @JsonIgnoreProperties({"email","password", "phone","favorite", "cart", "order"})
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "plan_id", nullable = false)
    @JsonIgnoreProperties({"customerSubscriptions", "name","price", "description", "features", "duration_weeks", "durationWeeks"})
    private SubscriptionPlan subscriptionPlan;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(nullable = false)
    private String status;

    public CustomerSubscription(){
    }

    public CustomerSubscription(Customer customer, SubscriptionPlan subscriptionPlan, LocalDate startDate, LocalDate endDate, String status){
        this.customer = customer;
        this.subscriptionPlan = subscriptionPlan;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }

    // setters and getters

    public void setCustomerSubId(Long customer_sub_id){
        this.customer_sub_id = customer_sub_id;
    }

    public Long getCustomerSubId(){
        return customer_sub_id;
    }

    public void setCustomer(Customer customer){
        this.customer = customer;
    }

    public Customer getCustomer(){
        return customer;
    }

    public void setSubscriptionPlan(SubscriptionPlan subscriptionPlan){
        this.subscriptionPlan  = subscriptionPlan;
    }
    
    public SubscriptionPlan getSubscriptionPlan(){
        return subscriptionPlan;
    }

    public void setStartDate(LocalDate startDate){
        this.startDate = startDate;
    }

    public LocalDate getStartDate(){
        return startDate;
    }

    public void setEndDate(LocalDate endDate){
        this.endDate = endDate;
    }

    public LocalDate getEndDate(){
        return endDate;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public String getStatus(){
        return status;
    }
}
