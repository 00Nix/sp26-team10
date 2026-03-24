package com.example.backend_api_team10.service;

import com.example.backend_api_team10.entity.SubscriptionPlan;
import com.example.backend_api_team10.repository.SubscriptionPlanRepo;

import java.util.concurrent.Flow.Subscription;

import org.springframework.stereotype.Service;

@Service
public class SubscriptionPlanService {
    
    private final SubscriptionPlanRepo subscriptionPlanRepo;

    public SubscriptionPlanService(SubscriptionPlanRepo subscriptionPlanRepo) {
        this.subscriptionPlanRepo = subscriptionPlanRepo;
    }

    public SubscriptionPlan createSubscriptionPlan(SubscriptionPlan subscriptionPlan) {
        return subscriptionPlanRepo.save(subscriptionPlan);
    }

    public List<SubscriptionPlan> getAllSubscriptionPlan(){
        return subscriptionPlanRepo.findAll();
    }

    public SubscriptionPlan getSubscriptionPlanById(Long plan_id){
        return subscriptionPlanRepo.findById(plan_id).orElse(null);
    }

    public SubscriptionPlan getSubscriptionPlanByName(String name){
        return subscriptionPlanRepo.findByName(name);
    }

    public SubscriptionPlan updateSubscriptionPlan(String name, SubscriptionPlan updatedPlan){
        SubscriptionPlan existing = subscriptionPlanRepo.findByName(updatedPlan.getName());
        if (existing != null) {
            existing.setPrice(updatedPlan.getPrice());
            existing.setDescription(updatedPlan.getDescription());
            existing.setFeatures(updatedPlan.getFeatures());
            existing.setDuration_weeks(updatedPlan.getDuration_weeks());
            return subscriptionPlanRepo.save(existing);
        } else {
            return null;
        }
    }

    public void deleteSubscriptionPlan(Long plan_id){
        subscriptionPlanRepo.deleteById(plan_id);
    }
}


