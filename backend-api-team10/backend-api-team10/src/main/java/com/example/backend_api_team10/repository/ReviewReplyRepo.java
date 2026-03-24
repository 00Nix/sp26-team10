package com.example.backend_api_team10.repository;

import com.example.backend_api_team10.entity.ReviewReply;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ReviewReplyRepo extends JpaRepository<ReviewReply, Long> {
    List<ReviewReply> findByReviewId(Long reviewId);
}
