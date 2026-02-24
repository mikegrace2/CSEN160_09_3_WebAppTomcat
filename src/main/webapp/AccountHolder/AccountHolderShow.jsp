<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Account Holders</title>
<style>
    :root{ --bg:#fafafa; --card:#fff; --muted:#666; --accent:#2b6cb0; }
    body{ font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, "Helvetica Neue", Arial; background:var(--bg); margin:0; padding:24px; color:#222 }
    .container{ max-width:980px; margin:0 auto; }
    h1{ margin:0 0 12px 0; font-size:1.6rem; color:var(--accent) }
    .card{ background:var(--card); padding:18px; border-radius:8px; box-shadow:0 1px 3px rgba(0,0,0,0.06); }
    table{ width:100%; border-collapse:collapse; margin-top:12px }
    th, td{ padding:10px 12px; text-align:left; border-bottom:1px solid #eee }
    th{ background:#f3f6fb; color:#111; font-weight:600; }
    tr:nth-child(even) td{ background:#fbfdff }
    .empty{ padding:24px; text-align:center; color:var(--muted) }
    .meta{ font-size:0.9rem; color:var(--muted); margin-top:8px }
    .actions{ margin-top:14px }
    .btn{ display:inline-block; padding:8px 12px; border-radius:6px; text-decoration:none; background:var(--accent); color:#fff }
    .link{ color:var(--accent); text-decoration:none }
    @media (max-width:600px){ th, td{ padding:8px } h1{ font-size:1.25rem } }
</style>
</head>
<body>
<div class="container">
  <h1>Account Holders</h1>
  <div class="card">
    <div class="meta">This view shows the account records retrieved by the servlet.</div>

    <%
      String[][] myJSPArray = (String[][]) session.getAttribute("myArr");
    %>

    <% if (myJSPArray == null || myJSPArray.length == 0) { %>
      <div class="empty">
        <strong>No account data available.</strong>
        <div style="margin-top:8px;">Run the <a class="link" href="<%= request.getContextPath() %>/AccountHolder/AccountHolderForm.jsp">Account Holder form</a> to add test data.</div>
      </div>
    <% } else { %>
      <div style="overflow-x:auto">
        <table aria-describedby="acct-desc">
          <thead>
            <tr>
              <th scope="col">Account Number</th>
              <th scope="col">Holder Name</th>
              <th scope="col">Balance</th>
              <th scope="col">Account Type</th>
            </tr>
          </thead>
          <tbody>
            <%
              for (int i = 0; i < myJSPArray.length; i++) {
                if (myJSPArray[i] == null || myJSPArray[i].length < 4) continue;
                if (myJSPArray[i][0] == null) continue;
            %>
            <tr>
              <td><%= myJSPArray[i][0] %></td>
              <td><%= myJSPArray[i][1] %></td>
              <td><%= myJSPArray[i][2] %></td>
              <td><%= myJSPArray[i][3] %></td>
            </tr>
            <% } %>
          </tbody>
        </table>
      </div>
    <% } %>

    <div class="actions">
      <a class="btn" href="<%= request.getContextPath() %>/AccountHolder/AccountHolderForm.jsp">Add / Query</a>
      <span style="margin-left:12px"><a class="link" href="<%= request.getContextPath() %>/index.jsp">Home</a></span>
    </div>
  </div>
</div>
</body>
</html>