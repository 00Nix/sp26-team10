<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Meal Plans</title>
    <link rel="stylesheet" href="/static/admin.css">
</head>
<body>
    <main class="page-container">
        <a href="/provider/dashboard">← Back to Dashboard</a>
        <h1>Meal Plans</h1>

        <p>
            <a class="button-link" href="/provider/mealplans/add">Add Meal Plan</a>
        </p>

        <#if mealPlans?? && (mealPlans?size > 0)>
            <div class="card-list">
                <#list mealPlans as mealPlan>
                    <div class="card">
                        <h2>${mealPlan.name!""}</h2>
                        <p><strong>Price:</strong> $${mealPlan.price!0}</p>
                        <p><strong>Diet:</strong> ${mealPlan.diet!""}</p>
                        <p><strong>Description:</strong> ${mealPlan.description!""}</p>
                        <p><strong>Premade:</strong> ${mealPlan.premade?string("Yes", "No")}</p>

                        <a class="button-link" href="/provider/mealplans/${mealPlan.planId}/edit">
                            Edit Meal Plan
                        </a>
                    </div>
                </#list>
            </div>
        <#else>
            <p>No meal plans found.</p>
        </#if>
    </main>
</body>
</html>