package com.example.backend_api_team10.service;

import com.example.backend_api_team10.entity.ReviewReply;
import com.example.backend_api_team10.repository.ReviewReplyRepo;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ReviewReplyService {
  
    private final ReviewReplyRepo reviewReplyRepo;
    
    public ReviewReplyService(ReviewReplyRepo reviewReplyRepo) {
        this.reviewReplyRepo = reviewReplyRepo;
    }

    public ReviewReply createReviewReply(ReviewReply reviewReply) {
        return reviewReplyRepo.save(reviewReply);
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
            existing.setContent(updatedReply.getContent());
            existing.setReview(updatedReply.getReview());
            return reviewReplyRepo.save(existing);
        } else {
            return null;
        }
    }

    public void deleteReviewReply(Long reply_id) {
        reviewReplyRepo.deleteById(reply_id);
    }
    
}