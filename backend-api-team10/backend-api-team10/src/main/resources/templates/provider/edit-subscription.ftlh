<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Subscription Plan</title>
    <link rel="stylesheet" href="/static/admin.css">
</head>
<body>
    <main class="page-container">
        <a href="/provider/subscriptions">← Back to Subscription Plans</a>
        <h1>Edit Subscription Plan</h1>

        <form action="/provider/subscriptions/${subscription.plan_id}/update" method="post" class="form-card">
            <label for="name">Plan Name</label>
            <input type="text" id="name" name="name" value="${subscription.name!''}" required>

            <label for="price">Price</label>
            <input type="number" id="price" name="price" step="0.01" value="${subscription.price!0}" required>

            <label for="description">Description</label>
            <textarea id="description" name="description" rows="4">${subscription.description!''}</textarea>

            <label for="duration">Duration</label>
            <input type="number" id="duration" name="duration" value="${subscription.duration!0}" required>

            <label for="features">Features</label>
            <textarea id="features" name="features" rows="4">${subscription.features!''}</textarea>

            <button type="submit">Update Subscription Plan</button>
        </form>
    </main>
</body>
</html>