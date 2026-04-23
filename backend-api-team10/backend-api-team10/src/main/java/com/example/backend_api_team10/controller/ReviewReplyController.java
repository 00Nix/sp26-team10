package com.example.backend_api_team10.controller;

import com.example.backend_api_team10.entity.ReviewReply;
import com.example.backend_api_team10.entity.Review;
import com.example.backend_api_team10.entity.Provider;
import com.example.backend_api_team10.service.ReviewReplyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/review-replies")
public class ReviewReplyController {
    
    private final ReviewReplyService reviewReplyService;

    public ReviewReplyController(ReviewReplyService reviewReplyService){
        this.reviewReplyService = reviewReplyService;
    }

    @GetMapping
    public List<ReviewReply> getAllReviewReplies(){
        return reviewReplyService.getAllReviewReplies();
    }

    @GetMapping("/{reply_id}")
    public ReviewReply getReviewReplyById(@PathVariable Long reply_id){
        return reviewReplyService.getReviewReplyById(reply_id);
    }

    @PostMapping
    public ReviewReply createReviewReply(@RequestBody Review review, @RequestBody Provider provider, @RequestParam String message){
        ReviewReply reviewReply = new ReviewReply();
        reviewReply.setReview(review);
        reviewReply.setProvider(provider);
        reviewReply.setMessage(message);
        return reviewReplyService.createReviewReply(review, provider, message);
    }

    @DeleteMapping("/{reply_id}")
    public void deleteReviewReply(@PathVariable Long reply_id){
        reviewReplyService.deleteReviewReply(reply_id);
    }

}
