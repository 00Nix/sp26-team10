<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Meals</title>
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
            <a class="sidebar-link" href="/provider/mealplans">Meal Plans</a>
            <a class="sidebar-link active" href="/provider/meals">Meals</a>
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
                    <h1 class="topbar-title">Meals</h1>
                    <p class="topbar-subtitle">Keep your menu fresh and organized.</p>
                </div>
            </div>
            <div class="topbar-actions">
                <a class="btn btn-cream" href="/provider/meals/add">+ Add Meal</a>
                <div class="avatar-badge">BB</div>
            </div>
        </header>

        <form action="/provider/meals" method="get" class="filter-bar">
            <label for="diet">Filter by Diet:</label>

            <select id="diet" name="diet" onchange="this.form.submit()">
                <option value="ALL" <#if selectedDiet == "ALL">selected</#if>>All</option>
                <option value="Balanced" <#if selectedDiet == "Balanced">selected</#if>>Balanced</option>
                <option value="Vegan" <#if selectedDiet == "Vegan">selected</#if>>Vegan</option>
                <option value="Vegetarian" <#if selectedDiet == "Vegetarian">selected</#if>>Vegetarian</option>
                <option value="Keto" <#if selectedDiet == "Keto">selected</#if>>Keto</option>
                <option value="Low Carb" <#if selectedDiet == "Low Carb">selected</#if>>Low Carb</option>
                <option value="Dairy-Free" <#if selectedDiet == "Dairy-Free">selected</#if>>Dairy-Free</option>
                <option value="Pescatarian" <#if selectedDiet == "Pescatarian">selected</#if>>Pescatarian</option>
            </select>
        </form>

        <main class="page-content">
            <#if meals?? && (meals?size > 0)>
                <div class="card-list">
                    <#list meals as meal>
                        <div class="card">
                            <h2>${meal.name!""}</h2>
                            <div class="meta-list">
                                <div><strong>Price:</strong> $${meal.price!0}</div>
                                <div><strong>Diet:</strong> ${meal.diet!""}</div>
                                <div><strong>Portion Size:</strong> ${meal.portionSize!""}</div>
                                <div><strong>Description:</strong> ${meal.description!""}</div>
                            </div>

                            <div class="actions-inline">
                                <a class="btn btn-cream" href="/provider/meals/${meal.mealId}/edit">Edit Meal</a>
                            </div>
                        </div>
                    </#list>
                </div>
            <#else>
                <div class="empty-state">No meals found.</div>
            </#if>
        </main>
    </div>
</div>
</body>
</html>