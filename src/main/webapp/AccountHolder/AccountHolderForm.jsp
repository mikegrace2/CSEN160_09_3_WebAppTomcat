<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Account Holder Lookup</title>
<style>
  :root{ --bg:#fafafa; --card:#fff; --accent:#2b6cb0; --muted:#666 }
  body{ font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, Arial; background:var(--bg); margin:0; padding:28px; color:#222 }
  .container{ max-width:700px; margin:0 auto }
  h1{ color:var(--accent); margin:0 0 8px 0 }
  .card{ background:var(--card); padding:18px; border-radius:8px; box-shadow:0 1px 3px rgba(0,0,0,0.06) }
  label{ display:block; margin-top:12px; font-weight:600 }
  input[type="text"]{ width:100%; padding:8px 10px; border:1px solid #ddd; border-radius:6px; box-sizing:border-box }
  .hint{ font-size:0.9rem; color:var(--muted); margin-top:6px }
  .actions{ margin-top:14px }
  .btn{ background:var(--accent); color:#fff; padding:8px 12px; text-decoration:none; border-radius:6px; border:none }
  .link{ margin-left:10px; color:var(--accent); text-decoration:none }
  .note{ margin-top:10px; font-size:0.9rem; color:#b33 }
</style>
<script>
  function validateAccountForm() {
    var v = document.getElementById('accountNumber').value.trim();
    if (!v) { alert('Please enter an account number.'); return false; }
    // allow digits only for this demo
    if (!/^\d+$/.test(v)) { if (!confirm('Account number contains non-digits. Continue?')) return false; }
    return true;
  }
</script>
</head>
<body>
  <div class="container">
    <h1>Account Holder Lookup</h1>
    <div class="card">
      <div class="hint">Valid account (example): <strong>123456</strong></div>
      <div class="hint">Test injection (for learning): <code>100110' OR '1' = '1</code></div>

      <form action="<%= request.getContextPath() %>/AccountHolderServlet" method="get" onsubmit="return validateAccountForm();">
        <label for="accountNumber">Account Number</label>
        <input id="accountNumber" name="accountNumber" type="text" placeholder="Enter account number"
               value='<%= request.getParameter("accountNumber") != null ? request.getParameter("accountNumber") : "" %>' />

        <div class="actions">
          <button class="btn" type="submit">Lookup</button>
          <a class="link" href="<%= request.getContextPath() %>/AccountHolder/AccountHolderShow.jsp">Show Results</a>
          <a class="link" href="<%= request.getContextPath() %>/index.jsp">Home</a>
        </div>
      </form>

      <div class="note">Note: This demo accepts plain values. Do not use this code as-is in production without proper input validation and prepared statements.</div>
    </div>
  </div>
</body>
</html>