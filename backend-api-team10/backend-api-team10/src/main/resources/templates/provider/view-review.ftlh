<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>View Review</title>
    <link rel="stylesheet" href="/styles/admin.css">
</head>
<body>
<div class="overlay-page">
    <div class="overlay-title-top">View Review Overlay</div>
    <h1 class="overlay-center-title">View Review</h1>

    <div class="overlay-card review-header-card">
        <div style="text-align:center;">
            <div style="font-style:italic; color:#666;">Date:</div>
            <div style="font-size:28px; font-style:italic; margin-top:6px;">${review.date!}</div>
        </div>

        <div style="text-align:center;">
            <div style="font-size:38px; font-weight:600;">${review.title}</div>
            <hr class="page-divider" style="width: 220px; margin: 10px auto;">
            <div>Submitted by: ${review.customerName}</div>
        </div>

        <div style="text-align:center;">
            <div style="font-size:20px; font-style:italic;">Rating:
                <span style="color:#c9b16d; font-size:28px;">
                    <#assign r = review.rating!5>
                    <#list 1..5 as i><#if i <= r>★<#else>☆</#if></#list>
                </span>
            </div>
        </div>
    </div>

    <div class="overlay-description-box">
        <div style="font-style:italic; color:#666; margin-bottom:12px;">Description:</div>
        <hr class="page-divider" style="width:80px; margin-bottom:14px;">
        <p style="font-size:20px; line-height:1.65;">
            ${review.description!}
        </p>
    </div>

    <div class="overlay-actions">
        <a href="/provider/reviews">Back to Reviews</a>
        <a href="/provider/reviews/${review.review_id}/reply">Reply</a>
    </div>
</div>
</body>
</html>