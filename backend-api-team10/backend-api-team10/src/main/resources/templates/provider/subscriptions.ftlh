<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Subscription Plans</title>
    <link rel="stylesheet" href="/static/admin.css">
</head>
<body>
<div class="admin-layout">
    <aside class="sidebar">
        <div class="sidebar-brand">
            <h1>BALANCED<br>BITE</h1>
            <p>Admin Portal</p>
        </div>
        <nav class="sidebar-nav">
            <a href="/provider/dashboard">DASHBOARD</a>
            <a href="/provider/orders">ORDERS</a>
            <a href="/provider/reviews">REVIEWS</a>
            <a href="/provider/plans" class="active">PLANS</a>
            <a href="/provider/analytics">ANALYTICS</a>
            <a href="/provider/profile">PROFILE</a>
        </nav>
        <div class="sidebar-bottom">
            <a href="/">BACK TO HOME</a>
            <a href="/logout">LOG OUT</a>
        </div>
    </aside>

    <main class="main-content">
        <div class="page-header">
            <h1 class="page-title">Subscription Plans</h1>
            <p class="page-subtitle" style="letter-spacing:1px;">Manage subscription plans</p>
            <hr class="page-divider">
        </div>

        <div class="plan-toolbar">
            <div class="toggle-group">
                <button class="btn btn-pill-dark" type="button">Monthly</button>
                <button class="btn btn-pill-light" type="button">Yearly</button>
            </div>
            <a href="/provider/plans/new" class="btn btn-cream">+ CREATE NEW PLAN</a>
        </div>

        <div class="plan-grid">
            <#list plans as plan>
                <div class="plan-card">
                    <div>
                        <h3>${plan.name}</h3>

                        <ul class="plan-features">
                            <li>${plan.description}</li>
                            <#if plan.features??>
                                <#list plan.features?split(";") as feature>
                                    <li>${feature?trim}</li>
                                </#list>
                            </#if>
                        </ul>
                    </div>

                    <div>
                        <div class="plan-price-wrap">
                            <span class="btn btn-sage">$${plan.price} per month</span>
                        </div>

                        <div class="plan-actions">
                            <a href="/provider/plans/edit/${plan.plan_id}" class="btn btn-cream">EDIT</a>
                        </div>
                    </div>
                </div>
            </#list>
        </div>
    </main>
</div>
</body>
</html>