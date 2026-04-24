<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Subscription Plans</title>
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
            <a class="sidebar-link active" href="/provider/subscriptions">Plans</a>
            <a class="sidebar-link" href="/provider/mealplans">Meal Plans</a>
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
                    <h1 class="topbar-title">Subscription Plans</h1>
                    <p class="topbar-subtitle">Manage your plan lineup and pricing.</p>
                </div>
            </div>
            <div class="topbar-actions">
                <a href="/provider/plans/new" class="btn btn-cream">+ Create New Plan</a>
                <div class="avatar-badge">BB</div>
            </div>
        </header>

        <main class="page-content section-stack">
            <section class="plan-toolbar">
                <div class="toggle-group">
                    <button class="btn btn-pill-dark" type="button">Monthly</button>
                    <button class="btn btn-pill-light" type="button">Yearly</button>
                </div>
            </section>

            <section class="plan-grid">
                <#list plans as plan>
                    <div class="plan-card">
                        <div>
                            <h3>${plan.name}</h3>
                            <ul class="plan-features">
                                <li>${plan.description!''}</li>
                                <#if plan.features??>
                                    <#list plan.features?split(";") as feature>
                                        <li>${feature?trim}</li>
                                    </#list>
                                </#if>
                            </ul>
                        </div>

                        <div>
                            <div class="plan-price-wrap">
                                <span class="btn btn-sage">$${plan.price!0} / month</span>
                            </div>

                            <div class="plan-actions">
                                <a href="/provider/plans/edit/${plan.plan_id}" class="btn btn-cream">Edit</a>
                            </div>
                        </div>
                    </div>
                </#list>
            </section>
        </main>
    </div>
</div>
</body>
</html>