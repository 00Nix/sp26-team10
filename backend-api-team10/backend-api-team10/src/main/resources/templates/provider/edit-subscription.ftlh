<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Subscription Plan</title>
    <link rel="stylesheet" href="/styles/admin.css">
</head>
<body>
<main class="page-container">
    <a class="utility-back" href="/provider/subscriptions">← Back to Subscription Plans</a>

    <div class="form-shell">
        <h2 class="form-title-center">Edit Subscription Plan</h2>
        <hr class="form-divider-small">

        <form action="/provider/subscriptions/${subscription.planId}/update" method="post" class="section-stack">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            
            <div class="form-group">
                <label class="form-label" for="name">Plan Name</label>
                <input class="form-input" type="text" id="name" name="name" value="${subscription.name!''}" required>
            </div>

            <div class="form-group">
                <label class="form-label" for="price">Price</label>
                <input class="form-input" type="number" id="price" name="price" step="0.01" value="${subscription.price!0}" required>
            </div>

            <div class="form-group">
                <label class="form-label" for="description">Description</label>
                <textarea class="form-textarea" id="description" name="description">${subscription.description!''}</textarea>
            </div>

            <div class="form-group">
                <label class="form-label" for="durationWeeks">Duration</label>
                <input class="form-input" type="number" id="durationWeeks" name="durationWeeks" value="${subscription.durationWeeks!0}" required>
            </div>

            <div class="form-group">
                <label class="form-label" for="features">Features</label>
                <textarea class="form-textarea" id="features" name="features">${subscription.features!''}</textarea>
            </div>

            <button class="btn btn-cream" type="submit">Update Subscription Plan</button>
        </form>
    </div>
</main>
</body>
</html>