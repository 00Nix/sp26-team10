<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Meals</title>
    <link rel="stylesheet" href="/static/admin.css">
</head>
<body>
    <main class="page-container">
        <a href="/provider/dashboard">← Back to Dashboard</a>
        <h1>Meals</h1>

        <p>
            <a class="button-link" href="/provider/meals/add">Add Meal</a>
        </p>

        <#if meals?? && (meals?size > 0)>
            <div class="card-list">
                <#list meals as meal>
                    <div class="card">
                        <h2>${meal.name!""}</h2>
                        <p><strong>Price:</strong> $${meal.price!0}</p>
                        <p><strong>Diet:</strong> ${meal.diet!""}</p>
                        <p><strong>Portion Size:</strong> ${meal.portion_size!""}</p>
                        <p><strong>Description:</strong> ${meal.description!""}</p>

                        <a class="button-link" href="/provider/meals/${meal.meal_id}/edit">
                            Edit Meal
                        </a>
                    </div>
                </#list>
            </div>
        <#else>
            <p>No meals found.</p>
        </#if>
    </main>
</body>
</html>