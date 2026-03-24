package com.example.backend_api_team10.controller;

import com.example.backend_api_team10.entity.SubscriptionPlan;
import com.example.backend_api_team10.service.SubscriptionPlanService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/subscription-plans")
public class SubscriptionPlanController {
    
    private final SubscriptionPlanService subscriptionPlanService;

    public SubscriptionPlanController(SubscriptionPlanService subscriptionPlanService){
        this.subscriptionPlanService = subscriptionPlanService;
    }

    @GetMapping
    public List<SubscriptionPlan> getAllSubscriptionPlans(){
        return subscriptionPlanService.getAllSubscriptionPlans();
    }

    @GetMapping("/{name}")
    public SubscriptionPlan getSubscriptionPlanByName(){
        return subscriptionPlanService.getSubscriptionPlanByName();
    }

    @PostMapping
    public SubscriptionPlan createSubscriptionPlan(){
        return subscriptionPlanService.createSubscriptionPlan();
    }

    @PutMapping("/{name}")
    public SubscriptionPlan updateSubscriptionPlan(){
        return subscriptionPlanService.updateSubscriptionPlan();
    }

    @DeleteMapping("/{name}")
    public void deleteSubscriptionPlan(@PathVariable Long plan_id){
        subscriptionPlanService.deleteSubscriptionPlan(plan_id);
    }
}
    
