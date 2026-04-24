package com.example.backend_api_team10.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customer_id;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private Users user;

    private String phone;

    private Boolean subscribed;

    private String status;

    // Constructors
    public Customer() {}

    public Customer(Users user, String phone, Boolean subscribed, String status) {
        this.user = user;
        this.phone = phone;
        this.subscribed = subscribed;
        this.status = status;
    }

    // Getters & Setters

    public void setUser(Users user){
        this.user = user;
    }

    public Users getUser(){
        return user;
    }

    public Long getCustomerId() { return customer_id; }
    public void setCustomerId(Long customer_id) { this.customer_id = customer_id; }


    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public Boolean isSubscribed() { return subscribed; }
    public void setSubscribed(boolean subscribed) { this.subscribed = subscribed; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
