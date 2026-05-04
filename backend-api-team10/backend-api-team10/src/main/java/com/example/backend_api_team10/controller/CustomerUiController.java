package com.example.backend_api_team10.controller;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.backend_api_team10.entity.Cart;
import com.example.backend_api_team10.entity.CartItem;
import com.example.backend_api_team10.entity.Customer;
import com.example.backend_api_team10.entity.Favorite;
import com.example.backend_api_team10.entity.Meal;
import com.example.backend_api_team10.entity.Order;
import com.example.backend_api_team10.entity.Review;
import com.example.backend_api_team10.entity.SubscriptionPlan;
import com.example.backend_api_team10.entity.Users;
import com.example.backend_api_team10.service.CartItemService;
import com.example.backend_api_team10.service.CartService;
import com.example.backend_api_team10.service.CustomerService;
import com.example.backend_api_team10.service.FavoriteService;
import com.example.backend_api_team10.service.MealService;
import com.example.backend_api_team10.service.OrderService;
import com.example.backend_api_team10.service.ReviewService;
import com.example.backend_api_team10.service.SubscriptionPlanService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/customers")
public class CustomerUiController {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private MealService mealService;
    @Autowired
    private SubscriptionPlanService subscriptionPlanService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private ReviewService reviewService;
    @Autowired
    private FavoriteService favoriteService;
    @Autowired
    private CartService cartService;
    @Autowired
    private CartItemService cartItemService;
    @Autowired
    private org.springframework.security.crypto.password.PasswordEncoder passwordEncoder;
    @Autowired
    private com.example.backend_api_team10.repository.UserRepo userRepo;
    

    @ModelAttribute
    public void addGlobalAttributes(Model model, Principal principal) {
        if (principal != null) {
            String email = principal.getName();
            Users user = userRepo.findByEmail(email).orElse(null);
            if (user != null && user.getCustomer() != null) {
                model.addAttribute("customerId", user.getCustomer().getCustomerId());
                model.addAttribute("customerName", user.getCustomer().getName());
            }
        }
    }

    @GetMapping({"/", "/index", "/index.html"})
    public String showIndexPage(Model model) {
        List<Review> reviews = reviewService.getAllReviews();
        double avg = reviews.stream().mapToInt(Review::getRating).average().orElse(0.0);
        model.addAttribute("averageRating", avg);
        return "customers/index";
    }

    @GetMapping("/meals")
    public String showMealsPage(@RequestParam(defaultValue = "all") String filter, Model model, HttpSession session) {
        List<Meal> meals;
        if ("all".equalsIgnoreCase(filter)) {
            meals = mealService.getAllMeals();
        } else {
            meals = mealService.getAllMeals().stream()
                .filter(m -> filter.equalsIgnoreCase(m.getDiet()))
                .collect(Collectors.toList());
        }
        model.addAttribute("meals", meals);
        model.addAttribute("activefilter", filter);

        Long customerId = (Long) session.getAttribute("LoggedInCustomerId");
        if (customerId != null) {
            List<Long> favMealIds = favoriteService.getByCustomer(customerId).stream()
                .map(f -> f.getMeal().getMealId())
                .collect(Collectors.toList());
            model.addAttribute("favMealIds", favMealIds);
        }
        return "customers/meals";
    }
    @PostMapping("/subscriptions/select")
    public String selectSubscription(@RequestParam("planName") String planName, HttpSession session) {
        
        Long customerId = (Long) session.getAttribute("LoggedInCustomerId");
        if (customerId == null) {
            return "redirect:/customers/login";
        }
        System.out.println("Customer " + customerId + " selected the " + planName + " subscription plan.");
        return "redirect:/customers/subscriptions";
    }

    @GetMapping("/subscriptions")
    public String showSubscriptionPage(Model model, HttpSession session) {
        List<SubscriptionPlan> plans = subscriptionPlanService.getAllSubscriptionPlans();
        model.addAttribute("plans", plans);

        Long customerId = (Long) session.getAttribute("LoggedInCustomerId");
        return "customers/subscriptions";
    }
    @GetMapping("/orders")
    public String showOrdersPage(@RequestParam(defaultValue = "all") String status, Model model, HttpSession session) {
        Long customerId = (Long) session.getAttribute("LoggedInCustomerId");
        if (customerId == null) {
            return "redirect:/customers/login";
        }
        List<Order> userOrders = orderService.getAllOrders().stream()
            .filter(o -> o.getCustomerId().equals(customerId))
            .collect(Collectors.toList());

        if (!"all".equalsIgnoreCase(status)) {
            userOrders = userOrders.stream()
                .filter(o -> o.getStatus().equalsIgnoreCase(status))
                .collect(Collectors.toList());
        }
        model.addAttribute("orders", userOrders);
        model.addAttribute("activeFilter", status);
        return "customers/orders";

    }
    @PostMapping("/orders/checkout")
    public String processCheckout(HttpSession session) {
        Long customerId = (Long) session.getAttribute("LoggedInCustomerId");
        if (customerId == null) {
            return "redirect:/customers/login";
        }
        Cart cart = cartService.getCartByCustomer(customerId).orElse(null);
        if (cart == null || cart.getCartItems() == null || cart.getCartItems().isEmpty()) {
            return "redirect:/customers/carts";
        }
        Order newOrder = new Order();
        newOrder.setCustomerId(customerId);
        newOrder.setCartId(cart.getCartId());
        newOrder.setTimestamp(java.time.LocalDateTime.now());
        newOrder.setStatus("Pending");
        double calculatedTotal = cart.getCartItems().stream()
            .mapToDouble(item -> item.getMeal().getPrice().doubleValue() * item.getQuantity())
            .sum();
        newOrder.setTotalPrice(calculatedTotal);
        newOrder.setAddress("Pending Address");

        orderService.createOrder(newOrder);
        for (CartItem item : cart.getCartItems()) {
            cartItemService.deleteItem(item.getItemId());
        }
        cart.setSubtotal(java.math.BigDecimal.ZERO);
        cartService.updateCart(cart.getCartId(), cart);
        return "customers/checkout";
    }

