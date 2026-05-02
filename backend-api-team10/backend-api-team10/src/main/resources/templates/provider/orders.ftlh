<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Orders Dashboard</title>
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
            <a class="sidebar-link active" href="/provider/orders">Orders</a>
            <a class="sidebar-link" href="/provider/reviews">Reviews</a>
            <a class="sidebar-link" href="/provider/subscriptions">Plans</a>
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
                    <h1 class="topbar-title">Orders</h1>
                    <p class="topbar-subtitle">View incoming orders and update statuses.</p>
                </div>
            </div>
            <div class="topbar-actions">
                <div class="avatar-badge">BB</div>
            </div>
        </header>

        <section class="orders-analytics">
            <div class="orders-stat-card">
                <span>Total Orders</span>
                <h2>${totalOrders}</h2>
            </div>
            <div class="orders-stat-card">
                <span>Pending</span>
                <h2>${pendingOrders}</h2>
            </div>
            <div class="orders-stat-card">
                <span>Preparing</span>
                <h2>${preparingOrders}</h2>
            </div>
            <div class="orders-stat-card">
                <span>In Transit</span>
                <h2>${inTransitOrders}</h2>
            </div>
            <div class="orders-stat-card">
                <span>Delivered</span>
                <h2>${deliveredOrders}</h2>
            </div>
            <div class="orders-stat-card">
                <span>Cancelled</span>
                <h2>${cancelledOrders}</h2>
            </div>
        </section>

        <main class="page-content">
            <#if orders?? && (orders?size > 0)>
                <div class="card-list">
                    <#list orders as order>
                        <div class="card">
                            <h2>Order #${order.orderId}</h2>
                            <div class="meta-list">
                                <div><strong>Total:</strong> $${order.totalPrice!0}</div>
                                <div><strong>Status:</strong> ${order.status!"N/A"}</div>
                                <div><strong>Address:</strong> ${order.address!""}</div>
                                <div><strong>Date:</strong> ${order.timestamp?string?substring(0, 10)}</div>
                            </div>

                            <div class="actions-inline">
                                <a class="btn btn-cream" href="/provider/orders/${order.orderId}/edit">Update Status</a>
                            </div>
                        </div>
                    </#list>
                </div>
            <#else>
                <div class="empty-state">No orders found.</div>
            </#if>
        </main>
    </div>
</div>
</body>
</html>