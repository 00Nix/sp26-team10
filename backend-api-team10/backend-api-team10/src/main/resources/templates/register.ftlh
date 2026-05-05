<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create Account | Balanced Bite</title>
    <link rel="stylesheet" href="/styles/auth.css">
</head>
<body>
<div class="auth-page">
    <div class="auth-card">
        <div class="brand-section">
            <h1>Balanced Bite</h1>
            <p>Create your account and start managing meals your way.</p>
        </div>

        <form action="/register" method="post" class="auth-form">

            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

            <h2>Create Account</h2>

            <label for="name">Full Name</label>
            <input type="text" id="name" name="name" required>

            <label for="email">Email Address</label>
            <input type="email" id="email" name="email" required>

            <label for="password">Password</label>
            <input type="password" id="password" name="password" required>

            <label for="phone">Phone Number</label>
            <input type="text" id="phone" name="phone">

            <label for="role">Account Type</label>
            <select id="role" name="role" required>
                <option value="">Select your role</option>
                <option value="CUSTOMER">Customer</option>
                <option value="PROVIDER">Provider</option>
            </select>

            <button type="submit">Create Account</button>

            <p class="auth-link">
                Already have an account?
                <a href="/login">Sign in</a>
            </p>
        </form>
    </div>
</div>
</body>
</html>