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