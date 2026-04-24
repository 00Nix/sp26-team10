<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login | Balanced Bite</title>
    <link rel="stylesheet" href="/styles/auth.css">
</head>
<body>

<div class="login-container">
    <div class="login-card">

        <h1 class="logo">Balanced Bite</h1>
        <p class="subtitle">Sign in to your account</p>

        <#-- Error Message -->
        <#if error??>
            <div class="error-message">
                Invalid username or password
            </div>
        </#if>

        <#-- Logout Message -->
        <#if logout??>
            <div class="success-message">
                You have been logged out
            </div>
        </#if>

        <form action="/login" method="post" class="login-form">

            <#if _csrf??>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
            </#if>

            <div class="form-group">
                <label for="username">Email</label>
                <input
                    type="text"
                    id="username"
                    name="username"
                    placeholder="Enter your email"
                    required
                >
            </div>

            <div class="form-group">
                <label for="password">Password</label>
                <input
                    type="password"
                    id="password"
                    name="password"
                    placeholder="Enter your password"
                    required
                >
            </div>

            <button type="submit" class="login-btn">
                Sign In
            </button>

        </form>

        <div class="footer-links">
            <p>Don't have an account? <a href="/register">Sign up</a></p>
        </div>

    </div>
</div>

</body>
</html>