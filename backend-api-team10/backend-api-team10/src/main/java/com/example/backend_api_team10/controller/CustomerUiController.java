package com.example.backend_api_team10.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
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
import com.example.backend_api_team10.entity.CustomerSubscription;
import com.example.backend_api_team10.entity.Favorite;
import com.example.backend_api_team10.entity.Meal;
import com.example.backend_api_team10.entity.MealPlan;
import com.example.backend_api_team10.entity.Order;
import com.example.backend_api_team10.entity.Review;
import com.example.backend_api_team10.entity.SubscriptionPlan;
import com.example.backend_api_team10.entity.Users;
import com.example.backend_api_team10.repository.CustomerRepo;
import com.example.backend_api_team10.repository.CustomerSubscriptionRepo;
import com.example.backend_api_team10.repository.UserRepo;
import com.example.backend_api_team10.service.CartItemService;
import com.example.backend_api_team10.service.CartService;
import com.example.backend_api_team10.service.CustomerService;
import com.example.backend_api_team10.service.FavoriteService;
import com.example.backend_api_team10.service.MealPlanService;
import com.example.backend_api_team10.service.MealService;
import com.example.backend_api_team10.service.OrderItemService;
import com.example.backend_api_team10.service.OrderService;
import com.example.backend_api_team10.service.ReviewService;
import com.example.backend_api_team10.service.SubscriptionPlanService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/customer")
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
    private OrderItemService orderItemService;
    @Autowired
    private CustomerSubscriptionRepo customerSubscriptionRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private MealPlanService mealPlanService;
    @Autowired
    private org.springframework.security.crypto.password.PasswordEncoder passwordEncoder;
    
    private Long getLoggedInCustomerId(Authentication authentication) {
        if (authentication == null || !authentication.isAuthenticated() || authentication.getPrincipal().equals("anonymousUser")) {
            return null;
        }
        return userRepo.findByEmail(authentication.getName())
            .map(user -> user.getCustomer() != null ? user.getCustomer().getCustomerId() : null)
            .orElse(null);
    }

    @ModelAttribute
    public void addGlobalAttributes(Model model, HttpSession session, Authentication authentication) {
        Long customerId = getLoggedInCustomerId(authentication);
        if (customerId != null) {
            model.addAttribute("customerId", customerId);

            Cart cart = cartService.getCartByCustomer(customerId).orElse(null);
            int cartCount = (cart != null && cart.getCartItems() != null) ? cart.getCartItems().stream().mapToInt(CartItem::getQuantity).sum() : 0;
            model.addAttribute("cartCount", cartCount);
        }
    }

    @GetMapping({"/", "/index", "/index.html"})
    public String showIndexPage(Model model) {
        List<Review> reviews = reviewService.getAllReviews();
        double avg = reviews.stream().mapToInt(Review::getRating).average().orElse(0.0);
        model.addAttribute("averageRating", avg);
        return "index";
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

        List<MealPlan> premadePlans = mealPlanService.getAllMealPlans().stream()
            .filter(plan -> plan.getIsPremade() != null && plan.getIsPremade())
            .collect(Collectors.toList());
        model.addAttribute("premadePlans", premadePlans);

        Long customerId = (Long) session.getAttribute("LoggedInCustomerId");
        if (customerId != null) {
            List<Long> favMealIds = favoriteService.getByCustomer(customerId).stream()
                .map(f -> f.getMeal().getMealId())
                .collect(Collectors.toList());
            model.addAttribute("favMealIds", favMealIds);
        }
        return "customer/meals";
    }
    @PostMapping("/carts/addPlan")
    public String addPlanToCart(@RequestParam Long planId, @RequestParam int qty, HttpSession session, Authentication authentication) {
        Long customerId = getLoggedInCustomerId(authentication);
            if (customerId == null) {
            return "redirect:/login";
    }
    Cart cart = cartService.getCartByCustomer(customerId)
            .orElseGet(() -> {
                Customer customer = customerService.getCustomerById(customerId).orElse(null);
                Cart newCart = new Cart(customer, java.math.BigDecimal.ZERO);
                return cartService.createCart(newCart);
            });
    
        com.example.backend_api_team10.entity.MealPlan plan = mealPlanService.getMealPlanById(planId);
        CartItem item = new CartItem();
        item.setCart(cart);
        item.setMealPlan(plan);
        item.setQuantity(qty);

        cartItemService.createItem(item);
        return "redirect:/customer/meals";
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }
   @GetMapping("/login-success")
    public String setupSessionAfterLogin(Authentication authentication, HttpSession session) {
        if (authentication == null || !authentication.isAuthenticated()) {
            return "redirect:/login";
        }
        
        // Fetch the user that Spring Security just logged in
        Users user = userRepo.findByEmail(authentication.getName()).orElse(null);
        
        if (user != null && user.getCustomer() != null) {
            // Set up all your required session variables!
            session.setAttribute("LoggedInCustomerId", user.getCustomer().getCustomerId());
            session.setAttribute("LoggedInCustomerName", user.getCustomer().getName());
            
            // Send them safely to the dashboard
            return "redirect:/customer/index";
        }
        
        // If they aren't a customer, log them back out
        return "redirect:/logout";
    }
    @GetMapping("/register")
    public String showRegistrationPage() {
        return "register";
    }
    @PostMapping("/register")
        public String processRegister(@RequestParam String name,
                                      @RequestParam String email,
                                      @RequestParam String password,
                                      @RequestParam(required = false) String phone,
                                      HttpSession session, Model model) {
        
        boolean emailTaken = userRepo.findByEmail(email).isPresent();
        if (emailTaken) {
            model.addAttribute("error", "Email is already registered");
            model.addAttribute("prefilledName", name);
            model.addAttribute("prefilledEmail", email);
            return "register";
        }
        Users newUser = new Users();
        newUser.setEmail(email.trim().toLowerCase());
        newUser.setPasswordHash(passwordEncoder.encode(password));
        newUser.setRole(com.example.backend_api_team10.entity.Role.CUSTOMER);    
        
        Customer newCustomer = new Customer();
        newCustomer.setName(name);
        newCustomer.setPhone(phone);
        newCustomer.setUser(newUser);
        newCustomer.setSubscribed(false);
        newCustomer.setStatus("active");

        Customer savedCustomer = customerService.createCustomer(newCustomer);
        session.setAttribute("LoggedInCustomerId", savedCustomer.getCustomerId());
        session.setAttribute("LoggedInCustomerName", savedCustomer.getName());
        return "redirect:/customer/index";

    }  
    
    @GetMapping("/logout")
    public String logout (HttpSession session) {
        session.invalidate();
        return "redirect:/customer/index";
    }

    @PostMapping("/subscriptions/select")
    public String selectSubscription(@RequestParam("planName") String planName, HttpSession session, Authentication authentication) {
        
        Long customerId = getLoggedInCustomerId(authentication);
        if (customerId == null) {
            return "redirect:/login";
        }
        SubscriptionPlan plan = subscriptionPlanService.getAllSubscriptionPlans().stream()
            .filter(p -> p.getName().equalsIgnoreCase(planName))
            .findFirst()
            .orElse(null);

        if (plan == null) {
            return "redirect:/customer/subscriptions?error=planNotFound";
        }
        Customer customer = customerService.getCustomerById(customerId).orElseThrow();
        CustomerSubscription activeSub = customerSubscriptionRepo.findByCustomerId(customerId)
            .orElse(new CustomerSubscription());

            activeSub.setCustomer(customer);
            activeSub.setSubscriptionPlan(plan);
            java.time.LocalDate today = java.time.LocalDate.now();
            activeSub.setStartDate(today);
            activeSub.setEndDate(today.plusMonths(1));
            activeSub.setStatus("Active");

            customerSubscriptionRepo.save(activeSub);
            customer.setSubscribed(true);
            customerRepo.save(customer);
            System.out.println("Customer " + customerId + " selected the " + planName + " subscription plan.");
        return "redirect:/customer/subscriptions";
    }

    @GetMapping("/subscriptions")
    public String showSubscriptionPage(Model model, HttpSession session) {
        List<SubscriptionPlan> plans = subscriptionPlanService.getAllSubscriptionPlans();
        model.addAttribute("plans", plans);

        Long customerId = (Long) session.getAttribute("LoggedInCustomerId");
        return "customer/subscriptions";
    }
    @GetMapping("/orders")
    public String showOrdersPage(@RequestParam(defaultValue = "all") String status, Model model, HttpSession session) {
        Long customerId = (Long) session.getAttribute("LoggedInCustomerId");
        if (customerId == null) {
            return "redirect:/login";
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
        return "customer/orders";

    }
    @PostMapping("/orders/checkout")
    public String processCheckout(HttpSession session, Authentication authentication) {
        Long customerId = getLoggedInCustomerId(authentication);
        if (customerId == null) {
            return "redirect:/login";
        }
        Cart cart = cartService.getCartByCustomer(customerId).orElse(null);
        if (cart == null || cart.getCartItems() == null || cart.getCartItems().isEmpty()) {
            return "redirect:/customer/carts";
        }
        Order newOrder = new Order();
        newOrder.setCustomerId(customerId);
        newOrder.setCartId(cart.getCartId());
        newOrder.setTimestamp(java.time.LocalDateTime.now());
        newOrder.setStatus("Pending");

        java.math.BigDecimal calculatedTotal = cart.getCartItems().stream()
            .map(item -> item.getMeal().getPrice().multiply(java.math.BigDecimal.valueOf(item.getQuantity())))
            .reduce(java.math.BigDecimal.ZERO, java.math.BigDecimal::add);
        newOrder.setTotalPrice(calculatedTotal);
        newOrder.setAddress("Pending Address");

        orderService.createOrder(newOrder);
        for (CartItem item : cart.getCartItems()) {
            com.example.backend_api_team10.entity.OrderItem orderItem = new com.example.backend_api_team10.entity.OrderItem();
            orderItem.setOrderId(newOrder.getOrderId());
            orderItem.setMeal(item.getMeal());
            orderItem.setQuantity(item.getQuantity());
            java.math.BigDecimal itemTotal = item.getMeal().getPrice().multiply(java.math.BigDecimal.valueOf(item.getQuantity()));
            orderItem.setItemTotal(itemTotal);

            orderItemService.createOrderItem(orderItem);

            cartItemService.deleteItem(item.getItemId());
        }
        cart.setSubtotal(java.math.BigDecimal.ZERO);
        cartService.updateCart(cart.getCartId(), cart);
        return "redirect:/customer/orders";
    }

    @GetMapping("/reviews")
    public String showReviewsPage(Model model, Authentication authentication) {
        List<Review> reviews = reviewService.getAllReviews();
        double avg = reviews.stream().mapToInt(Review::getRating).average().orElse(0.0);
        model.addAttribute("reviews", reviews);
        model.addAttribute("averageRating", avg);
        model.addAttribute("totalReviews", reviews.size());
        model.addAttribute("meals", mealService.getAllMeals());

        Long customerId = getLoggedInCustomerId(authentication);
        java.util.List<Meal> eligibleMeals = new java.util.ArrayList<>();

        if (customerId != null) {
            List<Order> orders = orderService.getAllOrders().stream()
                .filter(o -> o.getCustomerId().equals(customerId))
                .collect(Collectors.toList());

                for (Order order : orders) {
                    List<com.example.backend_api_team10.entity.OrderItem> items = orderItemService.getOrderItemsByOrderId(order.getOrderId());
                    for (com.example.backend_api_team10.entity.OrderItem item : items) {
                        if (item.getMeal() != null && !eligibleMeals.contains(item.getMeal())) {
                            eligibleMeals.add(item.getMeal());
                        }
                    }
                }
        }
        model.addAttribute("meals", eligibleMeals);
        model.addAttribute("ratingBars", List.of(
            java.util.Map.of("stars", 5, "pct", 75), 
            java.util.Map.of("stars", 4, "pct", 15),
            java.util.Map.of("stars", 3, "pct", 5),
            java.util.Map.of("stars", 2, "pct", 3),
            java.util.Map.of("stars", 1, "pct", 2)        
        ));
        return "customer/reviews";
    }
    @PostMapping("/favorites/toggle")
    public String toggleFavorite(@RequestParam Long mealId, HttpSession session) {
        Long customerId = (Long) session.getAttribute("LoggedInCustomerId");
        if (customerId == null) {
            return "redirect:/login";
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
        return "redirect:/customer/meals";
    }
    @PostMapping("/carts/add")
    public String addToCart(@RequestParam Long mealId, @RequestParam int qty, HttpSession session, Authentication authentication) {
        Long customerId = getLoggedInCustomerId(authentication);
        if (customerId == null) {
            return "redirect:/login";
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
        return "redirect:/customer/meals";
            }

    @GetMapping("/carts")
    public String showCartPage(Model model, HttpSession session) {
        Long customerId = (Long) session.getAttribute("LoggedInCustomerId");
        if (customerId == null) {
            return "redirect:/login";
        }
        Cart cart = cartService.getCartByCustomer(customerId).orElse(null);
        if (cart != null && cart.getCartItems() != null) {
                model.addAttribute("cartItems", cart.getCartItems());

                double subtotal = cart.getCartItems().stream()
                    .mapToDouble(item -> {
                        if (item.getMeal() != null) {
                            return item.getMeal().getPrice().doubleValue() * item.getQuantity();
                        } else if (item.getMealPlan() != null) {
                            return item.getMealPlan().getPrice().doubleValue() * item.getQuantity();
                        }
                        return 0.0; // Fallback just in case
                    })
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
            return "customer/cart";
       
    }
    @PostMapping("/carts/update")
    public String updateCartQuantity(@RequestParam("itemId") Long itemId, @RequestParam("delta") int delta) {
        CartItem item = cartItemService.getById(itemId).orElse(null);
        if (item != null) {
            int newQuantity = item.getQuantity() + delta;
            if (newQuantity <= 0) {
                Cart cart = item.getCart();
                if(cart != null && cart.getCartItems() != null) {
                    cart.getCartItems().remove(item);
                }
                cartItemService.deleteItem(itemId);
            } else {
                item.setQuantity(newQuantity);
                cartItemService.createItem(item);
            }
        }
        return "redirect:/customer/carts";
    }

    @PostMapping("/carts/remove")
    public String removeCartItem(@RequestParam("itemId")Long itemId) {
        CartItem item = cartItemService.getById(itemId).orElse(null);
        if (item != null) {
            Cart cart = item.getCart();
            if (cart != null && cart.getCartItems() != null) {
                cart.getCartItems().remove(item);
            }
            cartItemService.deleteItem(itemId);
        }
        return "redirect:/customer/carts";
    }
    
    @GetMapping("/profile")
    public String showCustomerProfile(Authentication authentication, Model model) {
        if (authentication == null || !authentication.isAuthenticated()) {
            return "redirect:/login";

        }
        userRepo.findByEmail(authentication.getName()).ifPresent(user -> {
            if (user.getCustomer() != null) {
                Long customerId = user.getCustomer().getCustomerId();
                model.addAttribute("customer", customerService.getCustomerById(customerId).orElse(null));
            }
        });
        return "customer/profile";
    }

    @GetMapping("/profile/edit")
    public String showEditProfilePage(Authentication authentication, Model model) {
        if (authentication == null || !authentication.isAuthenticated()) {
            return "redirect:/login";
        }
        userRepo.findByEmail(authentication.getName()).ifPresent(user -> {
            if (user.getCustomer() != null) {
                Long customerId = user.getCustomer().getCustomerId();
                model.addAttribute("customer", customerService.getCustomerById(customerId).orElse(null));
            }
        });
        return "customer/edit-profile";
    }
    @PostMapping("/profile/edit")
    public String processEditProfile(@RequestParam String name,
                                     @RequestParam String email,
                                     @RequestParam String phone,
                                     @RequestParam(required = false) String password, Authentication authentication) {
        if (authentication == null || !authentication.isAuthenticated()) {
            return "redirect:/login";
        }
        Users existingUser = userRepo.findByEmail(authentication.getName()).orElse(null);
        if (existingUser == null || existingUser.getCustomer() == null) {
            return "redirect:/login";
        }
        Long customerId = existingUser.getCustomer().getCustomerId();
        Customer existingCustomer = customerService.getCustomerById(customerId).orElseThrow();

        existingCustomer.setName(name);
        existingCustomer.setPhone(phone);

        existingUser.setEmail(email.trim().toLowerCase());

        if (password != null && !password.isBlank()) {
            existingUser.setPasswordHash(passwordEncoder.encode(password));
        } 
      
        customerService.updateCustomer(customerId, existingCustomer);

        if (!authentication.getName().equalsIgnoreCase(email) || (password!= null && !password.isBlank())) {
            return "redirect:/logout";
        }
        return "redirect:/customer/profile?success=true";
    }
    @PostMapping("/reviews/add")
    public String submitReview(@RequestParam int rating, @RequestParam Long mealId, @RequestParam String description, HttpSession session, Authentication authentication) {
        Long customerId = getLoggedInCustomerId(authentication);
        if (customerId == null) {
            return "redirect:/login";
        }
        boolean hasOrdered = false;
        List<Order> userOrders = orderService.getAllOrders().stream()
            .filter(o -> o.getCustomerId().equals(customerId))
            .collect(Collectors.toList());

        for (Order order : userOrders) {
            List<com.example.backend_api_team10.entity.OrderItem> items = orderItemService.getOrderItemsByOrderId(order.getOrderId());
            if (items.stream().anyMatch(i -> i.getMeal() !=null && i.getMeal().getMealId().equals(mealId))) {
                hasOrdered = true;
                break;
            }
        }
        if (!hasOrdered) {
            return "redirect:/customer/reviews?error=notordered";
        }

        Customer customer = customerService.getCustomerById(customerId).orElseThrow();
        Meal meal = mealService.getMealById(mealId);
        Review newReview = new Review();
        newReview.setRating(rating);
        newReview.setDescription(description);
        newReview.setCustomer(customer);
        newReview.setMeal(meal);
        newReview.setDate(java.time.LocalDate.now());

        reviewService.createReview(newReview);
        return "redirect:/customer/reviews";
    }
}
        
    





    

