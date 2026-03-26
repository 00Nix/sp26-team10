package com.example.backend_api_team10.controller;

import com.example.backend_api_team10.entity.SubscriptionPlan;
import com.example.backend_api_team10.service.SubscriptionPlanService;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/subscription-plans")
public class SubscriptionPlanController {
    
    private final SubscriptionPlanService subscriptionPlanService;

    public SubscriptionPlanController(SubscriptionPlanService subscriptionPlanService){
        this.subscriptionPlanService = subscriptionPlanService;
    }

    @GetMapping
    public List<SubscriptionPlan> getAllSubscriptionPlans(){
        return subscriptionPlanService.getAllSubscriptionPlan();
    }

    @GetMapping("/{name}")
    public List<SubscriptionPlan> getSubscriptionPlanByName(@PathVariable String name){
        return subscriptionPlanService.getSubscriptionPlanByName(name);
    }

    @PostMapping
    public SubscriptionPlan createSubscriptionPlan(SubscriptionPlan subscriptionPlan){
        return subscriptionPlanService.createSubscriptionPlan(subscriptionPlan);
    }

    @PutMapping("/{name}")
    public SubscriptionPlan updateSubscriptionPlan(@PathVariable String name, SubscriptionPlan updatedPlan){
        return subscriptionPlanService.updateSubscriptionPlan(name, updatedPlan);
    }

    @DeleteMapping("/{name}")
    public void deleteSubscriptionPlan(@PathVariable Long plan_id){
        subscriptionPlanService.deleteSubscriptionPlan(plan_id);
    }
}
    
