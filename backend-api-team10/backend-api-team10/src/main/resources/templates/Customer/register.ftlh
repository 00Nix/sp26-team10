<#include "layout.ftlh">
<@head title="Create Account" />
<@nav activePage="" />

<main class="page-wrap" style="min-height:80vh;display:flex;align-items:center;justify-content:center;padding:40px 20px">
  <div class="auth-card">

    <div class="auth-brand">
      <a class="nav-logo" href="/customers/index">Balance<span>Bite</span></a>
      <p>Create your account and start eating well</p>
    </div>

    <#if error?has_content>
      <div class="auth-alert auth-alert-error" role="alert">
        ${error}
      </div>
    </#if>

    <form method="post" action="/customers/register" class="auth-form">

      <div class="form-group">
        <label for="name">Full Name</label>
        <input type="text" id="name" name="name"
               placeholder="Jane Smith"
               value="${(prefillName!'')}"
               required autocomplete="name">
      </div>

      <div class="form-group">
        <label for="email">Email</label>
        <input type="email" id="email" name="email"
               placeholder="you@example.com"
               value="${(prefillEmail!'')}"
               required autocomplete="email">
      </div>

      <div class="form-group">
        <label for="phone">Phone <span style="font-weight:400;color:var(--muted)">(optional)</span></label>
        <input type="tel" id="phone" name="phone"
               placeholder="+1 555 000 0000"
               value="${(prefillPhone!'')}"
               autocomplete="tel">
      </div>

      <div class="form-row">
        <div class="form-group">
          <label for="password">Password</label>
          <div class="input-with-toggle">
            <input type="password" id="password" name="password"
                   placeholder="Min. 8 characters"
                   required autocomplete="new-password"
                   minlength="8">
            <button type="button" class="toggle-pw" onclick="togglePw('password')"
                    aria-label="Show password">&#128065;</button>
          </div>
        </div>
        <div class="form-group">
          <label for="confirmPassword">Confirm Password</label>
          <div class="input-with-toggle">
            <input type="password" id="confirmPassword" name="confirmPassword"
                   placeholder="Repeat password"
                   required autocomplete="new-password">
            <button type="button" class="toggle-pw" onclick="togglePw('confirmPassword')"
                    aria-label="Show password">&#128065;</button>
          </div>
        </div>
      </div>

      <#-- Password strength indicator -->
      <div class="pw-strength" id="pw-strength" style="display:none">
        <div class="pw-strength-bar">
          <div class="pw-strength-fill" id="pw-fill"></div>
        </div>
        <span class="pw-strength-label" id="pw-label"></span>
      </div>

      <button type="submit" class="btn-primary auth-submit"
              onclick="return validateForm()">Create Account</button>
    </form>

    <p class="auth-switch">
      Already have an account?
      <a href="/customers/login">Sign in &rarr;</a>
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
    max-width: 500px;
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
  .auth-form { display: flex; flex-direction: column; gap: 16px; }
  .form-row { display: grid; grid-template-columns: 1fr 1fr; gap: 14px; }
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
  .form-group input.invalid {
    border-color: #e74c3c;
    box-shadow: 0 0 0 3px rgba(231,76,60,.12);
  }
  .input-with-toggle { position: relative; }
  .input-with-toggle input { padding-right: 42px; width: 100%; }
  .toggle-pw {
    position: absolute; right: 12px; top: 50%; transform: translateY(-50%);
    background: none; border: none; cursor: pointer; font-size: 1rem;
    color: var(--muted, #7a8b7b); padding: 0; line-height: 1;
  }
  .pw-strength { display: flex; align-items: center; gap: 10px; margin-top: -4px; }
  .pw-strength-bar { flex: 1; height: 5px; background: var(--border); border-radius: 50px; overflow: hidden; }
  .pw-strength-fill { height: 100%; border-radius: 50px; transition: width .3s, background .3s; }
  .pw-strength-label { font-size: .72rem; font-weight: 600; white-space: nowrap; }
  .auth-submit {
    width: 100%;
    padding: 13px;
    margin-top: 4px;
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
  @media (max-width: 480px) {
    .auth-card { padding: 32px 24px; }
    .form-row { grid-template-columns: 1fr; }
  }
</style>

<script>
  function togglePw(id) {
    const input = document.getElementById(id);
    input.type = input.type === 'password' ? 'text' : 'password';
  }

  // Password strength meter
  document.getElementById('password').addEventListener('input', function () {
    const val = this.value;
    const bar = document.getElementById('pw-fill');
    const label = document.getElementById('pw-label');
    const wrap = document.getElementById('pw-strength');

    if (!val) { wrap.style.display = 'none'; return; }
    wrap.style.display = 'flex';

    let score = 0;
    if (val.length >= 8) score++;
    if (/[A-Z]/.test(val)) score++;
    if (/[0-9]/.test(val)) score++;
    if (/[^A-Za-z0-9]/.test(val)) score++;

    const levels = [
      { w: '20%',  bg: '#e74c3c', text: 'Weak',      color: '#e74c3c' },
      { w: '50%',  bg: '#e67e22', text: 'Fair',      color: '#e67e22' },
      { w: '75%',  bg: '#f1c40f', text: 'Good',      color: '#e6b800' },
      { w: '100%', bg: '#27ae60', text: 'Strong',    color: '#27ae60' },
    ];
    const lvl = levels[Math.min(score - 1, 3)] || levels[0];
    bar.style.width = lvl.w;
    bar.style.background = lvl.bg;
    label.textContent = lvl.text;
    label.style.color = lvl.color;
  });

  function validateForm() {
    const pw  = document.getElementById('password').value;
    const cpw = document.getElementById('confirmPassword').value;
    if (pw !== cpw) {
      document.getElementById('confirmPassword').classList.add('invalid');
      alert('Passwords do not match.');
      return false;
    }
    document.getElementById('confirmPassword').classList.remove('invalid');
    return true;
  }
</script>

<@footer />