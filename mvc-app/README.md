# LocalHarvest Hub - MVC Application

A Spring MVC web application for customers looking for fresh, subscription based meal delivery options.

## Architecture Overview

This application follows the **Model-View-Controller (MVC)** pattern:

### Models (Entities)
Located in `src/com.example.backend_api_team10.entity`

- **Users** - Base entity for authentication containing email, password, and roles (CUSTOMER OR PROVIDER)
- **Customer** - Extends User; manages profile details, phone numbers, subscription status
- **Provider** - Manages the meal options and analytics 
- **Meal** - Food items offered by providers 
- **MealPlan** - Premade meals created by the provider
- **MealPlanMeal** - Maps specific meals and their quantities to a mealplan
- **Cart & CartItem** - Manages the shopping session, holding individual meals and mealplan items
- **Order and OrderItem** - Shows what items were checked out and their totals
- **SubscriptionPlan** - The subscription plan shown for the customer
- **CustomerSubscription** - Links customers to the subscription they purchased
- **Review** - Customer can send reviews for feedback
- **Favorite** - Customer can favorite their meals

### Views (Templates)
Located in `src/main/resources/templates/`

**Shared Components:**
- `layout.ftlh` - Main layout containing the head and structural UI

**Customer Views:**
- `customer/index.ftlh` - The dashboard displaying quick links 
- `customer/meals.ftlh` - An interface featuring individual meals and premade meals
- `customer/cart.ftlh` - Shopping cart, with the total, and checkout functionality
- `customer/orders.ftlh` - Order history
- `customer/profile.ftlh` - Read only view of the customers account
- `customer/edit-profile.ftlh` - Able to update name, phone, password
- `customer/subscriptions.ftlh` - Able to Update customer subscription
- `customer/reviews.ftlh` - Able to Update customer subscription

**Provider Views:**
- `Provider/add-meal.ftlh` - Able to add meals
- `Provider/add-mealplan.ftlh` - Able to add mealplans
- `Provider/analytics.ftlh` - View statistics
- `Provider/dashboard.ftlh` - Provider dashboard showing the different tabs
- `Provider/edit-meal.ftlh` - Able to edit the meals
- `Provider/edit-mealplan.ftlh` - Able to edit a mealplan
- `Provider/edit-profile.ftlh` - Able to edit provideer profile
- `Provider/edit-order-status.ftlh` - Ablet to edit the order status
- `Provider/edit-subscription.ftlh` - Able to edit the subscription for the customer
- `Provider/mealplans.ftlh` - The view for the mealplan 
- `Provider/orders.ftlh` - Can see what orders are being made by the customer
- `Provider/profile.ftlh` - The view for the provider profile
- `Provider/reply-review.ftlh` - Able to reply to customer review
- `Provider/reviews.ftlh` - The reviews made by customers
- `Provider/subscriptions.ftlh` - The view of the subscriptions
- `Provider/view-review.ftlh` - Able to view reviews

**Public Pages:**
- `Login.ftlh` - Authentication page
- `Register.ftlh` - Account creation page

### Controllers

**API Controllers** - RESTful endpoints for data operations:
- `CartControler` - Cart operations
- `CartitemController` - Cart item in cart
- `CustomerController` - Customer operations 
- `CustomerSubscriptionController` - Subscription linked to customer
- `FavoriteController` - Favorite meal management
- `MealController` - Meal for customer
- `MealPlanController` - Mealplan for customer
- `MealPlanMealController` - Related to mealplan
- `OrderController` - Shows order history
- `OrderItem'Controller` - Item in order history
- `ProviderController` - Provider operations
- `ReviewController` - Review management 
- `ReviewReplyController` - Reply to reviews
- `SubscriptionPlanController` - Subscription plan for customer
- `UserController` - User in the system

**UI Controllers** - Page rendering and navigation:
- `CustomerUiController` - Primary controller managing /customer routes
- `ProviderUiController` - Primary controller handling /provider routes

### Services
Located in `src/com.example.backend_api_team10.service`

Business logic layer providing CRUD operations and domain-specific functionality:
- `AnalyticsService` - Site statistics
- `CartService` - Cart operations
- `CartitemService` - Cart item in cart
- `CustomerService` - Customer operations 
- `CustomerSubscriptionService` - Subscription linked to customer
- `FavoriteService` - Favorite meal management
- `MealService` - Meal for customer
- `MealPlanService` - Mealplan for customer
- `MealPlanMealService` - Related to mealplan
- `OrderService` - Shows order history
- `OrderItem'Service` - Item in order history
- `ProviderService` - Provider operations
- `ReviewService` - Review management 
- `ReviewReplyService` - Reply to reviews
- `SubscriptionPlanService` - Subscription plan for customer
- `UserService` - User in the system

### Repositories
Located in `src/com.example.backend_api_team10.repository`

Data access layer interfacing with the database (Spring Data JPA):
- `CartRepo` - Cart operations
- `CartitemRepo` - Cart item in cart
- `CustomerRepo` - Customer lookup 
- `CustomerSubscriptionRepo` - Subscription linked to customer
- `FavoriteRepo` - Favorite meal management
- `MealRepo` - Meal inventory queries
- `MealPlanRepo` - Mealplan inventory queries
- `MealPlanMealRepo` - Related to mealplan
- `OrderRepo` - Shows order history
- `OrderItem'Repo` - Item in order history
- `ProviderRepo` - Provider lookup
- `ReviewRepo` - Review queries 
- `ReviewReplyRepo` - Reply to reviews
- `SubscriptionPlanRepo` - Subscription plan queries
- `UserRepo` - User lookup
## Key Features

### User Roles & Authentication
- **Customer**: Browse products, create subscriptions, leave reviews
- **Provider**: Create/manage meals and mealplans, view customer reviews with and reply, track statistics

### Customer Flow
1. Sign up and create customer profile
2. Browse the meals and filter options
3. Create recurring subscriptions with custom dates
4. Manage subscriptions (update status, end dates)
5. Add item to cart and checkout
6. Leave reviews with 5-star ratings (freshness, delivery, value)
7. View provider responses to reviews

### Provider Flow
1. Sign up and register account
2. Create and manage meals (title, price, description)
3. View all subscriptions to their products
4. Monitor customer statistics and metrics
5. View customer reviews 
6. Reply to customer reviews in real-time

### Navigation
All pages use a unified FreeMarker macro-based navbar that automatically adjusts based on:
- User role (provider/customer)
- Authentication status
- Responsive design (Bootstrap 5.3.2)

## Session Management
- Uses `HttpSession` for storing `customerId` and `farmerId`
- Automatic redirect to signin for unauthenticated access to protected pages
- Session validation on all sensitive endpoints

## Database Relationships
- **One-to-Many**: Provider → Meals, Customer → meals, Provider → Reviews
- **Many-to-One**: Review → Meals
- **Cascade Operations**: Automatic cascading for related entity changes
- **JsonIgnoreProperties**: Prevents circular reference serialization