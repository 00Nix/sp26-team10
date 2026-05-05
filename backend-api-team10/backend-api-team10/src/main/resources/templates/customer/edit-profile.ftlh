<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Profile</title>
    <link rel="stylesheet" href="/styles/admin.css">
</head>
<body>
<main class="page-container">
    <a class="utility-back" href="/customer/dashboard">← Back to Dashboard</a>

    <div class="form-shell">
        <h2 class="form-title-center">Edit Profile</h2>
        <hr class="form-divider-small">

        <form action="/customer/profile/update" method="post">
            <#if _csrf??>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
            </#if>

            <div class="form-group">
                <label class="form-label" for="name">Name</label>
                <input class="form-input" type="text" id="name" name="name" value="${customer.user.name!''}" required>
            </div>

            <div class="form-group">
                <label class="form-label" for="email">Email</label>
                <input class="form-input" type="email" id="email" name="email" value="${customer.user.email!''}" required>
            </div>

            <div class="form-group">
                <label class="form-label" for="phone">Phone</label>
                <input class="form-input" type="text" id="phone" name="phone" value="${customer.phone!''}">
            </div>

            <div class="form-group">
                <label class="form-label" for="biography">Biography</label>
                <textarea class="form-textarea" id="biography" name="biography">${customer.biography!''}</textarea>
            </div>

            <button class="btn btn-cream" type="submit">Update Profile</button>
        </form>
    </div>
</main>
</body>
</html>