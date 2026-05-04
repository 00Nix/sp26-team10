<#include "layout.ftlh">
<@head title="My Orders" />
<@nav activePage="orders" />

<main class="page-wrap">
  <h1 class="page-title">My Orders</h1>

  <div class="orders-filter">
    <#list [
      {"val":"all",       "label":"All Orders"},
      {"val":"delivered", "label":"Delivered"},
      {"val":"transit",   "label":"In Transit"},
      {"val":"preparing", "label":"Preparing"}
    ] as f>
      <a href="/customers/orders<#if f.val != 'all'>?status=${f.val}</#if>"
         class="filter-btn <#if (activeFilter!'all') == f.val>active</#if>">
        ${f.label}
      </a>
    </#list>
  </div>

  <div id="orders-list">
    <#if orders?has_content>
      <#list orders as o>
        <#assign statusLabel = "Processing">
        <#assign statusClass = "status-preparing">
        <#if (o.status?lower_case) == "delivered">
          <#assign statusLabel = "Delivered">
          <#assign statusClass = "status-delivered">
        <#elseif (o.status?lower_case)?contains("transit") || (o.status?lower_case) == "shipped">
          <#assign statusLabel = "In Transit">
          <#assign statusClass = "status-transit">
        <#elseif (o.status?lower_case) == "preparing" || (o.status?lower_case) == "pending">
          <#assign statusLabel = "Preparing">
          <#assign statusClass = "status-preparing">
        </#if>

        <div class="order-card">
          <div class="order-header">
            <span class="order-id">
              Order #${o.orderId?c}
              &middot; ${o.formattedDate}
            </span>
            <span class="order-status ${statusClass}">${statusLabel}</span>
          </div>
          <div class="order-body">
            <div class="order-items-preview">
              <div class="order-item-chip">&#127869;</div>
            </div>
            <div class="order-details">
              <h4>Order #${o.orderId?c}</h4>
              <p>${statusLabel} &middot; ${(o.address!'')}</p>
            </div>
            <#-- Order.getTotalPrice() returns Double confirmed -->
            <div class="order-total">$${(o.totalPrice!0)?string('0.00')}</div>
            <form method="post" action="/customers/orders/reorder" style="display:inline">
              <input type="hidden" name="orderId" value="${o.orderId?c}">
              <button type="submit" class="track-btn">Reorder</button>
            </form>
          </div>
        </div>
      </#list>
    <#else>
      <div class="empty-state">
        <div class="empty-icon">&#128230;</div>
        <h3>No orders found</h3>
        <p>Looks like you haven't placed any orders yet.</p>
        <a href="/customers/meals" class="btn-primary">Browse Meals</a>
      </div>
    </#if>
  </div>
</main>

<@footer />
