package com.example.backend_api_team10.service;

import com.example.backend_api_team10.entity.SubscriptionPlan;
import com.example.backend_api_team10.repository.SubscriptionPlanRepo;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

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

    public SubscriptionPlan updateSubscriptionPlan(@PathVariable Long plan_id, @RequestBody SubscriptionPlan updatedPlan){
        Optional<SubscriptionPlan> existing = subscriptionPlanRepo.findById(updatedPlan.getPlanId());
        if (existing.isPresent()) {
            SubscriptionPlan plan = existing.get();
            plan.setPrice(updatedPlan.getPrice());
            plan.setDescription(updatedPlan.getDescription());
            plan.setFeatures(updatedPlan.getFeatures());
            plan.setDurationWeeks(updatedPlan.getDurationWeeks());
            return subscriptionPlanRepo.save(plan);
        } else {
            return null;
        }
    }

    public void deleteSubscriptionPlan(Long plan_id){
        subscriptionPlanRepo.deleteById(plan_id);
    }
}


