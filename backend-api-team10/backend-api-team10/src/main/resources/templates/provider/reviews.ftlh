<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Reviews Dashboard</title>
    <link rel="stylesheet" href="/static/admin.css">
</head>
<body>
<div class="admin-layout">
    <aside class="sidebar">
        <div class="sidebar-brand">
            <h1>BALANCED<br>BITE</h1>
            <p>Admin Portal</p>
        </div>
        <nav class="sidebar-nav">
            <a href="/provider/dashboard">DASHBOARD</a>
            <a href="/provider/orders">ORDERS</a>
            <a href="/provider/reviews" class="active">REVIEWS</a>
            <a href="/provider/plans">PLANS</a>
            <a href="/provider/analytics">ANALYTICS</a>
            <a href="/provider/profile">PROFILE</a>
        </nav>
        <div class="sidebar-bottom">
            <a href="/">BACK TO HOME</a>
            <a href="/logout">LOG OUT</a>
        </div>
    </aside>

    <main class="main-content">
        <div class="page-header">
            <h1 class="page-title">Reviews Dashboard</h1>
            <hr class="page-divider">
        </div>

        <div class="reviews-top">
            <div>
                <div class="stats-row" style="grid-template-columns: repeat(3, 1fr); margin-top:0;">
                    <div class="stat-card">
                        <div class="stat-label">New Reviews</div>
                        <div class="stat-value">${newReviews!8}</div>
                        <div class="stat-change">+20% month over month</div>
                    </div>

                    <div class="stat-card">
                        <div class="stat-label">Replied</div>
                        <div class="stat-value">${repliedReviews!28}</div>
                        <div class="stat-change">+33% month over month</div>
                    </div>

                    <div class="stat-card">
                        <div class="stat-label">Total Reviews</div>
                        <div class="stat-value">${totalReviews!36}</div>
                        <div class="stat-change">-8% month over month</div>
                    </div>
                </div>
            </div>

            <div class="rating-summary">
                <h3>Average Rating</h3>
                <hr class="page-divider" style="margin: 10px auto; width: 70%;">
                <div class="big-rating">${avgRating!'4 stars'}</div>
                <hr class="page-divider" style="margin: 10px auto; width: 55%;">
                <div style="font-size: 44px; color: #ccb57c;">★★★★☆</div>
            </div>
        </div>

        <div class="search-filter-row">
            <div class="search-box">
                <span style="font-size: 26px; color:#888;">⌕</span>
                <input type="text" placeholder="Search">
            </div>

            <div class="filter-group">
                <button class="btn btn-pill-dark">All</button>
                <button class="btn btn-pill-light">5</button>
                <button class="btn btn-pill-light">4</button>
                <button class="btn btn-pill-light">3</button>
                <button class="btn btn-pill-light">2</button>
                <button class="btn btn-pill-light">1</button>
                <button class="btn btn-pill-light">None</button>
            </div>

            <div class="filter-group">
                <button class="btn btn-pill-dark">Date Range</button>
                <button class="btn btn-pill-light">Status</button>
            </div>
        </div>

        <div class="review-list">
            <#list reviews as review>
                <div class="review-row">
                    <div class="review-meta">
                        <div>${review.date!}</div>
                        <div style="font-weight:600; margin-top:4px;">${review.customerName!'User'}</div>
                    </div>

                    <div class="review-main">
                        <div class="review-title">${review.title!'Review Title'}</div>
                        <div class="review-snippet">
                            ${(review.description!'Description...')?truncate(95)}
                        </div>
                    </div>

                    <div class="review-stars">
                        <#assign r = review.rating!0>
                        <#list 1..5 as i>
                            <#if i <= r>★<#else>☆</#if>
                        </#list>
                    </div>

                    <div class="review-action">
                        <a href="/provider/reviews/${review.review_id}">VIEW</a>
                    </div>

                    <div class="review-action">
                        <a href="/provider/reviews/${review.review_id}/reply">REPLY</a>
                    </div>
                </div>
            </#list>
        </div>
    </main>
</div>
</body>
</html>