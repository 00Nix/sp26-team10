package com.example.backend_api_team10.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    private String password;

    private String phone;

    private boolean subscribed;

    private String status;

    // Constructors
    public Customer() {}

    public Customer(String name, String email, String password, String phone, boolean subscribed, String status) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.subscribed = subscribed;
        this.status = status;
    }

    // Getters & Setters
    public Long getCustomerId() { return customerId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public boolean isSubscribed() { return subscribed; }
    public void setSubscribed(boolean subscribed) { this.subscribed = subscribed; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
