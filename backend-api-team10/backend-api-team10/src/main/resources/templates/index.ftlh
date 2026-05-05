<#include "layout.ftlh">
<@head title="Home" />
<@nav activePage="home" />

<main class="page-wrap">
  <section class="hero">
    <div class="hero-text">
      <div class="hero-tag">Fresh &middot; Nutritious &middot; Delivered</div>
      <h1>Eat <em>well</em>,<br>live better.</h1>
      <p>Meals designed by professionals. Fresh ingredients delivered to you.</p>
      <div class="hero-ctas">
        <button class="btn-primary"  onclick="location.href='/customer/meals'">Explore Meals</button>
        <button class="btn-outline"  onclick="location.href='/customer/subscriptions'">View Subscription Plans</button>
      </div>
      <div class="hero-stats">
        <div class="stat">
          <div class="stat-num">50+</div>
          <div class="stat-label">Monthly Meals</div>
        </div>
        <div class="stat">
          <div class="stat-num">20k</div>
          <div class="stat-label">Happy Customers</div>
        </div>
        <div class="stat">
          <div class="stat-num">${averageRating?string('0.0')}</div> 
          <div class="stat-label">Average Rating</div>
        </div>
      </div>
    </div>
    <div class="hero-visual">
      <div class="hero-plate">&#127837;</div>
      <div class="float-card"><span class="float-icon">&#9889;</span> Nutritious</div>
      <div class="float-card"><span class="float-icon">&#127807;</span> Fresh Daily</div>
      <div class="float-card"><span class="float-icon">&#128666;</span> Free Delivery</div>
    </div>
  </section>

  <section class="features">
    <h2 class="section-title">Why Balanced Bite?</h2>
    <p class="section-sub">Everything you need to live a healthier, easier life.</p>
    <div class="feature-grid">
      <div class="feature-card">
        <div class="feature-icon">&#128104;&#8205;&#127859;</div>
        <h3>Professionally Made Meals</h3>
        <p>Every meal is crafted by professionals to maximise both nutritional and flavour value.</p>
      </div>
      <div class="feature-card">
        <div class="feature-icon">&#127807;</div>
        <h3>Fresh Ingredients</h3>
        <p>Each meal is prepared with the freshest seasonal ingredients, sourced responsibly.</p>
      </div>
      <div class="feature-card">
        <div class="feature-icon">&#128230;</div>
        <h3>Deliveries</h3>
        <p>Get your meals delivered, saving you plenty of time and effort.</p>
      </div>
    </div>
  </section>
</main>

<@footer />
