
# Requirements – Starter Template

**Project Name:** Balanced Bite \
**Team:** Names and roles \
**Course:** CSC 340\
**Version:** 1.0\
**Date:** 2026-01-30

---

## 1. Overview
**Vision.** One or two sentences: who this is for, the core problem, and the outcome.

**Glossary** Terms used in the project
- **Term 1:** description.
- **Term 2:** description

**Primary Users / Roles.**
- **Customer (e.g., Student/Patient/Pet Owner/etc. )** — 1 line goal statement.
- **Provider (e.g., Teacher/Doctor/Pet Sitter/etc. )** — 1 line goal statement.

**Scope (this semester).**
- <capability 1>
- <capability 2>
- <capability 3>

**Out of scope (deferred).**
- <deferred 1>
- <deferred 2>

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

- **US‑CUST‑002 — <View Mealplan information>**  
  _Story:_ As a customer, I want to view the information of the mealplan so that I can understand what it is before deciding.
  _Acceptance:_
  ```gherkin
  Scenario: <View meal plan details>
    Given <I am on the meal plans page>
    When  <I select a specific meal plan>
    Then  <it displays the meal plan information>
  ```

- **US‑CUST‑003 — <Browse Mealplan Options>**  
  _Story:_ As a customer, I want to browse meal plan options to pick the best option for me.
  _Acceptance:_
  ```gherkin
  Scenario: <Browsing a meal plan option>
    Given <Many different meal plan options>
    When  <I find the most suitable plan for me>
    Then  <I choose or save that specific meal plan>
  ```

- **US‑CUST‑004 — <Filter Mealplans>**  
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
    Then  <I am no longer subscribed to the mealplan app>
  ```

  - **US‑CUST‑006 — <Write Reviews>**  
  _Story:_ As a customer, I want to write a review on a mealplan I purchased to leave feedback for the provider, and future customers.
  _Acceptance:_
  ```gherkin
  Scenario: <Leaving a review>
    Given <I recieved a mealplan that I enjoy>
    When  <I write a review that describes my enjoymeny with the mealplan >
    Then  <the review is submitted to view for future customers>
  ```

  - **US‑CUST‑002 — <Read Reviews>**  
  _Story:_ As a customer, I want to be able to view reviews so that I make a decision.
  _Acceptance:_
  ```gherkin
  Scenario: <I see a mealplan that interests me>
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
- **US‑PROV‑001 — <short title>**  
  _Story:_ As a provider, I want … so that …  
  _Acceptance:_
  ```gherkin
  Scenario: <happy path>
    Given <preconditions>
    When  <action>
    Then  <observable outcome>
  ```

- **US‑PROV‑002 — <short title>**  
  _Story:_ As a provider, I want … so that …  
  _Acceptance:_
  ```gherkin
  Scenario: <happy path>
    Given <preconditions>
    When  <action>
    Then  <observable outcome>
  ```

### 2.3 SysAdmin Stories
- **US‑ADMIN‑001 — <short title>**  
  _Story:_ As a sysadmin, I want … so that …  
  _Acceptance:_
  ```gherkin
  Scenario: <happy path>
    Given <preconditions>
    When  <action>
    Then  <observable outcome>
  ```

- **US‑ADMIN‑002 — <short title>**  
  _Story:_ As a sysadmin, I want … so that …  
  _Acceptance:_
  ```gherkin
  Scenario: <happy path>
    Given <preconditions>
    When  <action>
    Then  <observable outcome>
  ```

---

## 3. Non‑Functional Requirements (make them measurable)
- **Performance:** The app will load to the main screen within 2 seconds under normal load. API responses will return within 1.5 seconds, and the system will support up to 15,000 concurrent users without issue.  
- **Availability/Reliability:** The app will maintain 99.5% uptime per month.
- **Security/Privacy:** Secure authentication, passwords being stored using hashing, and data protection.
- **Usability:** The app will support many browsers/devices. A new user will be able to subscribe within 4 minutes.

---

## 4. Assumptions, Constraints, and Policies
- Stable internet connection
- Users provide accurate personal information
- Modern Browsers/devices 
- Third-party payment options 
- Terms and conditions
- Protection of user data
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
