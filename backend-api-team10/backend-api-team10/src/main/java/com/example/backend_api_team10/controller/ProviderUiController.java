package com.example.backend_api_team10.controller;

import java.util.List;
import java.util.Optional;

import com.example.backend_api_team10.dto.AnalyticsSummaryDTO;
import com.example.backend_api_team10.entity.*;
import com.example.backend_api_team10.service.*;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/provider")
public class ProviderUiController {
    
    private final MealPlanMealService mealPlanMealService;
    private final AnalyticsService analyticsService;
    private final CustomerService customerService;
    private final SubscriptionPlanService subscriptionPlanService;
    private final OrderService orderService;
    private final ReviewService reviewService;
    private final ReviewReplyService reviewReplyService;
    private final MealService mealService;
    private final MealPlanService mealPlanService;
    private final ProviderService providerService;

    public ProviderUiController(AnalyticsService analyticsService, CustomerService customerService, SubscriptionPlanService subscriptionPlanService, OrderService orderService, ReviewService reviewService, ReviewReplyService reviewReplyService, MealService mealService, MealPlanService mealPlanService, ProviderService providerService, MealPlanMealService mealPlanMealService) {
        this.analyticsService = analyticsService;
        this.customerService = customerService;
        this.subscriptionPlanService = subscriptionPlanService;
        this.orderService = orderService;
        this.reviewService = reviewService;
        this.reviewReplyService = reviewReplyService;
        this.mealService = mealService;
        this.mealPlanService = mealPlanService;
        this.providerService = providerService;
        this.mealPlanMealService = mealPlanMealService;
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
    
        long totalOrders = orders.size();
        long pendingOrders = orders.stream().filter(order -> "PENDING".equalsIgnoreCase(order.getStatus())).count();
        long preparingOrders = orders.stream().filter(order -> "PREPARING".equalsIgnoreCase(order.getStatus())).count();
        long inTransitOrders = orders.stream().filter(order -> "IN TRANSIT".equalsIgnoreCase(order.getStatus())).count();
        long deliveredOrders = orders.stream().filter(order -> "DELIVERED".equalsIgnoreCase(order.getStatus())).count();
        long cancelledOrders = orders.stream().filter(order -> "CANCELLED".equalsIgnoreCase(order.getStatus())).count();


        model.addAttribute("orders", orders);
        model.addAttribute("totalOrders", totalOrders);
        model.addAttribute("pendingOrders", pendingOrders);
        model.addAttribute("preparingOrders", preparingOrders);
        model.addAttribute("inTransitOrders", inTransitOrders);
        model.addAttribute("deliveredOrders", deliveredOrders);
        model.addAttribute("cancelledOrders", cancelledOrders);

        return "provider/orders";
    }

    @GetMapping("/orders/{orderId}/edit")
    public String showEditOrderForm(@PathVariable Long orderId, Model model) {
        Order order = orderService.getOrderById(orderId);
        Optional<Customer> customer = customerService.getCustomerById(order.getCustomerId());

        model.addAttribute("order", order);
        model.addAttribute("customerName", customer.map(c -> c.getUser().getName()).orElse("Unknown Customer"));
        
        return "provider/edit-order-status";
    }

    @PostMapping("/orders/{orderId}/update-status") 
    public String updateOrderStatus(@PathVariable Long orderId, @RequestParam("status") String status) {
        orderService.updateOrderStatus(orderId, status);
        
        return "redirect:/provider/orders";
    }

    // review management
    @GetMapping("/reviews")
    public String showReviews(@RequestParam(required = false) Integer rating, @RequestParam(required = false) String sort, Model model) {
        List<Review> reviews = reviewService.getAllReviews();

        long totalReviews = reviews.size();
        double avgRating = reviews.stream().mapToInt(Review::getRating).average().orElse(0.0);

        if (rating != null) {
            reviews = reviews.stream().filter(review -> review.getRating() == rating).toList();
        }

        if ("oldest".equalsIgnoreCase(sort)) {
            reviews = reviews.stream().sorted((r1, r2) -> r1.getDate().compareTo(r2.getDate())).toList();
        } else if ("newest".equalsIgnoreCase(sort)) {
            reviews = reviews.stream().sorted((r1, r2) -> r2.getDate().compareTo(r1.getDate())).toList();
        }

        model.addAttribute("reviews", reviews);
        model.addAttribute("totalReviews", totalReviews);
        model.addAttribute("avgRating", String.format("%.1f", avgRating));
        model.addAttribute("newReviews", totalReviews);
        model.addAttribute("repliedReviews", 0);
        model.addAttribute("selectedRating", rating);
        model.addAttribute("selectedSort", sort);
        
        return "provider/reviews";
    }

    @GetMapping("/reviews/{reviewId}/reply")
    public String showReplyForm(@PathVariable Long reviewId, Model model) {
        Review review = reviewService.getReviewById(reviewId).orElseThrow(() -> new RuntimeException("Review not found."));
       
        model.addAttribute("review", review);
        model.addAttribute("reply", new ReviewReply());
       
        return "provider/reply-review";
    }

    @PostMapping("/reviews/{reviewId}/reply")
    public String replyToReview(@PathVariable Long reviewId, Authentication authentication, @RequestParam("message") String message) {
        Review review = reviewService.getReviewById(reviewId).orElseThrow(() -> new RuntimeException("Review not found"));
        Provider provider = providerService.getProviderByUserEmail(authentication.getName());

        reviewReplyService.createReviewReply(review, provider, message);
      
        return "redirect:/provider/reviews";
    }

