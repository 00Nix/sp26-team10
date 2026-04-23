<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Analytics Dashboard</title>
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
            <a href="/provider/plans">PLANS</a>
            <a href="/provider/analytics" class="active">ANALYTICS</a>
            <a href="/provider/profile">PROFILE</a>
        </nav>
        <div class="sidebar-bottom">
            <a href="/">BACK TO HOME</a>
            <a href="/logout">LOG OUT</a>
        </div>
    </aside>

    <main class="main-content">
        <div class="page-header">
            <h1 class="page-title">Analytics Dashboard</h1>
            <hr class="page-divider">
        </div>

        <div class="stats-row">
            <div class="stat-card">
                <div class="stat-label">Total Revenue</div>
                <div class="stat-value">$${analytics.totalRevenue!0}</div>
                <div class="stat-change">+20% month over month</div>
            </div>

            <div class="stat-card">
                <div class="stat-label">Total Orders</div>
                <div class="stat-value">${analytics.totalOrders!0}</div>
                <div class="stat-change">+33% month over month</div>
            </div>

            <div class="stat-card">
                <div class="stat-label">Active Subscribers</div>
                <div class="stat-value">${analytics.activeSubscribers!0}</div>
                <div class="stat-change">-8% month over month</div>
            </div>

            <div class="chart-card">
                <div class="flex-between">
                    <div class="stat-label">Orders</div>
                    <div>This Month</div>
                </div>
                <div class="stat-value" style="color: var(--sage); margin-top: 10px;">182</div>
                <div class="chart-placeholder" style="height: 120px;"></div>
            </div>
        </div>

        <div class="flex-between" style="margin-bottom: 18px;">
            <div>
                <h2 class="section-title-script" style="letter-spacing:4px;">Subscriber Statistics</h2>
                <hr class="page-divider" style="width: 340px; margin-top: 8px;">
            </div>

            <div class="filter-group">
                <button class="btn btn-pill-dark">Essential</button>
                <button class="btn btn-pill-light">Balanced Pro</button>
                <button class="btn btn-pill-light">Elite Custom</button>
            </div>
        </div>

        <div class="analytics-panel">
            <div class="analytics-side-cards">
                <div>
                    <h2 style="font-size: 56px; line-height: 1;">Essential</h2>
                    <hr class="page-divider" style="margin-top: 8px;">
                </div>

                <div class="toggle-group">
                    <button class="btn btn-sage">Monthly</button>
                    <button class="btn btn-outline">Yearly</button>
                </div>

                <div class="analytics-mini-card">
                    <div class="stat-label">Monthly Revenue</div>
                    <div class="stat-value">$1,378.30</div>
                    <div class="stat-change">+20% month over month</div>
                </div>

                <div class="analytics-mini-card">
                    <div class="stat-label">Active Subscribers</div>
                    <div class="stat-value">${analytics.activeSubscribers!0}</div>
                    <div class="stat-change">-8% month over month</div>
                </div>

                <div class="analytics-mini-card">
                    <div class="stat-label">Total Subscribers</div>
                    <div class="stat-value">${analytics.totalSubscribers!0}</div>
                    <div class="stat-change">+33% month over month</div>
                </div>
            </div>

            <div class="analytics-chart-box">
                <div class="flex-between">
                    <div class="stat-label">Essential Plan Subscribers</div>
                    <div>This Month</div>
                </div>
                <div class="stat-value" style="color: var(--sage);">76</div>
                <div style="font-size: 18px;">50 subscribers</div>
                <div class="chart-placeholder"></div>
                <div style="margin-top: 12px; color:#666;">Monthly &nbsp; Yearly &nbsp; Unsubscribed</div>
            </div>
        </div>
    </main>
</div>
</body>
</html>