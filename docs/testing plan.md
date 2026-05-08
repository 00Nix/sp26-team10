**Project Name: Balanced Bite**   
**Version: 1.0** 
**Date: 5/5/26**  
**Purpose: This documents the actor and uses cases for this project** 

## Actors
- Provider P: Jasmine B
- Customer C: Caleb N
- Service S: Meal Plan

## Use Cases
#### 1. Customer: US‑CUST‑001 — Register & manage profile
1. Customer C1 register in for the first time and creates a profile.
2. C1 edits their profile to their liking.
3. C1 exists.

#### 2. Customer: US‑CUST‑002 — Adding & purchasing a meal
1. Customer chooses and adds a meal to the cart
2. customer can edit the cart
3. Customer checkouts

#### 3. Customer: US‑CUST‑003 — Making a review
1. Customer chooses and a meal to review
2. customer writes review
3. Customer can view reviews

#### 6. Provider: US‑PROV‑001 — Register and login 
1. Provider registers and creates a profile
2. Provider logs in
3. Provider manages thir profile to their liking
4. Provider exists

#### 7. Provider: US-PROV-002 - Reply to Review
1. Provider logs in
2. Provider views the customer reviews
3. Provider replys back to the customer

## CROSS-CUTTING TEST SCENARIOS (Non-Functional Requirements)

### Performance Requirements

**Scenario P1: Discover page response time < 1.5 seconds**
- **Setup:** Server under typical load
- **Steps:**
  1. Measure response time for "Browse" page load with 5 active providers, 10+ services
  2. Repeat 10 times
- **Expected Outcome:** 95% of requests ≤ 1.5 seconds

**Scenario P2:**
- **Setup:** 
- **Steps:**
  1. x
  2. y
- **Expected Outcome:** 

### Security & Privacy Requirements

**Scenario S1: Role based register and login**
- **Setup: Customer access provider dashboard** 
- **Steps:**
  1. Customer makes an account and then login
  2. Navigates to login as a provider 
  3. Observes response
- **Expected Outcome:**
  1. Error page

**Scenario S2: Provider can not edit customer profile**
- **Setup: Provider logs in, but has no access to customer account** 
- **Steps:**
  1. Provider logs in
  2. Tries to access customers account
- **Expected Outcome:**
  1. Error page

### Usability Requirements

**Scenario U1: User register and login in < 2 minutes**
- **Setup: User participates in hallway test** 
- **Steps:**
  1. User presses on join now
  2. User fills out information to register
  3. User then logs in
- **Expected Outcome:** 

**Scenario U2: Provider can create meal in < 5 min**
- **Setup: Provider creating meal** 
- **Steps:**
  1. Provider signs in
  2. Fills out the information to create a meal
  3. Submits the meal
- **Expected Outcome: Time to complete < 5 minutes** 