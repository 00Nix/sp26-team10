<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${pageTitle!"Provider Dashboard"}</title>
    <link rel="stylesheet" href="/static/admin.css">
</head>
<body>
    <main class="page-container">
        <h1>${pageTitle!"Provider Dashboard"}</h1>
        <p>Manage your profile, plans, meals, orders, reviews, and analytics.</p>

        <div class="dashboard-grid">
            <a class="dashboard-card" href="/provider/profile/{provider_id}/edit">
                <h2>Update Profile</h2>
                <p>Edit your provider details and biography.</p>
            </a>

            <a class="dashboard-card" href="/provider/subscriptions">
                <h2>Subscription Plans</h2>
                <p>View and edit subscription plans.</p>
            </a>

            <a class="dashboard-card" href="/provider/analytics">
                <h2>Analytics</h2>
                <p>View orders, revenue, and meal plan stats.</p>
            </a>

            <a class="dashboard-card" href="/provider/orders">
                <h2>Orders</h2>
                <p>View all orders and update their status.</p>
            </a>

            <a class="dashboard-card" href="/provider/reviews">
                <h2>Reviews</h2>
                <p>Read customer reviews and reply to them.</p>
            </a>

            <a class="dashboard-card" href="/provider/mealplans">
                <h2>Meal Plans</h2>
                <p>Add and edit meal plans.</p>
            </a>

            <a class="dashboard-card" href="/provider/meals">
                <h2>Meals</h2>
                <p>Add and edit meals.</p>
            </a>
        </div>
    </main>
</body>
</html>