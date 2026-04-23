<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create Meal</title>
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
            <h1 class="page-title">Create Meal</h1>
            <p class="page-subtitle">Manage your account settings and preferences</p>
            <hr class="page-divider">
        </div>

        <div class="form-shell">
            <div class="form-two-col">
                <div>
                    <h2 class="form-title-center">Meal Plan Information</h2>
                    <hr class="form-divider-small">

                    <form action="/provider/meals/save" method="post">
                        <input type="hidden" name="meal_id" value="${meal.meal_id!}">

                        <div class="form-group">
                            <label class="form-label">Image URL</label>
                            <input class="form-input" type="text" name="imageUrl" value="${meal.imageUrl!}">
                        </div>

                        <div class="form-group">
                            <label class="form-label">Item Name</label>
                            <input class="form-input" type="text" name="name" value="${meal.name!}">
                        </div>

                        <div class="form-group">
                            <label class="form-label">Item Price</label>
                            <input class="form-input" type="number" step="0.01" name="price" value="${meal.price!}">
                        </div>

                        <div class="form-group">
                            <label class="form-label">Item Description</label>
                            <textarea class="form-textarea" name="description">${meal.description!}</textarea>
                        </div>

                        <button class="btn btn-cream" type="submit">Publish Meal</button>
                    </form>
                </div>

                <div class="preview-card">
                    <img
                        class="preview-image"
                        src="${meal.imageUrl!'https://images.unsplash.com/photo-1547592180-85f173990554?q=80&w=1200&auto=format&fit=crop'}"
                        alt="Meal preview">

                    <div class="preview-meta">
                        <div class="preview-brand">Brand</div>
                        <div class="preview-name">${meal.name!'Product name'}</div>
                        <div class="preview-price">$${meal.price!'10.99'}</div>
                        <div class="preview-description">${meal.description!'Description'}</div>
                    </div>
                </div>
            </div>
        </div>
    </main>
</div>
</body>
</html>