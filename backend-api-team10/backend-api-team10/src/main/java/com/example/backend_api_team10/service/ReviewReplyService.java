package com.example.backend_api_team10.service;

import com.example.backend_api_team10.entity.ReviewReply;
import com.example.backend_api_team10.entity.Review;
import com.example.backend_api_team10.entity.Provider;
import com.example.backend_api_team10.repository.ReviewReplyRepo;

import java.util.List;
import java.time.LocalDate;

import org.springframework.stereotype.Service;

@Service
public class ReviewReplyService {
  
    private final ReviewReplyRepo reviewReplyRepo;
    
    public ReviewReplyService(ReviewReplyRepo reviewReplyRepo) {
        this.reviewReplyRepo = reviewReplyRepo;
    }

    public ReviewReply createReviewReply(Review review, Provider provider, String message) {
        ReviewReply reply = new ReviewReply();

        reply.setReview(review);
        reply.setProvider(provider);
        reply.setMessage(message);
        reply.setReply_date(LocalDate.now());
        return reviewReplyRepo.save(reply);
        
    }

    public List<ReviewReply> getAllReviewReplies() {
        return reviewReplyRepo.findAll();
    }

    public ReviewReply getReviewReplyById(Long reply_id) {
        return reviewReplyRepo.findById(reply_id).orElse(null);
    }

    public ReviewReply updateReviewReply(Long reply_id, ReviewReply updatedReply) {
        ReviewReply existing = reviewReplyRepo.findById(reply_id).orElse(null);
        if (existing != null) {
            existing.setMessage(updatedReply.getMessage());
            existing.setReview(updatedReply.getReview());
            existing.setReply_date(LocalDate.now());
            return reviewReplyRepo.save(existing);
        } else {
            return null;
        }
    }

    public void deleteReviewReply(Long reply_id) {
        reviewReplyRepo.deleteById(reply_id);
    }
    
}