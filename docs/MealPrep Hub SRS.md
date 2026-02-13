
# Requirements – Starter Template

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
- **US‑CUST‑001 — <short title>**  
  _Story:_ As a customer, I want … so that …  
  _Acceptance:_
  ```gherkin
  Scenario: <happy path>
    Given <preconditions>
    When  <action>
    Then  <observable outcome>
  ```

- **US‑CUST‑002 — <short title>**  
  _Story:_ As a customer, I want … so that …  
  _Acceptance:_
  ```gherkin
  Scenario: <happy path>
    Given <preconditions>
    When  <action>
    Then  <observable outcome>
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
- **Performance:** description 
- **Availability/Reliability:** description
- **Security/Privacy:** description
- **Usability:** description

---

## 4. Assumptions, Constraints, and Policies
- list any rules, policies, assumptions, etc.

---

## 5. Milestones (course‑aligned)
- **M2 Requirements** — this file + stories opened as issues. 
- **M3 High‑fidelity prototype** — core customer/provider flows fully interactive. 
- **M4 Design** — architecture, schema, API outline. 
- **M5 Backend API** — key endpoints + tests. 
- **M6 Increment** — ≥2 use cases end‑to‑end. 
- **M7 Final** — complete system & documentation. 

---

## 6. Change Management
- Stories are living artifacts; changes are tracked via repository issues and linked pull requests.  
- Major changes should update this SRS.
