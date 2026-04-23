<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Reply to Review</title>
    <link rel="stylesheet" href="/static/admin.css">
</head>
<body>
<div class="overlay-page">
    <div class="overlay-title-top">Review Reply Overlay</div>
    <h1 style="text-align:center; font-size:56px; margin-bottom:28px;">Reply to Review</h1>

    <div class="overlay-card">
        <div style="display:grid; grid-template-columns: 220px 1fr; gap:24px;">
            <div style="text-align:center;">
                <div style="font-style:italic; color:#666;">${review.date!}</div>
                <div style="margin-top:18px; font-size:28px;">${review.customerName!}</div>
                <hr class="page-divider" style="margin: 8px 0;">
                <div style="font-size:28px;">${review.title!}</div>
                <div style="margin-top:18px; font-style:italic; color:#666;">
                    Rating:
                    <span style="color:#c9b16d; font-size:28px;">
                        <#assign r = review.rating!5>
                        <#list 1..5 as i><#if i <= r>★<#else>☆</#if></#list>
                    </span>
                </div>
            </div>

            <div style="font-size:19px; line-height:1.6;">
                ${review.description!}
            </div>
        </div>
    </div>

    <div class="reply-box">
        <h2 style="font-size:40px; margin: 18px 0 10px;">Response:</h2>

        <form action="/provider/reviews/${review.review_id}/reply" method="post">
            <textarea class="reply-textarea" name="message">${reply.message!''}</textarea>

            <div class="reply-submit">
                <button type="submit" class="btn btn-cream">Post Reply</button>
            </div>
        </form>
    </div>
</div>
</body>
</html>