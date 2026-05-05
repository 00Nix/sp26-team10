package com.example.backend_api_team10.repository;

import com.example.backend_api_team10.entity.ReviewReply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReviewReplyRepo extends JpaRepository<ReviewReply, Long> {

    @Query("SELECT rr FROM ReviewReply rr WHERE rr.review.reviewId = :reviewId")
    List<ReviewReply> findByReviewId(Long reviewId);
    List<ReviewReply> findByReviewReviewId(Long reviewId);
}