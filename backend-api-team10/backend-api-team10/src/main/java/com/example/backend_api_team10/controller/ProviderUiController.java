package com.example.backend_api_team10.controller;

import java.util.List;
import java.util.Optional;

import com.example.backend_api_team10.dto.AnalyticsSummaryDTO;
import com.example.backend_api_team10.entity.SubscriptionPlan;
import com.example.backend_api_team10.entity.Order;
import com.example.backend_api_team10.entity.Review;
import com.example.backend_api_team10.entity.Meal;
import com.example.backend_api_team10.entity.MealPlan;
import com.example.backend_api_team10.entity.Provider;
import com.example.backend_api_team10.service.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/provider")
public class ProviderUiController {
    
    private final AnalyticsService analyticsService;
    private final SubscriptionPlanService subscriptionPlanService;
    private final OrderService orderService;
    private final ReviewService reviewService;
    private final ReviewReplyService reviewReplyService;
    private final MealService mealService;
    private final MealPlanService mealPlanService;
    private final ProviderService providerService;

    public ProviderUiController(AnalyticsService analyticsService, SubscriptionPlanService subscriptionPlanService, OrderService orderService, ReviewService reviewService, ReviewReplyService reviewReplyService, MealService mealService, MealPlanService mealPlanService, ProviderService providerService) {
        this.analyticsService = analyticsService;
        this.subscriptionPlanService = subscriptionPlanService;
        this.orderService = orderService;
        this.reviewService = reviewService;
        this.reviewReplyService = reviewReplyService;
        this.mealService = mealService;
        this.mealPlanService = mealPlanService;
        this.providerService = providerService;
    }

    // dashboard    
    @GetMapping("/dashboard")
    public String showDashboard(Model model) {
        model.addAttribute("dashboard", "Provider Dashboard");
       
        return "provider/dashboard";
    }

    // order management
    @GetMapping("/orders")
    public String showOrders(Model model) {
        List<Order> orders = orderService.getAllOrders();
        model.addAttribute("orders", orders);
        
        return "provider/orders";
    }

    @GetMapping("/orders/{orderId}/edit")
    public String showEditOrderForm(@PathVariable Long orderId, Model model) {
        Optional<Order> order = orderService.getOrderById(orderId);
        model.addAttribute("order", order);
        
        return "provider/edit-order-status";
    }

    @PostMapping("/orders/{orderId}/update-status") 
    public String updateOrderStatus(@PathVariable Long orderId, @RequestParam("status") String status) {
        orderService.updateOrderStatus(orderId, status);
        
        return "redirect:/provider/orders";
    }

    // review management
    @GetMapping("/reviews")
    public String showReviews(Model model) {
        List<Review> reviews = reviewService.getAllReviews();
        model.addAttribute("reviews", reviews);
        
        return "provider/reviews";
    }

    @GetMapping("/reviews/{reviewId}/reply")
    public String showReplyForm(@PathVariable Long reviewId, Model model) {
        Optional<Review> review = reviewService.getReviewById(reviewId);
        model.addAttribute("review", review);
       
        return "provider/reply-review";
    }

    @PostMapping("/reviews/{reviewId}/reply")
    public String replyToReview(@PathVariable Review review, @PathVariable Provider provider, @RequestParam("message") String message) {
        reviewReplyService.createReviewReply(review, provider, message);
      
        return "redirect:/provider/reviews";
    }

    // meal management
    @GetMapping("/meals")
    public String showMeals(Model model) {
        model.addAttribute("meals", mealService.getAllMeals());
        
        return "provider/meals";
    }

    @GetMapping("/meals/add")
    public String showAddMealForm(Model model) {
        model.addAttribute("meal", new Meal());

        return "provider/add-meal";
    }

    @PostMapping("/meals/add")
    public String addMeal(@ModelAttribute Meal meal) {
        mealService.createMeal(meal);

        return "redirect:/provider/meals";
    }

    @GetMapping("/meals/{meal_id}/edit")
    public String showEditMealForm(@PathVariable Long meal_id, Model model) {
        Meal meal = mealService.getMealById(meal_id);
        model.addAttribute("meal", meal);

        return "provider/edit-meal";
    }

