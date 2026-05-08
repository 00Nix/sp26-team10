
# Requirements 

**Project Name:** Balanced Bite\
**Team:** Caleb Nix - Customer, Jasmine Butts - Provider\
**Course:** CSC 340\
**Version:** 1.0\
**Date:** 2026-02-13

---

## 1. Overview
**Vision.** Balanced Bite is an online meal prep planner and delivery service. Customers can explore a variety of meals, create their own meal plan or choose from pre-built options, and leave reviews of their experience. Customers can place a one-time order or subscribe for recurring meals. Site admins keep the site up to date by managing item listings and staying current on customer feedback and statistics. We aim to take away the stress that can come with meal prepping and trying to eat healthy.

**Glossary** 
- **Cadence:** The frquency at which a subscription recurs.
- **Churn Rate:** The percentage of subscribers who stop using the service over a specific period of time.
- **Diet:** Food preferences and restrictions.
- **Engagement:** Aggregate signals such as, active subscriptions, churn rate, reviews and ratings.
- **Item Type:** Differentiates between an appetizer, entree, dinner, and a snack.
- **Item:** A food product.
- **Meal / Meal Plan:** A curated set of items that is created or selected by the customer.

**Primary Users / Roles.**
- **Customer (creator / consumer of the meal plan)** — create or select a meal plan; manage subscription and orders; review experience.
- **Provider (meal distributor / site admin)** — publish & update item listings; view orders and update status; respond to reviews; view engagement statistics.

**Scope (this semester).**
- Create & manage a user profile.
- Subscribe & manage subscription (pause/cancel).
- Browse through items & pre-built meal plans, with the ability to sort based on filters (item type, diet).
- Create custom meal plan, add/remove items from the meal plan or select a pre-built meal plan.
- Submit an order, view status of the current & previous orders.
- Leave a review of the experience; view & reply to reviews.
- Add / edit item listings.
- View engagement & statistics (subscriptions, orders, churn rate )



**Out of scope (deferred).**
- Live delivery tracking
- Online payment & refund processing
- Allergy-based filtering
- Multi-language UI beyond English

> This document is **requirements‑level** and solution‑neutral; design decisions (UI layouts, API endpoints, schemas) are documented separately.

---

## 2. Functional Requirements (User Stories)
Write each story as: **As a `<role>`, I want `<capability>`, so that `<benefit>`.** Each story includes at least one **Given/When/Then** scenario.

### 2.1 Customer Stories
- **US‑CUST‑001 — <Registering & managing profile>**  
  _Story:_ As a customer, I want to register or manage my profile so that so that I can make and recieve my orders. 
  _Acceptance:_
  ```gherkin
  Scenario: <Register with correct user details>
    Given <Am not registered>
    When  <Register with information>
    Then  <Profile for customer is created and shown>
  ```

- **US‑CUST‑002 — <View Meal Plan information>**  
  _Story:_ As a customer, I want to view the information of the meal plan so that I can understand what it is before deciding.
  _Acceptance:_
  ```gherkin
  Scenario: <View meal plan details>
    Given <I am on the meal plans page>
    When  <I select a specific meal plan>
    Then  <it displays the meal plan information>
  ```

- **US‑CUST‑003 — <Browse Meal Plan Options>**  
  _Story:_ As a customer, I want to browse meal plan options to pick the best option for me.
  _Acceptance:_
  ```gherkin
  Scenario: <Browsing a meal plan option>
    Given <Many different meal plan options>
    When  <I find the most suitable plan for me>
    Then  <I choose or save that specific meal plan>
  ```

- **US‑CUST‑004 — <Filter meal plans>**  
  _Story:_ As a customer, I want to sort or filter the meal plans, so that I can find the most suitable option for me.
  _Acceptance:_
  ```gherkin
  Scenario: <Filter by price range, type/category, rating, sort by newest/oldest, price (low to high/high to low), relevance.>
    Given <there are products for certain needs >
    When  <I use the filtering and sort options>
    Then  <I see the meal plans I specifically filtered for>
  ```

  - **US‑CUST‑002 — <Subscribing (Weekly, Monthly, Yearly)>**  
  _Story:_ As a customer, I want to subscribe for my preffered time period to receive fresh goods.
  _Acceptance:_
  ```gherkin
  Scenario: <Begin a subscription>
    Given <I am not subscribed>
    When  <I choose a subscription option ie., weekly, monthly, yearly>
    Then  <I am subscribed to the meal plan app>
  ```  

  - **US‑CUST‑005 — <Managing Subscription>**  
  _Story:_ As a customer, I want to manage my subscription, such as canceling, pausing or changing, to fit my needs.
  _Acceptance:_
  ```gherkin
  Scenario: <Canceling my subscription>
    Given <No longer need or want to be subscribed>
    When  <I choose the option of unsubscribing>
    Then  <I am no longer subscribed to the meal plan app>
  ```

  - **US‑CUST‑006 — <Write Reviews>**  
  _Story:_ As a customer, I want to write a review on a meal plan I purchased to leave feedback for the provider, and future customers.
  _Acceptance:_
  ```gherkin
  Scenario: <Leaving a review>
    Given <I recieved a meal plan that I enjoy>
    When  <I write a review that describes my enjoymeny with the meal plan >
    Then  <the review is submitted to view for future customers>
  ```

  - **US‑CUST‑002 — <Read Reviews>**  
  _Story:_ As a customer, I want to be able to view reviews so that I make a decision.
  _Acceptance:_
  ```gherkin
  Scenario: <I see a meal plan that interests me>
    Given <I decide to read the reviews to make a decision.>
    When  <I open the review section>
    Then  <I see the customer reviews>
  ```

  - **US‑CUST‑002 — <Filtering/Sort Reviews>**  
  _Story:_ As a customer, I want to be able to filter and sort reviews to narrow down opinions that fit my needs and preferences
  _Acceptance:_
  ```gherkin
  Scenario: <Filtering reviews>
    Given <I am on the reviews section>
    When  <I filter reviews by 4 star rating and above and sort by newest >
    Then  <Only newer reviews with 4 star rating and above are displayed>
  ```

