<#include "layout.ftlh">
<@head title="Meals" />
<@nav activePage="meals" />

<main class="page-wrap">
  <div class="inner-header">
    <h1 class="page-title">Menu</h1>
    <p class="page-sub">${(meals?size)!0} fresh meals &middot; Updated every month</p>
    <div class="filter-bar">
      <#-- Meal.getDiet() is the filter field (not category) -->
      <#list ["all","vegan","vegetarian","keto","gluten-free"] as f>
        <a href="/meals<#if f != 'all'>?filter=${f}</#if>"
           class="filter-btn <#if (activeFilter!'all') == f>active</#if>">
          ${f?cap_first}
        </a>
      </#list>
    </div>
  </div>

  <div class="meals-grid">
    <#if meals?has_content>
      <#list meals as m>
        <#-- favMealIds is a Set<Long> from controller; check via ?seq_contains -->
        <#assign isFav = favMealIds?seq_contains(m.mealId)>
        <div class="meal-card">
          <div class="meal-img">
            <span class="meal-emoji">&#127837;</span>
            <form method="post" action="/favorites/toggle" style="display:inline">
              <#-- Meal PK is getMealId() confirmed -->
              <input type="hidden" name="mealId"    value="${m.mealId?c}">
              <input type="hidden" name="returnUrl"
                     value="/meals<#if (activeFilter!'all') != 'all'>?filter=${activeFilter}</#if>">
              <button type="submit"
                      class="fav-btn-overlay ${isFav?then('active','')}"
                      title="Save to favorites">&#9825;</button>
            </form>
          </div>
          <div class="meal-info">
            <h3>${m.name}</h3>
            <div class="meal-meta">
              <#-- Meal has: name, price, description, imageUrl, diet, portionSize -->
              <#-- No calories field — show diet and portionSize instead -->
              <span>${(m.diet!'—')}</span>
              <span>${(m.portionSize!'—')}</span>
            </div>
            <div class="meal-footer">
              <span class="meal-price">$${m.price?string('0.00')}</span>
              <form method="post" action="/cart/add" style="display:inline">
                <input type="hidden" name="mealId" value="${m.mealId?c}">
                <input type="hidden" name="qty"    value="1">
                <button type="submit" class="add-btn">+ Add</button>
              </form>
            </div>
          </div>
        </div>
      </#list>
    <#else>
      <div class="empty-state" style="grid-column:1/-1">
        <div class="empty-icon">&#127869;</div>
        <h3>No meals found</h3>
        <p>Try a different filter or check back later.</p>
        <a href="/meals" class="btn-primary">View All Meals</a>
      </div>
    </#if>
  </div>
</main>

<@footer />
