package com.example.backend_api_team10.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "customer_subscription")
public class CustomerSubscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customer_sub_id;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    @JsonIgnoreProperties({"favorite", "cart", "order"})
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "subscription_id", nullable = false)
    @JsonIgnoreProperties("customerSubscriptions")
    private SubscriptionPlan subscriptionPlan;

    @Column(nullable = false)
    private LocalDate start_date;

    private LocalDate end_date;

    @Column(nullable = false)
    private String status;

    public CustomerSubscription(){
    }

    public CustomerSubscription(Customer customer, SubscriptionPlan subscriptionPlan, LocalDate start_date, LocalDate end_date, String status){
        this.customer = customer;
        this.subscriptionPlan = subscriptionPlan;
        this.start_date = start_date;
        this.end_date = end_date;
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

    public void setStartDate(LocalDate start_date){
        this.start_date = start_date;
    }

    public LocalDate getStartDate(){
        return start_date;
    }

    public void setEndDate(LocalDate end_date){
        this.end_date = end_date;
    }

    public LocalDate getEnDate(){
        return end_date;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public String getStatus(){
        return status;
    }
}
