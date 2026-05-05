package com.example.backend_api_team10.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend_api_team10.dto.AnalyticsSummaryDTO;
import com.example.backend_api_team10.dto.DietCountDTO;
import com.example.backend_api_team10.repository.CustomerSubscriptionRepo;
import com.example.backend_api_team10.repository.MealPlanRepo;
import com.example.backend_api_team10.repository.OrderRepo;
import com.example.backend_api_team10.repository.SubscriptionPlanRepo;

@Service
public class AnalyticsService {
    
    @Autowired
    private SubscriptionPlanRepo subscriptionPlanRepo;

    @Autowired
    private CustomerSubscriptionRepo customerSubscriptionRepo;

    @Autowired
    private MealPlanRepo mealPlanRepo;

    @Autowired
    private OrderRepo orderRepo;

    public long getTotalSubscriptionPlans() {
        return subscriptionPlanRepo.count();
    }

    public long getTotalCustomerSubscriptions() {
        return customerSubscriptionRepo.count();
    }

    public long getTotalMealPlans() {
        return mealPlanRepo.count();
    }

    public long getTotalOrders() {
        return orderRepo.count();
    }

    public BigDecimal getTotalRevenue() {
        return orderRepo.getTotalRevenue();
    }

    public List<DietCountDTO> getMealPlansByDiet() {
        return mealPlanRepo.countMealPlansByDiet().stream().map(row -> new DietCountDTO((String) row[0], (Long) row[1])).toList();
    }

    public String getMostPopularSubscriptionPlan() {
        List<Object[]> results = customerSubscriptionRepo.countSubscriptionsByPlan();
        if (results.isEmpty()) {
            return "No subscriptions found";
        }
        return (String) results.get(0)[0];
    }

    public AnalyticsSummaryDTO getAnalyticsSummary() {
        long totalPlans = subscriptionPlanRepo.count();
        long totalSubs = customerSubscriptionRepo.count();
        long totalMeals = mealPlanRepo.count();
        long totalOrders = orderRepo.count();
        BigDecimal totalRevenue = orderRepo.getTotalRevenue();
        String mostPopular = getMostPopularSubscriptionPlan();
        List<DietCountDTO> dietStats = getMealPlansByDiet();

        return new AnalyticsSummaryDTO(totalPlans, totalSubs, totalMeals, totalOrders, totalRevenue, mostPopular, dietStats);
    }

}
