# csc340-project

## Title
Balanced Bite

## Team Members
Jasmine Butts
Caleb Nix 

## Description 
A meal prepping service that offers its customers with time-saving options, so they can enjoy healthy, nutritious meals without the hassle.
This service is to help people who don't have the time or ability to make their own meals. The goal of this is to help alleviate the stress of planning, shopping, and cooking meals every day. 

## Project Summary
Balanced Bite is a full-stack meal preparation and subscription managment platform built with Java, Spring Boot, PostgresSQL, JPA/Hibernate, Spring Security, and FreeMarker MVC.
The platform connects customers with meal providers by allowing customers to browse meals and meal plans, select a suscription plan, place orders, and leave reviews; while providers manage meals, meal plans, subscriptions, analytics, and customer feedback.

## App Functions
1. Customer:
    1. Create/modify customer profile - Register an account with their email or number.
    2. View available services - Browse meals, see prices, and an option for filters based on meal type and dietary needs.
    3. Create or select a pre-built a meal plan - Favorite meals and the ability to edit the list. Add and edit meals in cart, submit payment information and order. Order confirmation page and the ability to view past orders.
    4. Subscribe to available services - Select a subscription option (e.g., weekly, monthly, or yearly).  
    5. Write reviews for subscribed services - Customers will be able to leave reviews on meals they have tried.
2. Provider:
    1. Register and manager provider profile - Create, edit, or delet provider profile
    2. Create and manage meals
    3. Create and manage meal plans
    4. Create and manage subscription plans
    5. View analytics - Total orders, active subscriptions, review statistics, and order metrix
    6. Update customer order status
    7. View customer reviews
    8. Reply to customer reviews - Provider can view and reply to customer reviews.

# Technology Stack
## Backend
- Java
- Spring Boot
- Spring MVC
- Spring Security
- Spring Data JPA
- Hibernate
## Frontend
- FreeMarker Templates -> .ftlh
- HTML5
- CSS3
## Database
- PostgresSQL - Neon Tech
## Build Tools
- Maven
  
---

# Project Architecture
This project follows the MVC (Model-View-Controller) architecture pattern.
## Model Layer
Contains all JPA entities and database relationships:
- Users
- Customer
- Provider
- Meal
- MealPlan
- MealPlanMeal
- SubscriptionPlan
- CustomerSubscription
- Review
- ReviewReply
- Order
- OrderItem
- Cart
- CartItem
- Favorites
## Repository Layer
Handles database operations using Spring Data JPA repositories.
## Service Layer
Contains business logic such as:
- Authentication
- Meal management
- Subscription management
- Analytics calculations
- Review reply handling
- Order processing

## Controller Layer
## REST Controllers
Provide backend API endpoints for CRUD functionality.
## MVC/UI Controllers
Render FreeMarker templates and handle:
- Login/registration
- Provider dashboard
- Meal management pages
- Meal plan management pages
- Analytics pages
- Review pages
- Subscription management pages
## Security Layer 
Spring Security handles:
- Authentication
- Password hashing
- Role-based authorization
- Login/logout handling
- Provider/customer access control

---
## Project Compartmentalization
The project is separated into independent functional modules:
- Authentication Module | Login, registration, role handling 
- Customer Module       | Customer profiles, subscriptions, favorites 
- Provider Module       | Provider profiles, meals, meal plans 
- Order Module          | Orders, order items, order status 
- Review Module         | Reviews and provider replies 
- Analytics Module      | Dashboard metrics and statistics 
- Security Module       | Spring Security configuration and authentication
- MVC/UI Module         | FreeMarker templates and frontend rendering 

## Running the Project

### Prerequisites

Make sure you have the following installed:

- **Java 21+** (or your project’s required Java version)
- **Maven**
- **PostgreSQL / Neon Database**
- IDE such as IntelliJ or VS Code

---

### 1. Clone the Repository

```bash
git clone <your-repo-url>
cd backend-api-team10
```

---

### 2. Configure Database Connection

Open:

```
src/main/resources/application.properties
```

Add your database connection string:

```
spring.datasource.url=YOUR_NEON_CONNECTION_STRING
spring.datasource.username=YOUR_DB_USERNAME
spring.datasource.password=YOUR_DB_PASSWORD

spring.jpa.hibernate.ddl-auto=update
```

> Do **NOT** commit your real connection string/password to GitHub.
> 

---

### 3. Install Dependencies

```bash
mvn clean install
```

---

### 4. Run the Application

```bash
mvn spring-boot:run
```

Or run the main Spring Boot application class from your IDE.

---

### 5. Access the Application

Open your browser and navigate to:

```
http://localhost:8080
```

---

### 6. Default Login / Test Accounts (Optional)

If your project has seeded users:

```
Provider:
email: provider@test.com
password: password

Customer:
email: customer@test.com
password: password
```

*(Remove this section if not applicable.)*

---

### Troubleshooting

### Port Already in Use

Change the port in `application.properties`:

```
server.port=8081
```

### Maven Not Recognized

Use Maven Wrapper instead:

```bash
./mvnw spring-boot:run
```

(Windows)

```bash
mvnw.cmd spring-boot:run
```
