package com.example.backend_api_team10.controller;

import com.example.backend_api_team10.dto.AnalyticsSummaryDTO;
import com.example.backend_api_team10.entity.SubscriptionPlan;
import com.example.backend_api_team10.service.AnalyticsService;
import com.example.backend_api_team10.service.SubscriptionPlanService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/provider")
public class ProviderUiController {
    
    private final AnalyticsService analyticsService;
    private final SubscriptionPlanService subscriptionPlanService;

    public ProviderUiController(AnalyticsService analyticsService, SubscriptionPlanService subscriptionPlanService) {
        this.analyticsService = analyticsService;
        this.subscriptionPlanService = subscriptionPlanService;
    }

    

}
