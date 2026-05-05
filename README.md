# csc340-project

## Title
> Balanced Bite

## Team Members
> Caleb Nix 
> Jasmine Butts

## Description 
> A meal prepping service that offers its customers with time-saving options, so they can enjoy healthy, nutritious meals without the hassle.
> This service is to help people who don't have the time or ability to make their own meals. The goal of this is to help alleviate the stress of planning, shopping, and cooking meals every day. 
>
## App Functions
1. Customer:
    1. Create/modify customer profile - Register an account with their email or number.
    2. View available services - Browse meals, see prices, and an option for filters based on meal type and dietary needs.
    3. Create or select a pre-built a meal plan - Favorite meals and the ability to edit the list. Add and edit meals in cart, submit payment information and order. Order confirmation page and the ability to view past orders.
    4. Subscribe to available services - Select a subscription option (e.g., weekly, monthly, or yearly).  
    5. Write reviews for subscribed services - Customers will be able to leave reviews on meals they have tried.
2. Provider:
    1. Create/modify/remove provider profile - Can register as an admin (meal provider)
    2. Create services - Add and update meals, prices, and descriptions. Create and update dietary search filters.
    3. View customer statistics - Can see customer order totals, preferred filters and meals, subscription status, and when the customer joined.
    4. Reply to reviews - Provider can view and reply to customer reviews.

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
