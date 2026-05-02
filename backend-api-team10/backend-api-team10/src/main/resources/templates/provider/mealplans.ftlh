<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Meal Plans</title>
    <link rel="stylesheet" href="/styles/admin.css">
</head>
<body class="admin-body">
    <div class="admin-layout">
        <input type="checkbox" id="sidebar-toggle" class="sidebar-toggle">

        <aside class="sidebar">
            <div class="sidebar-brand">
                <h1>BALANCED<br>BITE</h1>
                <p>Provider Admin Portal</p>
            </div>
            <nav class="sidebar-nav">
                <a class="sidebar-link" href="/provider/dashboard">Dashboard</a>
                <a class="sidebar-link" href="/provider/orders">Orders</a>
                <a class="sidebar-link" href="/provider/reviews">Reviews</a>
                <a class="sidebar-link" href="/provider/subscriptions">Plans</a>
                <a class="sidebar-link active" href="/provider/mealplans">Meal Plans</a>
                <a class="sidebar-link" href="/provider/meals">Meals</a>
                <a class="sidebar-link" href="/provider/analytics">Analytics</a>
                <a class="sidebar-link" href="/provider/profile">Profile</a>
            </nav>
            <div class="sidebar-bottom">
                <a href="/">Back to Home</a>
                <a href="/logout">Log Out</a>
            </div>
        </aside>

        <label for="sidebar-toggle" class="sidebar-overlay"></label>

        <div class="main-shell">
            <header class="topbar">
                <div class="topbar-left">
                    <label for="sidebar-toggle" class="mobile-menu-btn">☰</label>
                    <div>
                        <h1 class="topbar-title">Meal Plans</h1>
                        <p class="topbar-subtitle">Create premade and subscription-based plans.</p>
                    </div>
                </div>
                <div class="topbar-actions">
                    <a class="btn btn-cream" href="/provider/mealplans/add">+ Add Meal Plan</a>
                    <div class="avatar-badge">BB</div>
                </div>
            </header>

            <main class="page-content">
                <div class="mealplan-grid">
                    <#if mealPlans?? && mealPlans?size gt 0>
                        <#list mealPlans as mealPlan>
                            <div class="mealplan-card">
                                <div class="mealplan-card-header">
                                    <h2>${mealPlan.name}</h2>
                                    <span class="mealplan-price">$${mealPlan.price}</span>
                                </div>

                                <p class="mealplan-diet">${mealPlan.diet!"No diet label"}</p>

                                <p class="mealplan-description">
                                    ${mealPlan.description!"No description available."}
                                </p>

                                <div class="mealplan-meals">
                                    <h3>Meals Included</h3>

                                    <#if mealPlan.mealPlanMeal?? && mealPlan.mealPlanMeal?size gt 0>
                                        <ul>
                                            <#list mealPlan.mealPlanMeal as planMeal>
                                                <li>
                                                    ${planMeal.meal.name!"Unnamed Meal"}
                                                    <span>x ${planMeal.quantity}</span>
                                                </li>
                                            </#list>
                                        </ul>
                                    <#else>
                                        <p>No meals added.</p>
                                    </#if>
                                </div>

                                <div class="mealplan-actions">
                                    <a class="btn btn-secondary" href="/provider/mealplans/${mealPlan.mealPlanId}/edit">
                                        Edit
                                    </a>
                                </div>
                            </div>
                        </#list>
                    <#else>
                        <p>No meal plans have been created yet.</p>
                    </#if>
                </div>
                
            </main>

        </div>
        
    </div>
    
</body>
</html>