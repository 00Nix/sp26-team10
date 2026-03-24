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
 
    public Review createForSubscribedCustomer(Long customerId, Review review) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
 
        boolean isSubscribed = !customerSubscriptionRepo.findByCustomerId(customerId).isEmpty();
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
 
    public Optional<Review> getReviewById(Long id) {
        return reviewRepository.findById(id);
    }
 
    public Review updateReview(Long id, Review updatedReview) {
        return reviewRepository.findById(id)
                .map(review -> {
                    review.setRating(updatedReview.getRating());
                    review.setDescription(updatedReview.getDescription());
                    review.setDate(updatedReview.getDate());
                    review.setCustomer(updatedReview.getCustomer());
                    return reviewRepository.save(review);
                })
                .orElseThrow(() -> new RuntimeException("Review not found"));
    }
 
    public boolean deleteReview(Long id) {
        Optional<Review> optionalReview = reviewRepository.findById(id);
        if (!optionalReview.isPresent()) {
            return false;
        }
        reviewRepository.delete(optionalReview.get());
        return true;
    }
}