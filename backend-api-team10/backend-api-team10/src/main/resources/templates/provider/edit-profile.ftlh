<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Profile</title>
    <link rel="stylesheet" href="/static/style.css">
</head>
<body>
    <main class="page-container">
        <a href="/provider/dashboard">← Back to Dashboard</a>
        <h1>Edit Profile</h1>

        <form action="/provider/profile/${provider.provider_id}/update" method="post" class="form-card">
            <label for="name">Name</label>
            <input type="text" id="name" name="name" value="${provider.name!''}" required>

            <label for="email">Email</label>
            <input type="email" id="email" name="email" value="${provider.email!''}" required>

            <label for="phone">Phone</label>
            <input type="text" id="phone" name="phone" value="${provider.phone!''}">

            <label for="biography">Biography</label>
            <textarea id="biography" name="biography" rows="5">${provider.biography!''}</textarea>

            <button type="submit">Update Profile</button>
        </form>
    </main>
</body>
</html>