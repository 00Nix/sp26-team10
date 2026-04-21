package com.example.backend_api_team10.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "review_replies")
public class ReviewReply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reply_id;

    @OneToOne
    @JoinColumn(name= "review_id", nullable = false)
    @JsonIgnoreProperties({"reviewReply"})
    private Review review;

    @ManyToOne
    @JoinColumn(name = "provider_id", nullable = false)
    @JsonIgnoreProperties({"meal", "mealPlan", "reviewReply"})
    private Provider provider;

    @Column(nullable = false, length = 1000)
    private String message;

    @Column(nullable = false)
    private LocalDate reply_date;

    public ReviewReply(){
    }

    public ReviewReply(Review review, Provider provider, String message, LocalDate reply_date){
        this.review = review;
        this.provider = provider;
        this.message = message;
        this.reply_date = reply_date;
    }

    // setters and getters
    public Long getReply_id() {
        return reply_id;
    }

    public void setReply_id(Long reply_id) {
        this.reply_id = reply_id;
    }

    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review = review;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDate getReply_date() {
        return reply_date;
    }

    public void setReply_date(LocalDate reply_date) {
        this.reply_date = reply_date;
    }
}
