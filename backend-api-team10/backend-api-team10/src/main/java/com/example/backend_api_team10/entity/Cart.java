package com.example.backend_api_team10.entity;


import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue; 
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;

    //one cart per customer
    @OneToOne
    @JoinColumn(name = "customer_id", nullable = false, unique = true)
    private Customer customer;

    private BigDecimal subtotal;

    //constructors
    public Cart() {}

    public Cart(Customer customer, BigDecimal subtotal) {
        this.customer = customer;
        this.subtotal = subtotal;
    }

    //getters and setters
    public Long getCartId() { return cartId; }

    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }

    public BigDecimal getSubtotal() { return subtotal; }
    public void setSubtotal(BigDecimal subtotal) { this.subtotal = subtotal; }
}