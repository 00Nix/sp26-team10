package com.example.backend_api_team10.dto;

import java.math.BigDecimal;
import java.util.List;

public class AnalyticsSummaryDTO {
    
    private long totalSubscriptionPlans;
    private long totalCustomerSubscriptions;
    private long totalMealPlans;
    private long totalOrders;
    private BigDecimal totalRevenue;
    private String mostPopularSubscription;
    private List<DietCountDTO> mealPlansByDiet;

    public AnalyticsSummaryDTO(long totalSubscriptionPlans, long totalCustomerSubscriptions, long totalMealPlans, long totalOrders, BigDecimal totalRevenue, String mostPopularSubscription, List<DietCountDTO> mealPlansByDiet) {
        this.totalSubscriptionPlans = totalSubscriptionPlans;
        this.totalCustomerSubscriptions = totalCustomerSubscriptions;
        this.totalMealPlans = totalMealPlans;
        this.totalOrders = totalOrders;
        this.totalRevenue = totalRevenue;
        this.mostPopularSubscription = mostPopularSubscription;
        this.mealPlansByDiet = mealPlansByDiet;
    }

    public long getTotalSubscriptionPlans() {
        return totalSubscriptionPlans;
    }

    public long getTotalCustomerSubscriptions() {
        return totalCustomerSubscriptions;
    }

    public long getTotalMealPlans() {
        return totalMealPlans;
    }

    public long getTotalOrders() {
        return totalOrders;
    }

    public BigDecimal getTotalRevenue() {
        return totalRevenue;
    }

    public String getMostPopularSubscription() {
        return mostPopularSubscription;
    }

    public List<DietCountDTO> getMealPlansByDiet() {
        return mealPlansByDiet;
    }
}
