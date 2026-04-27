<#include "layout.ftlh">
<@head title="Sign In" />
<@nav activePage="" />

<main class="page-wrap" style="min-height:80vh;display:flex;align-items:center;justify-content:center">
  <div class="auth-card">

    <div class="auth-brand">
      <a class="nav-logo" href="/index">Balance<span>Bite</span></a>
      <p>Welcome back — sign in to continue</p>
    </div>

    <#-- Error message from controller -->
    <#if error?has_content>
      <div class="auth-alert auth-alert-error" role="alert">
        ${error}
      </div>
    </#if>

    <#-- Success message e.g. after registration -->
    <#if success?has_content>
      <div class="auth-alert auth-alert-success" role="alert">
        ${success}
      </div>
    </#if>

    <form method="post" action="/login" class="auth-form">
      <div class="form-group">
        <label for="email">Email</label>
        <input type="email" id="email" name="email"
               placeholder="you@example.com"
               value="${(prefillEmail!'')}"
               required autocomplete="email">
      </div>

      <div class="form-group">
        <label for="password">Password</label>
        <div class="input-with-toggle">
          <input type="password" id="password" name="password"
                 placeholder="Enter your password"
                 required autocomplete="current-password">
          <button type="button" class="toggle-pw" onclick="togglePw('password')"
                  aria-label="Show password">&#128065;</button>
        </div>
      </div>

      <button type="submit" class="btn-primary auth-submit">Sign In</button>
    </form>

    <p class="auth-switch">
      Don&rsquo;t have an account?
      <a href="/register">Create one &rarr;</a>
    </p>
  </div>
</main>

<style>
  .auth-card {
    background: var(--card-bg, #fff);
    border: 1px solid var(--border, rgba(122,158,126,.3));
    border-radius: 24px;
    padding: 48px 44px;
    width: 100%;
    max-width: 440px;
    box-shadow: 0 8px 40px rgba(30,45,31,.08);
  }
  .auth-brand { text-align: center; margin-bottom: 32px; }
  .auth-brand p { font-size: .85rem; color: var(--muted, #7a8b7b); margin-top: 6px; }
  .auth-alert {
    border-radius: 12px;
    padding: 12px 16px;
    font-size: .82rem;
    font-weight: 500;
    margin-bottom: 20px;
  }
  .auth-alert-error   { background: #fdecea; color: #c0392b; border: 1px solid #f5c6cb; }
  .auth-alert-success { background: #eafaf1; color: #1e8449; border: 1px solid #a9dfbf; }
  .auth-form { display: flex; flex-direction: column; gap: 18px; }
  .form-group { display: flex; flex-direction: column; gap: 6px; }
  .form-group label { font-size: .8rem; font-weight: 600; color: var(--deep, #1e2d1f); }
  .form-group input {
    padding: 11px 14px;
    border: 1.5px solid var(--border, rgba(122,158,126,.3));
    border-radius: 12px;
    font-size: .875rem;
    font-family: 'DM Sans', sans-serif;
    background: var(--cream, #faf6ef);
    color: var(--deep, #1e2d1f);
    transition: border-color .2s;
    width: 100%;
  }
  .form-group input:focus {
    outline: none;
    border-color: var(--sage, #7a9e7e);
    box-shadow: 0 0 0 3px rgba(122,158,126,.15);
  }
  .input-with-toggle { position: relative; }
  .input-with-toggle input { padding-right: 42px; width: 100%; }
  .toggle-pw {
    position: absolute; right: 12px; top: 50%; transform: translateY(-50%);
    background: none; border: none; cursor: pointer; font-size: 1rem;
    color: var(--muted, #7a8b7b); padding: 0; line-height: 1;
  }
  .auth-submit {
    width: 100%;
    padding: 13px;
    margin-top: 6px;
    font-size: .9rem;
    border-radius: 50px;
  }
  .auth-switch {
    text-align: center;
    font-size: .8rem;
    color: var(--muted, #7a8b7b);
    margin-top: 22px;
  }
  .auth-switch a { color: var(--sage, #7a9e7e); font-weight: 600; text-decoration: none; }
  .auth-switch a:hover { text-decoration: underline; }
</style>

<script>
  function togglePw(id) {
    const input = document.getElementById(id);
    input.type = input.type === 'password' ? 'text' : 'password';
  }
</script>

<@footer />
