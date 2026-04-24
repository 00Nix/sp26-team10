<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>403 - Access Denied | Balanced Bite</title>
    <link rel="stylesheet" href="/styles/admin.css">
</head>
<body>
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
            <a href="/provider/analytics">ANALYTICS</a>
            <a href="/provider/profile">PROFILE</a>
        </nav>
        <div class="sidebar-bottom">
            <a href="/">BACK TO HOME</a>
            <a href="/logout">LOG OUT</a>
        </div>
    </aside>

    <main class="error-page">
        <section class="error-card">
            <p class="error-code">403</p>
            <h1 class="error-title">Access Denied</h1>
            <p class="error-text">
                Sorry, you do not have permission to access this page.
                Please log in with an authorized account or return to a page you can access.
            </p>

            <div class="error-actions">
                <a href="/" class="btn-action btn-primary">Go Home</a>
                <a href="/login" class="btn-action btn-secondary">Go to Login</a>
            </div>
        </section>
    </main>

</body>
</html>