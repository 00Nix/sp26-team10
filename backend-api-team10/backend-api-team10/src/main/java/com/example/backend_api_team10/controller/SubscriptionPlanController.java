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
        return subscriptionPlanService.getAllSubscriptionPlans();
    }

    @GetMapping("/{name}")
    public List<SubscriptionPlan> getSubscriptionPlanByName(@PathVariable String name){
        return subscriptionPlanService.getSubscriptionPlanByName(name);
    }

    @PostMapping
    public SubscriptionPlan createSubscriptionPlan(@RequestBody SubscriptionPlan subscriptionPlan){
        return subscriptionPlanService.createSubscriptionPlan(subscriptionPlan);
    }

    @PutMapping("/{plan_id}")
    public SubscriptionPlan updateSubscriptionPlan(@PathVariable Long plan_id, @RequestBody SubscriptionPlan updatedPlan){
        return subscriptionPlanService.updateSubscriptionPlan(plan_id, updatedPlan);
    }

    @DeleteMapping("/{plan_id}")
    public void deleteSubscriptionPlan(@PathVariable Long plan_id){
        subscriptionPlanService.deleteSubscriptionPlan(plan_id);
    }
}
    
