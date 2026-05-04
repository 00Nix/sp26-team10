<#include "layout.ftlh">
<@head title="Reviews" />
<@nav activePage="reviews" />

<main class="page-wrap">
  <div class="inner-header" style="text-align:center">
    <h1 class="page-title" style="text-align:center">Customer Reviews</h1>
    <p class="page-sub">Read what our customers are saying about us</p>
  </div>

  <div class="rating-hero">
    <div class="big-rating">${(averageRating!0)?string('0.0')}</div>
    <div class="stars">
      <#assign full  = averageRating?floor>
      <#assign empty = 5 - full>
      <#list 1..full as i>&#9733;</#list>
      <#if empty gt 0><#list 1..empty as i>&#9734;</#list></#if>
    </div>
    <p style="opacity:.7;margin-top:4px">Based on ${totalReviews?string(',##0')} reviews</p>
    <div class="rating-breakdown">
      <#assign nativeRatingBars = [
        {"stars": 5, "pct": 75},
        {"stars": 4, "pct": 15},
        {"stars": 3, "pct": 5},
        {"stars": 2, "pct": 3},
        {"stars": 1, "pct": 2}
      ]>
      <#list ratingBars as bar>
        <div class="rating-bar">
          <span>${bar.stars}&#9733;</span>
          <div class="bar"><div class="bar-fill" style="width:${(bar.pct!0)?string('0')}%"></div></div>
          <span>${(bar.pct!0)?string('0')}%</span>
        </div>
      </#list>
    </div>
  </div>

  <div class="reviews-grid">
    <#if reviews?has_content>
      <#list reviews as r>
        <div class="review-card">
          <div class="stars">
            <#-- Review.getRating() returns int (primitive) confirmed -->
            <#list 1..5 as i>
              <#if i <= r.rating>&#9733;<#else>&#9734;</#if>
            </#list>
          </div>
          <#-- Review uses 'description' field confirmed from entity -->
          <p>&ldquo;${(r.description!'Great experience!')}&rdquo;</p>
          <div class="reviewer">
            <div class="avatar">&#128100;</div>
            <div class="reviewe-info">
              <#-- Review.getCustomer().getName() — Customer.getName() confirmed -->
              <div class="name">${(r.customer.name!'Customer')}</div>
              <#-- Review uses 'date' (LocalDate) confirmed -->
              <#if r.date??>
                <div class="date">${r.date?string('MMMM d, yyyy')}</div>
              </#if>
            </div>
          </div>
        </div>
      </#list>
    <#else>
      <div class="empty-state" style="grid-column:1/-1">
        <div class="empty-icon">&#128172;</div>
        <h3>No reviews yet</h3>
        <p>Be the first to leave a review!</p>
      </div>
    </#if>
  </div>
</main>

<@footer />