    @GetMapping("/reviews/{reviewId}")
    public String viewReview(@PathVariable Long reviewId, Model model) {
        Review review = reviewService.getReviewById(reviewId).orElseThrow(() -> new RuntimeException("Review not found."));

        model.addAttribute("review", review);

        return "provider/view-review";
        
    }
    

    // meal management
    @GetMapping("/meals")
    public String showMeals(@RequestParam(required=false) String diet, Model model) {
        List<Meal> meals = mealService.getAllMeals();

        if (diet != null && !diet.isBlank() && !diet.equalsIgnoreCase("ALL")) {
            meals = meals.stream()
                    .filter(meal -> meal.getDiet() != null && meal.getDiet().equalsIgnoreCase(diet))
                    .toList();
        }

        model.addAttribute("meals", meals);
        model.addAttribute("selectedDiet", diet == null ? "ALL" : diet);
        
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
    @GetMapping("/mealplans")
    public String showMealPlans(Model model) {
        model.addAttribute("mealPlans", mealPlanService.getAllMealPlans());
        
        return "provider/mealplans";
    }

    @GetMapping("/mealplans/add")
    public String showAddMealPlanForm(Model model) {
        model.addAttribute("mealPlan", new MealPlan());
        model.addAttribute("meals", mealService.getAllMeals());

        return "provider/add-mealplan";
    }

    @PostMapping("/mealplans/add")
    public String addMealPlan(Authentication authentication, @ModelAttribute MealPlan mealPlan, @RequestParam(required=false) List<Long> mealIds) {
        Provider provider = providerService.getProviderByUserEmail(authentication.getName());
        mealPlan.setProvider(provider);

        MealPlan savedMealPlan = mealPlanService.createMealPlanWithMeals(mealPlan, mealIds);

        if (mealIds != null) {
            for (Long mealId : mealIds) {
                Meal meal = mealService.getMealById(mealId);

                MealPlanMeal mealPlanMeal = new MealPlanMeal();
                mealPlanMeal.setMealPlan(savedMealPlan);
                mealPlanMeal.setMeal(meal);
                mealPlanMeal.setQuantity(1);

                mealPlanMealService.createMealPlanMeal(mealPlanMeal);
            }
        }
        
        return "redirect:/provider/mealplans";
    }

    @GetMapping("/mealplans/{plan_id}/edit")
    public String showEditMealPlanForm(@PathVariable Long plan_id, Model model) {
        MealPlan mealPlan = mealPlanService.getMealPlanById(plan_id);
        
        model.addAttribute("mealPlan", mealPlan);
        model.addAttribute("meals", mealService.getAllMeals());

        return "provider/edit-mealplan";
    }

    @PostMapping("/mealplans/{plan_id}/update")
    public String updateMealPlan(@PathVariable Long plan_id, @ModelAttribute MealPlan updatedMealPlan, @RequestParam(required=false) List<Long> mealIds) {
        mealPlanService.updateMealPlanWithMeals(plan_id, updatedMealPlan, mealIds);

        return "redirect:/provider/mealplans";
    }

    @DeleteMapping("/mealplans/{plan_id}")
    public String deleteMealPlan(@PathVariable Long plan_id) {
        mealPlanService.deleteMealPlan(plan_id);

        return "redirect:/provider/mealplans";
    }

    // subscription plan management
    @GetMapping("/subscriptions")
    public String showSubscriptions(Model model) {
        model.addAttribute("plans", subscriptionPlanService.getAllSubscriptionPlans());
        return "provider/subscriptions";
    }

    @GetMapping("/subscriptions/{plan_id}/edit")
    public String showEditSubscriptionForm(@PathVariable("plan_id") Long plan_id, Model model) {
        SubscriptionPlan plan = subscriptionPlanService.getSubscriptionPlanById(plan_id);
        model.addAttribute("subscription", plan);

        return "provider/edit-subscription";
    }

    @PostMapping("/subscriptions/{plan_id}/update")
    public String updateSubscription(@PathVariable("plan_id") Long plan_id,
                                    @ModelAttribute SubscriptionPlan updatedPlan) {

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
    @GetMapping("/profile")
    public String showProviderProfile(Authentication authentication, Model model) {
        String email = authentication.getName();

        Provider provider = providerService.getProviderByUserEmail(email);

        model.addAttribute("provider", provider);
        return "provider/profile";
    }

    @GetMapping("/profile/edit")
    public String showEditProfileForm(Authentication authentication, Model model) {
        String email = authentication.getName();
        Provider provider = providerService.getProviderByUserEmail(email);        model.addAttribute("provider", provider);

        model.addAttribute("provider", provider);
        return "provider/edit-profile";
    }

    @PostMapping("/profile/update")
    public String updateProfile(Authentication authentication,
                            @RequestParam String name,
                            @RequestParam String email,
                            @RequestParam String phone,
                            @RequestParam String biography) {

        Provider provider = providerService.getProviderByUserEmail(authentication.getName());
        providerService.updateProvider(provider.getProviderId(), name, email, phone, biography);

        return "redirect:/provider/dashboard";
    }
 
}
