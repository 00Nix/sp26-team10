package com.example.backend_api_team10.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend_api_team10.entity.Review;
import com.example.backend_api_team10.service.ReviewService;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping
    public Review createReview(@RequestBody Review review) {
        return reviewService.createReview(review);
    }

    @GetMapping
    public List<Review> getAllReviews() {
        return reviewService.getAllReviews();
    }

    @GetMapping("/{id}")
    public Review getReviewById(@PathVariable("id") Long reviewId) {
        return reviewService.getReviewById(reviewId)
                .orElseThrow(() -> new RuntimeException("Review not found"));
    }

    @PutMapping("/{id}")
    public Review updateReview(@PathVariable("id") Long reviewId, @RequestBody Review review) {
        return reviewService.updateReview(reviewId, review);
    }

    @DeleteMapping("/{id}")
    public boolean deleteReview(@PathVariable("id") Long reviewId) {
        return reviewService.deleteReview(reviewId );
    }
 
    @GetMapping("/order/{orderId}")
    public List<Review> getReviewsByOrderId(@PathVariable("orderId") Long orderId) {
        return reviewService.getReviewsByOrderId(orderId);
    }
 
    @GetMapping("/rating/{rating}")
    public List<Review> getReviewsByRating(@PathVariable("rating") Integer rating) {
        return reviewService.getReviewsByRating(rating);
    }
}