<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>View Review</title>
    <link rel="stylesheet" href="/styles/admin.css">
</head>
<body>
<div class="overlay-page">
    <h1 class="overlay-center-title">View Review</h1>

    <div class="overlay-card review-header-card">
        <div style="text-align:center;">
            <div style="font-style:italic; color:#666;">Date:</div>
            <div style="font-size:28px; font-style:italic; margin-top:6px;">${review.date!}</div>
        </div>

        <div style="text-align:center;">
            <div style="font-size:38px; font-weight:600;">${review.meal.name!'Review'}</div>
            <hr class="page-divider" style="width: 220px; margin: 10px auto;">
            <div>Submitted by: ${review.customer.user.name!''}</div>
        </div>

        <div style="text-align:center;">
            <div style="font-size:20px; font-style:italic;">Rating:
                <span style="color:#c9b16d; font-size:28px;">
                    <#assign r = review.rating!>
                    <p>
                        <#list 1..5 as i>
                            <#if i <= r>★
                            <#else>☆
                            </#if>
                        </#list> 
                    </p>
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

    <section class="review-reply-section">
        <h3>Provider Reply</h3>

        <#if replies?? && replies?size gt 0>
            <#list replies as reply>
                <div class="reply-card">
                    <p class="reply-message">${reply.message!'No reply message provided.'}</p>
                    <p class="reply-date">
                        Replied on: ${reply.replyDate!reply.reply_date!'Unknown date'}
                    </p>
                </div>
            </#list>
        <#else>
            <p class="muted-text">No provider reply has been posted yet.</p>
            <a href="/provider/reviews/${review.reviewId}/reply" class="btn btn-primary">Reply to Review</a>
        </#if>
    </section>

    <div class="overlay-actions">
        <a href="/provider/reviews">Back to Reviews</a>
        <a href="/provider/reviews/${review.reviewId}/reply">Reply</a>
    </div>
</div>
</body>
</html>