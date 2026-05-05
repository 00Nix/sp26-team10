<#include "layout.ftlh">
<@head title="Subscription Plans" />
<@nav activePage="subscriptions" />

<main class="page-wrap">
  <div class="inner-header" style="text-align:center">
    <h1 class="page-title" style="text-align:center">Choose Your Plan</h1>
    <p class="page-sub">Flexible subscriptions with the best prices for you</p>
  </div>

  <#if currentSubscription??>
    <div style="max-width:700px;margin:0 auto 24px;background:var(--light-sage);border-radius:14px;padding:14px 20px;display:flex;align-items:center;justify-content:space-between">
      <div>
        <span style="font-size:.78rem;font-weight:600;color:var(--sage)">CURRENT PLAN</span>
        <#-- CustomerSubscription.getSubscriptionPlan().getName() confirmed -->
        <p style="font-weight:600;margin-top:2px">
          ${(currentSubscription.subscriptionPlan.name!'Active Plan')}
          &mdash; $${(currentSubscription.subscriptionPlan.price!0)?string('0.00')}/month
        </p>
      </div>
      <form method="post" action="/customer/subscriptions/cancel">
        <input type="hidden" name="${(_csrf.parameterName)!'_csrf'}" value="${(_csrf.token)!''}">
        <input type="hidden" name="subscriptionId" value="${currentSubscription.customerSubId?c}">
        <button type="submit" class="btn-outline"
                style="font-size:.78rem;padding:6px 14px">Cancel Plan</button>
      </form>
    </div>
  </#if>

  <div class="plans-grid">
    <#if plans?has_content>
      <#list plans as plan>
        <#assign featured = (plan?index == (plans?size / 2)?floor)>
        <#-- CustomerSubscription.getSubscriptionPlan().getPlanId() for comparison -->
        <#assign isCurrent = (currentSubscription?? &&
          currentSubscription.subscriptionPlan?? &&
          currentSubscription.subscriptionPlan.planId == plan.planId)>

        <div class="plan-card${featured?then(' featured', '')}">
          <#if featured><div class="plan-tag">Most Popular</div></#if>

          <div class="plan-name">${plan.name}</div>
          <#-- SubscriptionPlan.getPrice() returns BigDecimal confirmed -->
          <div class="plan-price" ${featured?then('style="color:#fff"','')}>
            $${plan.price?string('##0')}
            <span style="font-size:1rem;font-weight:400">/month</span>
          </div>
          <#-- SubscriptionPlan.getDurationWeeks() confirmed — use as period indicator -->
          <div class="plan-period">${(plan.durationWeeks!4)?c} weeks</div>

          <ul class="plan-features">
            <#-- SubscriptionPlan.getFeatures() returns a single String confirmed -->
            <#if plan.features?has_content>
              <#list plan.features?split(",") as feature>
                <li>${feature?trim}</li>
              </#list>
            <#else>
              <li>Access to full menu</li>
              <li>Free delivery</li>
              <li>Nutrition tracking</li>
            </#if>
          </ul>

          <#if isCurrent>
            <button class="plan-btn ${featured?then('','light')}"
                    disabled style="opacity:.6;cursor:default">Current Plan</button>
          <#else>
            <form method="post" action="/customer/subscriptions/select">
              <input type="hidden" name="${(_csrf.parameterName)!'_csrf'}" value="${(_csrf.token)!''}">
              <input type="hidden" name="planName" value="${plan.name}">
              <button type="submit"
                      class="plan-btn ${featured?then('','light')}">Get Started</button>
            </form>
          </#if>
        </div>
      </#list>
    <#else>
      <div class="empty-state" style="grid-column:1/-1">
        <div class="empty-icon">&#128203;</div>
        <h3>No plans available</h3>
        <p>Please check back later.</p>
      </div>
    </#if>
  </div>
</main>

<@footer />
