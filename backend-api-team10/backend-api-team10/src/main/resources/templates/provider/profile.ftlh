<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Provider Profile</title>
    <link rel="stylesheet" href="/styles/admin.css">
</head>
<body>
<main class="page-container">
    <a class="utility-back" href="/provider/dashboard">← Back to Dashboard</a>

    <section class="form-shell">
        <h2 class="form-title-center">Provider Profile</h2>
        <hr class="form-divider-small">

        <div class="section-stack">
            <div class="form-group">
                <label class="form-label">Name</label>
                <p class="form-input">${provider.user.name!''}</p>
            </div>

            <div class="form-group">
                <label class="form-label">Email</label>
                <p class="form-input">${provider.user.email!''}</p>
            </div>

            <div class="form-group">
                <label class="form-label">Phone</label>
                <p class="form-input">${provider.phone!''}</p>
            </div>

            <div class="form-group">
                <label class="form-label">Biography</label>
                <p class="form-textarea">${provider.biography!''}</p>
            </div>

            <a class="btn btn-cream" href="/provider/profile/edit">
                Edit Profile
            </a>
        </div>
    </section>
</main>
</body>
</html>