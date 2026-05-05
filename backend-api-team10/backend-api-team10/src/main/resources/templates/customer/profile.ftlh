<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Profile</title>
    <link rel="stylesheet" href="/styles/admin.css">
</head>
<body>
<main class="page-container">
    <a class="utility-back" href="/customer/index">← Back to Dashboard</a>

    <section class="form-shell">
        <h2 class="form-title-center">
            Customer Profile
            <#if (customer.suscribed)!false>
                <span style="background: #FFD700; color: #000; padding: 4px 12px; border-radius: 20px; font-size: 0.8rem; margin-left: 10px; vertical-align: middle; font-weight: bold;">
                    PREMIUM MEMBER
                </span>    
            </#if>
        
        </h2>
        <hr class="form-divider-small">

        <div class="section-stack">
            <div class="form-group">
                <label class="form-label">Name</label>
                <p class="form-input">${customer.name!''}</p>
            </div>

            <div class="form-group">
                <label class="form-label">Email</label>
                <p class="form-input">${customer.email!''}</p>
            </div>

            <div class="form-group">
                <label class="form-label">Phone</label>
                <p class="form-input">${customer.phone!''}</p>
            </div>
            <div class="form-group" style="background: #f9f9f9; padding: 15px; border-radius: 8px; border: 1px solid #eee;">
                <label class="form-label" style="color: var(--deep); font-weight: bold;">Subscription Plan</label>
                <#if (customer.subscribed)!false && subscription??>
                    <p style="margin: 5px 0;"><strong>Plan:</strong> ${subscription.subscriptionPlan.name}</p>
                    <p style="margin: 5px 0;"><strong>Status:</strong> <span style="color: green; font-weight: bold;">${subscription.status}</span></p>
                    <p style="margin: 5px 0;"><strong>Renewal Date:</strong> ${subscription.endDate?string('MMMM dd, yyyy')}</p>
                <#else>
                    <p style="margin: 5px 0; color: #666;">You currently have no active subscription.</p>
                    <a href="/customer/subscriptions" style="color: var(--deep); text-decoration: underline; font-size: 0.9rem;">View Plans</a>
                </#if>
            </div>

            <div class="form-group">
                <label class="form-label">Biography</label>
                <p class="form-textarea">${customer.biography!''}</p>
            </div>

            <a class="btn btn-cream" href="/customer/profile/edit">
                Edit Profile
            </a>
        </div>
    </section>
</main>
</body>
</html>