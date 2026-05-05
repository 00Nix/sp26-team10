<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Create Meal Plan</title>
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
            <a class="sidebar-link active" href="/provider/mealplans">Meal Plans</a>
            <a class="sidebar-link" href="/provider/meals">Meals</a>
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
                    <h1 class="topbar-title">Create Meal Plan</h1>
                    <p class="topbar-subtitle">Add a curated meal plan for your customers.</p>
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
                        <h2 class="form-title-center">Meal Plan Information</h2>
                        <hr class="form-divider-small">

                        <form action="/provider/mealplans/add" method="post">
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

                            <div class="form-group">
                                <label class="form-label" for="name">Plan Name</label>
                                <input class="form-input" type="text" id="name" name="name" required>
                            </div>

                            <div class="form-group">
                                <label class="form-label" for="price">Price</label>
                                <input class="form-input" type="number" step="0.01" id="price" name="price" required>
                            </div>

                            <div class="form-group">
                                <label class="form-label" for="diet">Dietary Label</label>
                                <input class="form-input" type="text" id="diet" name="diet" placeholder="Vegan, Low Carb, Gluten Free">
                            </div>

                            <div class="form-group">
                                <label class="form-label" for="isPremade">Premade</label>
                                <select class="form-select" id="isPremade" name="isPremade">
                                    <option value="true">Yes</option>
                                    <option value="false">No</option>
                                </select>
                            </div>

                            <div class="form-group">
                                <label class="form-label">Select Meals</label>

                                <#if meals?? && meals?size gt 0>
                                    <div class="checkbox-grid">
                                        <#list meals as meal>
                                            <label class="checkbox-card">
                                                <input type="checkbox" name="mealIds" value="${meal.mealId}">
                                                <span>${meal.name}</span>
                                                <small>${meal.price}</small>
                                            </label>
                                        </#list>
                                    </div>
                                <#else>
                                    <p>No meals available. Add meals before creating a meal plan.</p>
                                </#if>
                            </div>

                            <div class="form-group">
                                <label class="form-label" for="description">Description</label>
                                <textarea class="form-input" id="description" name="description" rows="4"></textarea>
                            </div>


                            <button class="btn btn-cream" type="submit">Publish Meal Plan</button>
                        </form>
                    </div>

                    <div class="preview-card">
                        <img class="preview-image" src="https://images.unsplash.com/photo-1490645935967-10de6ba17061?q=80&w=1200&auto=format&fit=crop" alt="Meal plan preview">
                        <div class="preview-meta">
                            <div class="preview-brand">Balanced Bite Plans</div>
                            <div class="preview-name">Plan Preview</div>
                            <div class="preview-price">$0.00</div>
                            <div class="preview-description">Preview panel for your meal plan, designed to feel more like a polished dashboard product card.</div>
                        </div>
                    </div>
                </div>
            </div>
        </main>
    </div>
</div>
</body>
</html>