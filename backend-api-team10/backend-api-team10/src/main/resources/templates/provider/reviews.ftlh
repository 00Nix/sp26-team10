<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Reviews Dashboard</title>
    <link rel="stylesheet" href="/styles/admin.css">
</head>
<body class="admin-body">
<div class="admin-layout">
    <input type="checkbox" id="sidebar-toggle" class="sidebar-toggle">

    <aside class="sidebar">
        <div class="sidebar-brand">
            <h1>BALANCED<br>BITE</h1>
            <p>Provider Admin Portal</p>
        </div>
        <nav class="sidebar-nav">
            <a class="sidebar-link" href="/provider/dashboard">Dashboard</a>
            <a class="sidebar-link" href="/provider/orders">Orders</a>
            <a class="sidebar-link active" href="/provider/reviews">Reviews</a>
            <a class="sidebar-link" href="/provider/subscriptions">Plans</a>
            <a class="sidebar-link" href="/provider/mealplans">Meal Plans</a>
            <a class="sidebar-link" href="/provider/meals">Meals</a>
            <a class="sidebar-link" href="/provider/analytics">Analytics</a>
            <a class="sidebar-link" href="/provider/profile">Profile</a>
        </nav>
        <div class="sidebar-bottom">
            <a href="/customer/index">Back to Home</a>
            <a href="/logout">Log Out</a>
        </div>
    </aside>

    <label for="sidebar-toggle" class="sidebar-overlay"></label>

    <div class="main-shell">
        <header class="topbar">
            <div class="topbar-left">
                <div>
                    <h1 class="topbar-title">Reviews</h1>
                    <p class="topbar-subtitle">Read customer feedback and respond quickly.</p>
                </div>
            </div>
            <div class="topbar-actions">
                <div class="search-bar">
                    <span>⌕</span>
                    <input type="text" placeholder="Search reviews">
                </div>

                <a class="utility-back" href="/provider/dashboard">← Back to Dashboard</a>
            </div>
        </header>

        <main class="page-content section-stack">
            <section class="reviews-top">
                <div class="stats-row">
                    <div class="stat-card">
                        <div class="stat-label">New Reviews</div>
                        <div class="stat-value">${newReviews!''}</div>
                        <div class="stat-change">Recent customer submissions</div>
                    </div>

                    <div class="stat-card">
                        <div class="stat-label">Replied</div>
                        <div class="stat-value">${repliedReviews!''}</div>
                        <div class="stat-change">Provider responses posted</div>
                    </div>

                    <div class="stat-card">
                        <div class="stat-label">Total Reviews</div>
                        <div class="stat-value">${totalReviews!''}</div>
                        <div class="stat-change">All review records</div>
                    </div>
                </div>

                <div class="rating-summary">
                    <h3>Average Rating</h3>
                    <div class="big-rating">${avgRating!}</div>
                    <div class="rating-stars"></div>
                </div>
            </section>

            <section class="panel">
                <div class="page-content">
                    <div class="search-filter-row">
                        <div class="filter-group">
                            <a class="btn btn-pill-dark" href="/provider/reviews">All</a>
                            <a class="btn btn-pill-light" href="/provider/reviews?rating=5">5</a>
                            <a class="btn btn-pill-light" href="/provider/reviews?rating=4">4</a>
                            <a class="btn btn-pill-light" href="/provider/reviews?rating=3">3</a>
                            <a class="btn btn-pill-light" href="/provider/reviews?rating=2">2</a>
                            <a class="btn btn-pill-light" href="/provider/reviews?rating=1">1</a>
                            <a class="btn btn-pill-light" href="/provider/reviews?sort=newest">Newest</a>
                            <a class="btn btn-pill-light" href="/provider/reviews?sort=oldest">Oldest</a>
                        </div>

                        <div class="filter-group">
                            <button class="btn btn-pill-light" type="button">Date Range</button>
                            <button class="btn btn-pill-light" type="button">Status</button>
                        </div>
                    </div>

                    <div class="review-list">
                        <#list reviews as review>
                            <div class="review-row">
                                <div class="review-meta">
                                    <div>${review.date!''}</div>
                                    <div class="review-customer">${review.customerName!'Customer'}</div>
                                </div>

                                <div class="review-main">
                                    <div class="review-title">${review.title!'Review Title'}</div>
                                    <div class="review-snippet">${(review.description!'No description provided.')?truncate(95)}</div>
                                </div>

                                <div class="review-stars">
                                    <#assign r = review.rating!0>
                                    <#list 1..5 as i><#if i <= r>★<#else>☆</#if></#list>
                                </div>

                                <div class="review-action">
                                    <a href="/provider/reviews/${review.reviewId}">View</a>
                                </div>

                                <div class="review-action">
                                    <a href="/provider/reviews/${review.reviewId}/reply">Reply</a>
                                </div>
                            </div>
                        </#list>
                    </div>
                </div>
            </section>
        </main>
    </div>
</div>
</body>
</html>