<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Meal</title>
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
            <a href="/customer/index">Back to Home</a>
            <a href="/logout">Log Out</a>
        </div>
    </aside>

    <label for="sidebar-toggle" class="sidebar-overlay"></label>

    <div class="main-shell">
        <header class="topbar">
            <div class="topbar-left">
                <label for="sidebar-toggle" class="mobile-menu-btn">☰</label>
                <div>
                    <h1 class="topbar-title">Add Meal</h1>
                    <p class="topbar-subtitle">Create a new menu item for your storefront.</p>
                </div>
            </div>
            <div class="topbar-actions">
                <div class="avatar-badge">BB</div>
            </div>
        </header>

        <main class="page-content">
            <div class="form-shell">
                <div class="form-two-col">
                    <div>
                        <h2 class="form-title-center">Meal Information</h2>
                        <hr class="form-divider-small">

                        <form action="/provider/meals/add" method="post">
                            <div class="form-group">
                                <label class="form-label" for="name">Meal Name</label>
                                <input class="form-input" type="text" id="name" name="name" required>
                            </div>

                            <div class="form-group">
                                <label class="form-label" for="description">Description</label>
                                <textarea class="form-textarea" id="description" name="description"></textarea>
                            </div>

                            <div class="form-group">
                                <label class="form-label" for="diet">Diet</label>
                                <input class="form-input" type="text" id="diet" name="diet">
                            </div>

                            <div class="form-group">
                                <label class="form-label" for="portionSize">Portion Size</label>
                                <input class="form-input" type="text" id="portionSize" name="portion_size">
                            </div>

                            <div class="form-group">
                                <label class="form-label" for="price">Price</label>
                                <input class="form-input" type="number" id="price" name="price" step="0.01" required>
                            </div>

                            <div class="form-group">
                                <label for="imageUrl">Image URL</label>
                                <input type="text" id="imageUrl" name="imageUrl" value="${meal.imageUrl!''}" placeholder="/images/example.png">
                            </div>

                            <button class="btn btn-cream" type="submit">Save Meal</button>
                        </form>
                    </div>

                    <div class="preview-card">
                        <img class="preview-image" src="https://images.unsplash.com/photo-1547592180-85f173990554?q=80&w=1200&auto=format&fit=crop" alt="Meal preview">
                        <div class="preview-meta">
                            <div class="preview-brand">Balanced Bite</div>
                            <div class="preview-name">Your Meal Preview</div>
                            <div class="preview-price">$0.00</div>
                            <div class="preview-description">A clean product-style preview panel inspired by your Figma admin layouts.</div>
                        </div>
                    </div>
                </div>
            </div>
        </main>
    </div>
</div>
</body>
</html>