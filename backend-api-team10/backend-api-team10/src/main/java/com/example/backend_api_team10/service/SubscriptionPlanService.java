package com.example.backend_api_team10.service;

import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.backend_api_team10.entity.SubscriptionPlan;
import com.example.backend_api_team10.repository.SubscriptionPlanRepo;

@Service
public class SubscriptionPlanService {
    
    private final SubscriptionPlanRepo subscriptionPlanRepo;

    public SubscriptionPlanService(SubscriptionPlanRepo subscriptionPlanRepo) {
        this.subscriptionPlanRepo = subscriptionPlanRepo;
    }

    public SubscriptionPlan createSubscriptionPlan(SubscriptionPlan subscriptionPlan) {
        return subscriptionPlanRepo.save(subscriptionPlan);
    }

    public List<SubscriptionPlan> getAllSubscriptionPlans(){
        return subscriptionPlanRepo.findAll();
    }

    public SubscriptionPlan getSubscriptionPlanById(Long plan_id){
        return subscriptionPlanRepo.findById(plan_id).orElse(null);
    }

    public List<SubscriptionPlan> getSubscriptionPlanByName(String name){
        return subscriptionPlanRepo.findByName(name);
    }

    public SubscriptionPlan updateSubscriptionPlan(@PathVariable Long planId, @RequestBody SubscriptionPlan updatedPlan){
        SubscriptionPlan existing = subscriptionPlanRepo.findById(planId).orElseThrow(() -> new RuntimeException("Subscription plan not found with id: " + planId));

        
        existing.setName(updatedPlan.getName());
        existing.setPrice(updatedPlan.getPrice());
        existing.setDescription(updatedPlan.getDescription());
        existing.setDurationWeeks(updatedPlan.getDurationWeeks());
        existing.setFeatures(updatedPlan.getFeatures());

    return subscriptionPlanRepo.save(existing);
            
    }

    public void deleteSubscriptionPlan(Long plan_id){
        subscriptionPlanRepo.deleteById(plan_id);
    }
}


