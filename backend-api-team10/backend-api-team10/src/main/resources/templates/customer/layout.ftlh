<#macro head title="Balanced Bite">
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>${title} - Balanced Bite</title>
  <link href="https://fonts.googleapis.com/css2?family=Playfair+Display:ital,wght@0,400;0,700;1,400&family=DM+Sans:wght@300;400;500;600&display=swap" rel="stylesheet">
  <link rel="stylesheet" href="/styles/styles.css">
</head>
<body>
</#macro>

<#macro nav activePage="">
<nav id="main-nav">
  <a class="nav-logo" href="/customer/index">Balanced<span>Bite</span></a>
  <ul class="nav-links">
    <li><a href="/customer/meals"        class="${(activePage == 'meals')?then('active', '')}">Meals</a></li>
    <li><a href="/customer/subscriptions" class="${(activePage == 'subscription')?then('active', '')}">Plans</a></li>
    <li><a href="/customer/orders"       class="${(activePage == 'orders')?then('active', '')}">My Orders</a></li>
    <li><a href="/customer/reviews"      class="${(activePage == 'reviews')?then('active', '')}">Reviews</a></li>
    <li><a href="/customer/profile"      class="${(activePage == 'profile')?then('active', '')}">Profile</a></li>
  </ul>
  <div class="nav-right">
  <#if customerId??>
    <a href="/customer/carts" class="nav-cart ${(activePage == 'cart')?then('active', '')}">
      &#128722; <span class="cart-badge">${cartCount!0}</span>
    </a>

    <form action="/logout" method="post" style="display: inline; margin: 0; padding: 0;">
      <input type="hidden" name="${(_csrf.parameterName)!'_csrf'}" value="${(_csrf.token)!''}">
      <button type="submit" class="nav-logout" style="background: transparent; cursor: pointer; font-family: inherit;">Logout</button>
    </form>

    <#else>
    <a href="/login" class="nav-login">Sign In</a>
    <a href="/register" class="nav-register">Join Now</a>
  </#if>
  </div>
</nav>
<style>
  .nav-customer { font-size:.78rem; font-weight:600; color:var(--sage); }
  .nav-logout, .nav-login, .nav-register {
    font-size:.78rem; font-weight:600; text-decoration:none;
    padding:6px 14px; border-radius:50px; transition:all .2s;
  }
  .nav-logout  { color:var(--muted); border:1.5px solid var(--border); }
  .nav-login   { color:var(--deep);  border:1.5px solid var(--border); }
  .nav-register { background:var(--sage); color:#fff; border:1.5px solid var(--sage); }
  .nav-logout:hover, .nav-login:hover { border-color:var(--sage); color:var(--sage); }
  .nav-register:hover { background:var(--deep); border-color:var(--deep); }
</style>
</#macro>

<#macro footer>
<footer>
  <div class="footer-grid">
    <div class="footer-brand">
      <a class="nav-logo" href="/index">Balanced<span style="color:var(--sage)">Bite</span></a>
      <p>Balanced meals, thoughtfully prepared and delivered to you.</p>
    </div>
    <div><h4>Explore</h4><ul>
      <li><a href="/customer/meals">All Meals</a></li>
      <li><a href="/customer/subscriptions">Plans</a></li>
      <li><a href="/customer/carts">Cart</a></li>
    </ul></div>
    <div><h4>Account</h4><ul>
      <li><a href="/customer/orders">My Orders</a></li>
      <li><a href="/customer/reviews">Reviews</a></li>
    </ul></div>
    <div><h4>Company</h4><ul>
      <li><a href="#">About Us</a></li>
      <li><a href="#">Contact</a></li>
    </ul></div>
  </div>
  <div class="footer-bottom">
    <span>&copy; ${.now?string('yyyy')} Balanced Bite. All rights reserved.</span>
    <span>Privacy &middot; Terms &middot; Accessibility</span>
  </div>
</footer>
<div class="toast" id="_toast"></div>
<script>
  function showToast(msg) {
    const t = document.getElementById('_toast');
    t.textContent = msg;
    t.classList.add('show');
    setTimeout(() => t.classList.remove('show'), 2800);
  }
  window.addEventListener('scroll', () => {
    document.getElementById('main-nav').classList.toggle('scrolled', window.scrollY > 10);
  });
</script>
</body>
</html>
</#macro>
