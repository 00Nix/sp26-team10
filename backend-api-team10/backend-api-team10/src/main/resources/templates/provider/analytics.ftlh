<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Analytics Dashboard</title>
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
            <a class="sidebar-link" href="/provider/meals">Meals</a>
            <a class="sidebar-link active" href="/provider/analytics">Analytics</a>
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
                    <h1 class="topbar-title">Analytics</h1>
                    <p class="topbar-subtitle">Monitor subscriber trends, order volume, and revenue.</p>
                </div>
            </div>
            <div class="topbar-actions">
                <div class="search-bar">
                    <span>⌕</span>
                    <input type="text" placeholder="Search analytics">
                </div>
                <div class="avatar-badge">BB</div>
            </div>
        </header>

        <main class="page-content section-stack">
            <section class="stats-row">
                <div class="stat-card">
                    <div class="stat-label">Total Revenue</div>
                    <div class="stat-value">$${analytics.totalRevenue!0}</div>
                    <div class="stat-change">Revenue across all completed orders</div>
                </div>

                <div class="stat-card">
                    <div class="stat-label">Total Orders</div>
                    <div class="stat-value">${analytics.totalOrders!0}</div>
                    <div class="stat-change">All-time provider orders</div>
                </div>

                <div class="stat-card">
                    <div class="stat-label">Active Subscribers</div>
                    <div class="stat-value">${analytics.activeSubscribers!0}</div>
                    <div class="stat-change">Current paying customers</div>
                </div>

                <div class="chart-card">
                    <div class="stat-label">Orders This Month</div>
                    <div class="stat-value">${analytics.monthlyOrders!182}</div>
                    <div class="chart-placeholder"></div>
                </div>
            </section>

            <section class="panel">
                <div class="page-content">
                    <div class="plan-toolbar">
                        <div>
                            <h2 class="section-title">Subscriber Statistics</h2>
                            <p class="section-caption">Compare plan performance and retention.</p>
                        </div>

                        <div class="filter-group">
                            <button class="btn btn-pill-dark" type="button">Essential</button>
                            <button class="btn btn-pill-light" type="button">Balanced Pro</button>
                            <button class="btn btn-pill-light" type="button">Elite Custom</button>
                        </div>
                    </div>

                    <div class="analytics-panel">
                        <div class="analytics-side-cards">
                            <div class="stat-card">
                                <div class="stat-label">Selected Plan</div>
                                <div class="stat-value">${selectedPlan!"Essential"}</div>
                                <div class="stat-change">Current plan view</div>
                            </div>

                            <div class="analytics-mini-card">
                                <div class="stat-label">Monthly Revenue</div>
                                <div class="stat-value">$${analytics.monthlyPlanRevenue!1378.30}</div>
                                <div class="stat-change">Estimated recurring revenue</div>
                            </div>

                            <div class="analytics-mini-card">
                                <div class="stat-label">Active Subscribers</div>
                                <div class="stat-value">${analytics.activeSubscribers!0}</div>
                                <div class="stat-change">Renewed this cycle</div>
                            </div>

                            <div class="analytics-mini-card">
                                <div class="stat-label">Total Subscribers</div>
                                <div class="stat-value">${analytics.totalSubscribers!0}</div>
                                <div class="stat-change">Historic signups</div>
                            </div>
                        </div>

                        <div class="analytics-chart-box">
                            <div class="flex-between">
                                <div>
                                    <div class="stat-label">Plan Growth</div>
                                    <div class="stat-value">${analytics.planSubscribers!76}</div>
                                </div>

                                <div class="toggle-group">
                                    <button class="btn btn-sage" type="button">Monthly</button>
                                    <button class="btn btn-outline" type="button">Yearly</button>
                                </div>
                            </div>

                            <div class="chart-placeholder"></div>
                            <p class="section-caption">Track new subscriptions, renewals, and unsubscribes over time.</p>
                        </div>
                    </div>
                </div>
            </section>
        </main>
    </div>
</div>
</body>
</html>