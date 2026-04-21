package com.example.backend_api_team10.service;

import com.example.backend_api_team10.entity.SubscriptionPlan;
import com.example.backend_api_team10.repository.SubscriptionPlanRepo;

import java.util.List;

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

    public List<SubscriptionPlan> getAllSubscriptionPlan(){
        return subscriptionPlanRepo.findAll();
    }

    public SubscriptionPlan getSubscriptionPlanById(Long plan_id){
        return subscriptionPlanRepo.findById(plan_id).orElse(null);
    }

    public List<SubscriptionPlan> getSubscriptionPlanByName(String name){
        return subscriptionPlanRepo.findByName(name);
    }

    public SubscriptionPlan updateSubscriptionPlan(@PathVariable String name, @RequestBody SubscriptionPlan updatedPlan){
        List<SubscriptionPlan> existing = subscriptionPlanRepo.findByName(updatedPlan.getName());
        if (existing != null && !existing.isEmpty()) {
            SubscriptionPlan plan = existing.get(0);
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