### 2.2 Provider Stories
- **US‑PROV‑001 — Register & manage profile**  
  _Story:_ As a provider, I want create/update my admin profile so that I can configure the UI/UX.  
  _Acceptance:_
  ```gherkin
  Scenario: Update admin profile
    Given I am a verified user
    When  I add or update profile details
    Then  the profile is saved.
  ```

- **US‑PROV‑002 — Create / edit items & meal plans**  
  _Story:_ As a provider, I want create new, and edit existing items and meal plans (name, price, image, description, ingredients & instructions, availability) routinely on the site so that customers have variety of choices of available items.  
  _Acceptance:_
  ```gherkin
  Scenario: Item and meal plan listing
    Given I am logged in as an admin
    When  I enter required information
    Then  the item is meal plan is added in "Published" state
    And   it becomes visible when searched, within 90-120 seconds.
  ```

- **US‑PROV‑003 — Add / edit dietary search filters**  
  _Story:_ As a provider, I want create and edit search filters based on the type of food item and any dietary restrictions, so that customers can easily find and build a meal plan tailored to them.
  _Acceptance:_
  ```gherkin
  Scenario: Ability to filter search
    Given I am logged in as an admin
    When  I enter information for a new meal or diet type
    Then  the type is added to the list of filters
    And   it becomes visible in the search within 90-120 seconds.
  ```

  - **US‑PROV‑004 — Reply to customer reviews**  
  _Story:_ As a provider, I want be able to reply to customer reviews so that i can acknowledge customer feedback and build repor.  
  _Acceptance:_
  ```gherkin
  Scenario: Reply to a review
    Given a customer publishes a review
    When  I submit a reply
    Then  the customer is notified and the reply is visible beneath the review.
  ```

  - **US‑PROV‑005 — View engagement & customer statistics**  
  _Story:_ As a provider, I want view active subscribers, churn rate, average rating, and reviews so that I can improve quality of service.  
  _Acceptance:_
  ```gherkin
  Scenario: View customer engagement
    Given I am logged in as an admin
    When  I open the app engagement dashboard
    Then  I select a date range
    And   I can see the active subscriber count, churn rate, and average rating for the target date range.
  ```
---

## 3. Non‑Functional Requirements (make them measurable)
- **Performance:** The app will load to the main screen within 2 seconds under normal load. API responses will return within 1.5 seconds, and the system will support up to 15,000 concurrent users without issue.  
- **Availability/Reliability:** The app will maintain 99.5% uptime per month.
- **Security/Privacy:** Secure authentication, passwords being stored using hashing, and data protection.
- **Usability:** The app will support many browsers/devices. A new user will be able to subscribe within 4 minutes.

---
## 4. Functional Requirements (Implemented Use-Cases)
### Customer Use-Cases

### Provider Use-Cases
**US-PROV-001 — Register & Manage Provider Profile**
Providers can create and update provider profiles including biography and contact information.
**US-PROV-002 — Create & Manage Meals**
Providers can:
- Add meals
- Edit meals
- Delete meals
- Assign dietary categories
**US-PROV-003 — Create & Manage Meal Plans**
Providers can:
- Create meal plans
- Add meals to meal plans
- Edit pricing/details
- Publish meal plans
**US-PROV-004 — Manage Subscription Plans**
Providers can create and update subscription plans with duration and pricing.
**US-PROV-005 — Manage Orders**
Providers can:
- View customer orders
- Update order statuses
**US-PROV-006 — View Reviews & Reply**
Providers can:
- View customer reviews
- Submit replies to reviews
**US-PROV-007 — View Analytics Dashboard**
Providers can view:
- Total orders
- Orders by status
- Subscription metrics
- Review statistics
---
## 5. Assumptions, Constraints, and Policies
- Stable internet connection
- Users provide accurate personal information
- Modern Browsers/devices 
- Third-party payment options 
- Terms and conditions
- Protection of user data
---

## 6. Milestones (course‑aligned)
- **M2 Requirements** — this file + stories opened as issues. 
- **M3 High‑fidelity prototype** — core customer/provider flows fully interactive. 
- **M4 Design** — architecture, schema, API outline. 
- **M5 Backend API** — key endpoints + tests. 
- **M6 Increment** — ≥2 use cases end‑to‑end. 
- **M7 Final** — complete system & documentation. 

---

## 7. Change Management
- Stories are living artifacts; changes are tracked via repository issues and linked pull requests.  
- Major changes should update this SRS.
