package com.example.backend_api_team10.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.backend_api_team10.entity.Review;

@Repository
public interface ReviewRepo extends JpaRepository<Review, Long> {

    List<Review> findByOrderId(Long orderId);
    List<Review> findByRating(Integer rating);
}
