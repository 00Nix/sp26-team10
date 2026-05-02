<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Meal</title>
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
                    <h1 class="topbar-title">Edit Meal</h1>
                    <p class="topbar-subtitle">Update meal details and pricing.</p>
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

                        <form action="/provider/meals/${meal.mealId}/update" method="post">
                            <div class="form-group">
                                <label class="form-label" for="name">Meal Name</label>
                                <input class="form-input" type="text" id="name" name="name" value="${meal.name!''}" required>
                            </div>

                            <div class="form-group">
                                <label class="form-label" for="description">Description</label>
                                <textarea class="form-textarea" id="description" name="description">${meal.description!''}</textarea>
                            </div>

                            <div class="form-group">
                                <label class="form-label" for="diet">Diet</label>
                                <input class="form-input" type="text" id="diet" name="diet" value="${meal.diet!''}">
                            </div>

                            <div class="form-group">
                                <label class="form-label" for="portionSize">Portion Size</label>
                                <input class="form-input" type="text" id="portionSize" name="portionSize" value="${meal.portionSize!''}">
                            </div>

                            <div class="form-group">
                                <label class="form-label" for="price">Price</label>
                                <input class="form-input" type="number" id="price" name="price" step="0.01" value="${meal.price!0}" required>
                            </div>

                            <div class="form-group">
                                <label for="imageUrl">Image URL</label>
                                <input type="text" id="imageUrl" name="imageUrl" value="${meal.imageUrl!''}" placeholder="/images/example.png">
                            </div>

                            <button class="btn btn-cream" type="submit">Update Meal</button>
                        </form>
                    </div>

                    <div class="preview-card">
                        <img class="preview-image" src="${meal.imageUrl!'/images/default-meal.jpg'}" alt="${meal.name!'Meal Name'}">
                        <div class="preview-meta">
                            <div class="preview-brand">Balanced Bite</div>
                            <div class="preview-name">${meal.name!'Meal Name'}</div>
                            <div class="preview-price">$${meal.price!0}</div>
                            <div class="preview-description">${meal.description!'Meal description preview.'}</div>
                        </div>
                    </div>
                </div>
            </div>
        </main>
    </div>
</div>
</body>
</html>