    @PostMapping("/meals/{meal_id}/update")
    public String updateMeal(@PathVariable Long meal_id, @ModelAttribute Meal updatedMeal) {
        mealService.updateMeal(meal_id, updatedMeal);

        return "redirect:/provider/meals";
    }

    @DeleteMapping("/meals/{meal_id}")
    public String deleteMeal(@PathVariable Long meal_id) {
        mealService.deleteMeal(meal_id);

        return "redirect:/provider/meals";
    }

    // meal plan management
    @GetMapping("/mealplanss")
    public String showMealPlanss(Model model) {
        model.addAttribute("mealPlans", mealPlanService.getAllMealPlans());
        
        return "provider/mealplans";
    }

    @GetMapping("/mealplans/add")
    public String showAddMealPlanForm(Model model) {
        model.addAttribute("mealPlan", new MealPlan());

        return "provider/add-mealplan";
    }

    @PostMapping("/mealplans/add")
    public String addMealPlan(@ModelAttribute MealPlan mealPlan) {
        mealPlanService.createMealPlan(mealPlan);

        return "redirect:/provider/mealplans";
    }

    @GetMapping("/mealplans/{plan_id}/edit")
    public String showEditMealPlanForm(@PathVariable Long plan_id, Model model) {
        MealPlan mealPlan = mealPlanService.getMealPlanById(plan_id);
        model.addAttribute("mealPlan", mealPlan);

        return "provider/edit-meal";
    }

    @PostMapping("/mealplans/{plan_id}/update")
    public String updateMealPlan(@PathVariable Long plan_id, @ModelAttribute MealPlan updatedMealPlan) {
        mealPlanService.updateMealPlan(plan_id, updatedMealPlan);

        return "redirect:/provider/mealplans";
    }

    @DeleteMapping("/mealplans/{plan_id}")
    public String deleteMealPlan(@PathVariable Long plan_id) {
        mealPlanService.deleteMealPlan(plan_id);

        return "redirect:/provider/meals";
    }

    // subscription plan management
    @GetMapping("/subscriptions")
    public String showSubscriptions(Model model) {
        model.addAttribute("subscriptions", subscriptionPlanService.getAllSubscriptionPlans());
        return "provider/subscriptions";
    }

    @GetMapping("/subscriptions/{plan_id}/edit")
    public String showEditSubscriptionForm(@PathVariable Long plan_id, Model model) {
        SubscriptionPlan plan = subscriptionPlanService.getSubscriptionPlanById(plan_id);
        model.addAttribute("subscription", plan);

        return "provider/edit-subscription";
    }

    @PostMapping("/subscriptions/{plan_id}/update")
    public String updateSubscription(@PathVariable Long plan_id, @ModelAttribute SubscriptionPlan updatedPlan) {
        subscriptionPlanService.updateSubscriptionPlan(plan_id, updatedPlan);

        return "redirect:/provider/subscriptions";
    }

    // analytics dashboard
    @GetMapping("/analytics")
    public String showAnalytics(Model model) {
        AnalyticsSummaryDTO analytics = analyticsService.getAnalyticsSummary();

        model.addAttribute("analytics", analytics);
        model.addAttribute("dietStats", analytics.getMealPlansByDiet());

        return "provider/analytics";
    }

    // profile management
    @GetMapping("/provider/profile")
    public String providerProfile() {
        return "provider/profile";
    }

    @GetMapping("/profile/{provider_id}/edit")
    public String showEditProfileForm(@PathVariable Long provider_id, Model model) {
        Provider provider = providerService.getProviderById(provider_id);
        model.addAttribute("provider", provider);

        return "provider/edit-profile";
    }

    @PostMapping("/profile/{provider_id}/update")
    public String updateProfile(@PathVariable Long provider_id, @ModelAttribute Provider updatedProvider) {
        providerService.updateProvider(provider_id, updatedProvider);

        return "redirect:/provider/dashboard";
    }
 
}
