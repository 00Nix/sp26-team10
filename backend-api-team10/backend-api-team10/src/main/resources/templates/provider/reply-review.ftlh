<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Reply to Review</title>
    <link rel="stylesheet" href="/styles/admin.css">
</head>
<body>
<div class="overlay-page">
    <div class="overlay-title-top">Review Reply</div>
    <h1 class="overlay-page-title">Reply to Review</h1>

    <div class="overlay-card">
        <div class="review-detail-grid">
            <div class="review-detail-side">
                <div class="review-detail-date">${review.date!}</div>
                <div class="review-detail-name">${review.customerName!}</div>
                <hr class="page-divider">
                <div class="review-detail-title">${review.title!}</div>
                <div class="rating-stars">
                    <#assign r = review.rating!5>
                    <#list 1..5 as i><#if i <= r>★<#else>☆</#if></#list>
                </div>
            </div>

            <div class="review-detail-body">
                ${review.description!}
            </div>
        </div>
    </div>

    <div class="reply-box">
        <h2 class="form-title-center">Response</h2>
        <hr class="form-divider-small">

        <form action="/provider/reviews/${review.reviewId}/reply" method="post">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
            <textarea class="reply-textarea" name="message">${reply.message!''}</textarea>

            <div class="reply-submit">
                <button type="submit" class="btn btn-cream">Post Reply</button>
            </div>
        </form>
    </div>
</div>
</body>
</html>