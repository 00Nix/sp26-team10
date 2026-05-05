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

    <div style="max-width: 600px; margin: 0 auto 40px; background: var(--card-bg); padding: 28px; border-radius: 20px; 
                border: 1px solid var(--border); box-shadow: var(--shadow);">
    <h3 style="margin-bottom: 16px; color: var(--deep); font-size: 1.1rem; font-weight: 700;">Leave a Review</h3>
    <form method="post" action="/customer/reviews/add">
      <#if _csrf??>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
      </#if>

      <div style=""margin-bottom: 16px;>
        <label style="display: block; font-size: .9rem; font-weight: 600; margin-bottom: 8px; color: var(--text);">Choose the Meal you are reviewing:</label>
        <select name="mealId" required style="width: 100%; padding: 12px 14px; border-radus: 12px; border: 1.5px solid var(--border); font-family: inherit; outline: none; background: var(--cream);">
          <option value="" disabled selected>Select a meal</option>
          <#if meals??>
            <#list meals as meal>
              <option value="${meal.mealId}">${meal.name}</option>
            </#list>
          </#if>
        </select>
      </div>

      <div style="margin-bottom: 16px;">
        <label style="display: block; font-size: .9rem; font-weight: 600; margin-bottom: 8px; color: var(--text);">Rating:</label>
        <select name="rating" required style="width: 100%; padding: 12px 14px; border-radius: 12px; 
                border: 1.5px soldi var(--border); font-family: inherit; oultine: none; background: var(--cream);">
          <option value="5">★★★★★</option> (5/5 - Excellent)</option>
          <option value="4">★★★★☆</option> (4/5 - Good)</option>
          <option value="3">★★★☆☆</option> (3/5 - Average)</option>
          <option value="2">★★☆☆☆</option> (2/5 - Poor)</option>
          <option value="1">★☆☆☆☆</option> (1/5 - Very Poor)</option>
          </select>
      </div>

      <div style="margin-bottom: 20px;">
        <label style="display: block; font-size: .9rem; font-weight: 600; margin-bottom: 8px; color: var(--text);">Your Experience</label>
        <textarea name="description" required rows="3" placeholder="tell us what you loved..." style="width: 100%; padding: 12px; 
                border: 1.5px solid var(--border); font-family: inherit; resize: vertical; outline: none; background: var(--cream);"></textarea>
      </div>

      <button type="sumbit" class="btn-primary" style="width: 100%;">Sumbit Review</button>
      </form>
      </div>

  <div class="reviews-grid">
    <#if reviews?has_content>
      <#list reviews as r>
        <div class="review-card">
          <div class="stars">
            <#list 1..5 as i>
              <#if i <= r.rating>&#9733;<#else>&#9734;</#if>
            </#list>
          </div>
          <p>&ldquo;${(r.description!'Great experience!')}&rdquo;</p>
          <div class="reviewer">
            <div class="avatar">&#128100;</div>
            <div class="reviewe-info">
              <div class="name">${(r.customer.name!'Customer')}</div>
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
