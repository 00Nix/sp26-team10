<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Meal</title>
    <link rel="stylesheet" href="/static/style.css">
</head>
<body>
    <main class="page-container">
        <a href="/provider/meals">← Back to Meals</a>
        <h1>Add Meal</h1>

        <form action="/provider/meals/add" method="post" class="form-card">
            <label for="name">Meal Name</label>
            <input type="text" id="name" name="name" required>

            <label for="description">Description</label>
            <textarea id="description" name="description" rows="4"></textarea>

            <label for="diet">Diet</label>
            <input type="text" id="diet" name="diet">

            <label for="portionSize">Portion Size</label>
            <input type="text" id="portionSize" name="portion_size">

            <label for="price">Price</label>
            <input type="number" id="price" name="price" step="0.01" required>

            <button type="submit">Save Meal</button>
        </form>
    </main>
</body>
</html>