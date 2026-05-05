# Balanced Bite Test Scenarios / Use Case Document

**Project Name:** Balanced Bite

**Version/Date:** Version 1.0 — May 2026

**Purpose:**

Balanced Bite is a meal-prep subscription platform that connects customers with meal providers. Customers can browse meals and subscription plans, purchase meal plans, manage subscriptions, and leave reviews. Providers can manage meals, meal plans, subscriptions, orders, and customer feedback.

---

## Actors

- **Provider P:** Manages meals, meal plans, subscription plans, orders, analytics, and customer reviews
- **Customer C:** Browses meals/plans, subscribes, orders meals, leaves reviews, manages profile
- **Service S:** Balanced Bite Web Application / Backend API

---

## Use Cases

### 1. Customer: US-CUST-001 — Register & Manage Profile

1. Customer C1 creates a Balanced Bite account.
2. C1 logs in and creates/updates their customer profile.
3. C1 adds dietary preferences and delivery information.
4. C1 saves changes successfully.

---

### 2. Customer: US-CUST-002 — Browse Meals & Meal Plans

1. Customer C1 navigates to Browse Meals.
2. C1 filters meals by dietary type/category.
3. C1 views available meal plans and premade bundles.
4. C1 selects a meal/plan for purchase.

---

### 3. Customer: US-CUST-003 — Subscribe to Meal Plan

1. Customer C1 selects a subscription plan.
2. C1 confirms subscription details/payment.
3. System creates CustomerSubscription record.
4. Subscription appears in C1’s active subscriptions.

---

### 4. Customer: US-CUST-004 — Leave Review

1. Customer C1 views past orders/subscriptions.
2. C1 selects completed order.
3. C1 submits rating and written review.
4. Review is saved and visible to provider.

---

### 5. Provider: US-PROV-001 — Manage Provider Profile

1. Provider P1 creates or edits provider profile.
2. P1 updates biography/contact/business information.
3. Changes persist successfully.

---

### 6. Provider: US-PROV-002 — Manage Meals / Meal Plans

1. Provider P1 creates new meal or meal plan.
2. P1 adds pricing, dietary tags, descriptions, and meals.
3. P1 edits/removes existing offerings.
4. Updated offerings display on customer browse page.

---

### 7. Provider: US-PROV-003 — Manage Orders & Subscription Status

1. Provider P1 views incoming customer orders.
2. P1 updates order/subscription status (Preparing, Delivered, Cancelled).
3. System persists status update.
4. Customer sees updated order/subscription status.

---

### 8. Provider: US-PROV-004 — Reply to Reviews & View Analytics

1. Provider P1 views customer reviews.
2. P1 replies to selected review.
3. System saves ReviewReply.
4. P1 views analytics dashboard with:
    - Total Orders
    - Revenue
    - Subscriber Counts
    - Review Metrics

---

# CROSS-CUTTING TEST SCENARIOS (Non-Functional Requirements)

---

## Performance Requirements

### Scenario P1: Browse Meals Response Time < 1.5 Seconds

- **Setup:** Server under typical load
- **Steps:**
    1. Load Browse Meals page with 20+ meals and 10+ meal plans
    2. Repeat 10 times
- **Expected Outcome:** 95% of requests ≤ 1.5 seconds

---

### Scenario P2: Provider Dashboard Analytics Load < 2 Seconds

- **Setup:** Provider has 50+ orders and reviews
- **Steps:**
    1. Provider opens analytics dashboard
    2. Dashboard loads all summary statistics
- **Expected Outcome:** Dashboard fully renders ≤ 2 seconds

---

## Security & Privacy Requirements

### Scenario S1: Unauthorized User Cannot Access Provider Dashboard

- **Setup:** Logged in as Customer
- **Steps:**
    1. Attempt to access `/provider/dashboard` directly
- **Expected Outcome:** Access denied / redirected to 403 page

---

### Scenario S2: Passwords Stored Securely

- **Setup:** New user registration
- **Steps:**
    1. Register new account
    2. Inspect database user table
- **Expected Outcome:** Password stored as hashed value, not plaintext

---

## Usability Requirements

### Scenario U1: Navigation Is Intuitive for New Users

- **Setup:** First-time customer user
- **Steps:**
    1. Register account
    2. Browse meals
    3. Subscribe to a plan
- **Expected Outcome:** User completes workflow without assistance

---

### Scenario U2: Responsive Dashboard Layout

- **Setup:** Open Balanced Bite on desktop/tablet/mobile
- **Steps:**
    1. Navigate through provider dashboard pages
    2. Resize viewport/device
- **Expected Outcome:** Layout remains readable and usable on all screen sizes
