package com.example.backend_api_team10.entity;


import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "reviews")
public class Review {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private Long reviewId;
 
    @Column(name = "order_id", nullable = false)
    private Long orderId;
 
    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;
 
    @Column(name = "date", nullable = false)
    private LocalDate date;
 
    @Column(name = "rate", nullable = false)
    private int rating;
 
    @Column(name = "description", length = 1000)
    private String description;
 
    public Review() {
    }
 
    public Review(Long reviewId, Long orderId, Customer customer,
                  LocalDate date, int rating, String description) {
        this.reviewId = reviewId;
        this.orderId = orderId;
        this.customer = customer;
        this.date = date;
        this.rating = rating;
        this.description = description;
    }
 
    public Long getReviewId() { return reviewId; }
    public void setReviewId(Long reviewId) { this.reviewId = reviewId; }
 
    public Long getOrderId() { return orderId; }
    public void setOrderId(Long orderId) { this.orderId = orderId; }
 
    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }
 
    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }
 
    public int getRating() { return rating; }
    public void setRating(int rating) { this.rating = rating; }
 
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}