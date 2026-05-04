<#include "layout.ftlh">
<@head title="Cart" />
<@nav activePage="cart" />

<main class="page-wrap">
  <div class="cart-layout">
    <div>
      <h1 class="page-title">Your Cart</h1>
      <#if cartItems?has_content>
        <#list cartItems as item>
          <div class="cart-item">
            <div class="cart-item-img">&#127869;</div>
            <div class="cart-item-info">
              <#-- CartItem.getMeal().getName() confirmed -->
              <h4>${(item.meal.name)!'Meal'}</h4>
              <#-- CartItem has no price — price comes from item.meal.price (BigDecimal) -->
              <p>$${(item.meal.price!0)?string('0.00')} each</p>
            </div>
            <div class="qty-control">
              <form method="post" action="/carts/update" style="display:inline">
                <#-- CartItem PK is 'itemId' confirmed -->
                <input type="hidden" name="itemId" value="${item.itemId?c}">
                <input type="hidden" name="delta"  value="-1">
                <button type="submit" class="qty-btn" aria-label="Decrease">&#8722;</button>
              </form>
              <#-- CartItem.getQuantity() returns int (primitive) -->
              <span class="qty">${item.quantity?c}</span>
              <form method="post" action="/carts/update" style="display:inline">
                <input type="hidden" name="itemId" value="${item.itemId?c}">
                <input type="hidden" name="delta"  value="1">
                <button type="submit" class="qty-btn" aria-label="Increase">+</button>
              </form>
            </div>
            <div class="cart-item-price">
              $${((item.meal.price!0)?number * item.quantity?number)?string('0.00')}
            </div>
          </div>
        </#list>
      <#else>
        <div class="empty-state">
          <div class="empty-icon">&#128722;</div>
          <h3>Your cart is empty</h3>
          <p>Add a meal to get started</p>
          <a href="/meals" class="btn-primary">Browse Meals</a>
        </div>
      </#if>
    </div>

    <div class="cart-summary">
      <h3>Order Summary</h3>
      <div class="summary-row"><span>Subtotal</span><span>$${subtotal?string('0.00')}</span></div>
      <div class="summary-row"><span>Delivery</span><span style="color:var(--sage)">Free</span></div>
      <div class="summary-row">
        <span>Discount</span>
        <span <#if ((discount!0) > 0)>style="color:var(--sage)"</#if>>
          <#if (discount > 0)>-$${discount?string('0.00')}<#else>-</#if>
        </span>
      </div>
      <div class="summary-row total">
        <span>Total</span><span>$${total?string('0.00')}</span>
      </div>

      <form method="post" action="/orders/checkout">
        <button type="submit" class="checkout-btn" <#if !cartItems?has_content>disabled</#if>>
          Checkout
        </button>
      </form>        

      <form method="post" action="/carts/promo" class="promo-row">
        <input type="text" name="promoCode" placeholder="Promo code"
               value="${(promoCodeInput!'')}">
        <button type="submit" class="promo-apply">Apply</button>
      </form>

      <#if promoMessage?has_content>
        <p class="promo-msg ${(promoError!false)?then('promo-error','promo-success')}"
           role="alert">${promoMessage}</p>
      </#if>
    </div>
  </div>
</main>

<@footer />
