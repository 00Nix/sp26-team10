<#include "layout.ftlh">
<@head title="Meals" />
<@nav activePage="meals" />

<main class="page-wrap">
  <div class="inner-header">
    <h1 class="page-title">Menu</h1>
    <p class="page-sub">${(meals?size)!0} fresh meals &middot; Updated every month</p>
    <div class="filter-bar">
      <#list ["all","vegan","vegetarian","keto","gluten-free"] as f>
        <a href="/customer/meals<#if f != 'all'>?filter=${f}</#if>"
           class="filter-btn <#if (activeFilter!'all') == f>active</#if>">
          ${f?cap_first}
        </a>
      </#list>
    </div>
  </div>

  <div class="meals-grid">
    <#if meals?has_content>
      <#list meals as m>
        <#assign isFav = (favMealIds![])?seq_contains(m.mealId)>
        <div class="meal-card">
          <div class="meal-img">
            <span class="meal-emoji">&#127837;</span>
            <form method="post" action="/customer/favorites/toggle" style="display:inline">
              <input type="hidden" name="${(_csrf.parameterName)!'_csrf'}" value="${(_csrf.token)!''}">
              <input type="hidden" name="mealId" value="${m.mealId?c}">
              <input type="hidden" name="returnUrl"
                     value="/customer/meals<#if (activeFilter!'all') != 'all'>?filter=${activeFilter}</#if>">
              <button type="submit"
                      class="fav-btn-overlay ${isFav?then('active','')}"
                      title="Save to favorites">&#9825;</button>
            </form>
          </div>
          <div class="meal-info">
            <h3>${m.name}</h3>
            <div class="meal-meta">
              <span>${(m.diet!'—')}</span>
              <span>${(m.portionSize!'—')}</span>
            </div>
            <div class="meal-footer">
              <span class="meal-price">$${m.price?string('0.00')}</span>
              <form method="post" action="/customer/carts/add" style="display:inline">
                <input type="hidden" name="${(_csrf.parameterName)!'_csrf'}" value="${(_csrf.token)!''}">
                <input type="hidden" name="mealId" value="${m.mealId?c}">
                <input type="hidden" name="qty" value="1">
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
        <a href="/customer/meals" class="btn-primary">View All Meals</a>
      </div>
    </#if> </div> <br><br>

  <div class="inner-header" style="margin-top: 2rem;">
    <h2 class="page-title">Premade Meal Plans</h2>
    <p class="page-sub">Curated bundles for your convenience</p>
  </div>

  <div class="meals-grid">
    <#if premadePlans?? && premadePlans?size &gt; 0>
      <#list premadePlans as plan>
        <div class="meal-card">
          <div class="meal-img">
            <span class="meal-emoji">&#127857;</span> 
          </div>
          <div class="meal-info">
            <h3>${plan.name!''}</h3>
            <div class="meal-meta">
              <span>${(plan.diet!'—')}</span>
              <span>Bundle</span>
            </div>
            <p style="font-size: 0.9rem; color: #666; margin: 10px 0;">${plan.description!''}</p>
            
            <div class="meal-footer">
              <#if plan.price??>
                <span class="meal-price">$${plan.price?string('0.00')}</span>
              <#else>
                <span class="meal-price">$0.00</span>
              </#if>
              
              <form method="post" action="/customer/carts/addPlan" style="display:inline">
                <input type="hidden" name="${(_csrf.parameterName)!'_csrf'}" value="${(_csrf.token)!''}">
                <input type="hidden" name="planId" value="${plan.mealPlanId?c}">
                <input type="hidden" name="qty" value="1">
                <button type="submit" class="add-btn">+ Add</button>
              </form>
            </div>
          </div>
        </div>
      </#list>
    <#else>
      <div class="empty-state" style="grid-column:1/-1">
        <p>No premade plans available right now!</p>
      </div>
    </#if>
  </div>

</main>

<@footer/>