    @GetMapping("/reviews")
    public String showReviewsPage(Model model) {
        List<Review> reviews = reviewService.getAllReviews();
        double avg = reviews.stream().mapToInt(Review::getRating).average().orElse(0.0);
        model.addAttribute("reviews", reviews);
        model.addAttribute("averageRating", avg);
        model.addAttribute("totalReviews", reviews.size());
        model.addAttribute("ratingBars", List.of(
            java.util.Map.of("stars", 5, "pct", 75), 
            java.util.Map.of("stars", 4, "pct", 15),
            java.util.Map.of("stars", 3, "pct", 5),
            java.util.Map.of("stars", 2, "pct", 3),
            java.util.Map.of("stars", 1, "pct", 2)        
        ));
        return "customers/reviews";
    }
    @PostMapping("/favorites/toggle")
    public String toggleFavorite(@RequestParam Long mealId, HttpSession session) {
        Long customerId = (Long) session.getAttribute("LoggedInCustomerId");
        if (customerId == null) {
            return "redirect:/customers/login";
        }
        favoriteService.findSpecific(customerId, mealId).ifPresentOrElse(
            fav -> favoriteService.removeFavorite(fav.getFavoriteId()),
            () -> {
                Customer customer = customerService.getCustomerById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
                Meal meal = mealService.getMealById(mealId);
                favoriteService.addFavorite(new Favorite(customer, meal));
            }
        );
        return "redirect:/customers/meals";
    }
    @PostMapping("/carts/add")
    public String addToCart(@RequestParam Long mealId, @RequestParam int qty, HttpSession session) {
        Long customerId = (Long) session.getAttribute("LoggedInCustomerId");
        if (customerId == null) {
            return "redirect:/customers/login";
        }
        Cart cart = cartService.getCartByCustomer(customerId)
            .orElseGet(() -> {
                Customer customer = customerService.getCustomerById(customerId).orElse(null);
                Cart newCart = new Cart(customer, java.math.BigDecimal.ZERO);
                return cartService.createCart(newCart);
            });
        Meal meal = mealService.getMealById(mealId);
        CartItem item = new CartItem();
        item.setCart(cart);
        item.setMeal(meal);
        item.setQuantity(qty);
        cartItemService.createItem(item);
        return "redirect:/customers/meals";
            }

    @GetMapping("/carts")
    public String showCartPage(Model model, HttpSession session) {
        Long customerId = (Long) session.getAttribute("LoggedInCustomerId");
        if (customerId == null) {
            return "redirect:/customers/login";
        }
        Cart cart = cartService.getCartByCustomer(customerId).orElse(null);
        if (cart != null && cart.getCartItems() != null) {
                model.addAttribute("cartItems", cart.getCartItems());

                double subtotal = cart.getCartItems().stream()
                    .mapToDouble(item -> item.getMeal().getPrice().doubleValue() * item.getQuantity())
                    .sum();

                model.addAttribute("subtotal", subtotal);
                model.addAttribute("discount", 0);
                model.addAttribute("total", subtotal); 
        } else 
            {
                model.addAttribute("cartItems", java.util.Collections.emptyList());
                model.addAttribute("subtotal", 0);
                model.addAttribute("discount", 0);
                model.addAttribute("total", 0);
            }
            return "customers/cart";
       
    }
    @PostMapping("/carts/update")
    public String updateCartQuantity(@RequestParam("itemId") Long itemId, @RequestParam("delta") int delta) {
        CartItem item = cartItemService.getById(itemId).orElse(null);
        if (item != null) {
            int newQuantity = item.getQuantity() + delta;
            if (newQuantity <= 0) {
                cartItemService.deleteItem(itemId);
            } else {
                item.setQuantity(newQuantity);
                cartItemService.createItem(item);
            }
        }
        return "redirect:/customers/carts";
    }

}


    

