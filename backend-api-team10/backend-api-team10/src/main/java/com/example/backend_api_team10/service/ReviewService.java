package com.example.backend_api_team10.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend_api_team10.entity.Customer;
import com.example.backend_api_team10.entity.Review;
import com.example.backend_api_team10.repository.CustomerRepo;
import com.example.backend_api_team10.repository.CustomerSubscriptionRepo;
import com.example.backend_api_team10.repository.ReviewRepo;

@Service
public class ReviewService {

	private final ReviewRepo reviewRepository;
 
    @Autowired
    private CustomerRepo customerRepository;
 
    @Autowired
    private CustomerSubscriptionRepo customerSubscriptionRepo;
 
    public ReviewService(ReviewRepo reviewRepository) {
        this.reviewRepository = reviewRepository;
    }
 
    public Review createReview(Review review) {
        if (review.getRating() < 1 || review.getRating() > 5) {
            return null;
        }
        return reviewRepository.save(review);
    }
 
    public Review createForSubscribedCustomer(Long customer_id, Review review) {
        Customer customer = customerRepository.findById(customer_id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
 
        boolean isSubscribed = !customerSubscriptionRepo.findByCustomerId(customer_id).isEmpty();
        if (!isSubscribed) {
            throw new RuntimeException("Customer has no active subscriptions and cannot post a review");
        }
 
        if (review.getRating() < 1 || review.getRating() > 5) {
            throw new RuntimeException("Rating must be between 1 and 5");
        }
 
        review.setCustomer(customer);
        return reviewRepository.save(review);
    }
 
    public List<Review> getReviewsByOrderId(Long orderId) {
        return reviewRepository.findByOrderId(orderId);
    }
 
    public List<Review> getReviewsByRating(Integer rating) {
        return reviewRepository.findByRating(rating);
    }
 
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }
 
    public Optional<Review> getReviewById(Long reviewId) {
        return reviewRepository.findById(reviewId);
    }
 
    public Review updateReview(Long reviewId, Review updatedReview) {
        return reviewRepository.findById(reviewId)
                .map(review -> {
                    review.setRating(updatedReview.getRating());
                    review.setDescription(updatedReview.getDescription());
                    review.setDate(updatedReview.getDate());
                    review.setCustomer(updatedReview.getCustomer());
                    return reviewRepository.save(review);
                })
                .orElseThrow(() -> new RuntimeException("Review not found"));
    }
 
    public boolean deleteReview(Long reviewId) {
        Optional<Review> optionalReview = reviewRepository.findById(reviewId);
        if (!optionalReview.isPresent()) {
            return false;
        }
        reviewRepository.delete(optionalReview.get());
        return true;
    }
}