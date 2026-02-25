<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <style>
        body { font-family: Arial, Helvetica, sans-serif; background:#f7f7f7; margin:0; padding:40px; }
        .box { max-width:360px; margin:0 auto; background:#fff; padding:18px; border-radius:6px; box-shadow:0 2px 6px rgba(0,0,0,0.08); }
        h1 { font-size:18px; margin:0 0 8px; }
        .hint { font-size:13px; color:#666; margin-bottom:12px; }
        label { display:block; font-size:13px; margin-top:8px; color:#333; }
        input[type="text"], input[type="password"] { width:100%; padding:8px 10px; margin-top:6px; border:1px solid #ccc; border-radius:4px; }
        input[type="submit"] { margin-top:14px; width:100%; padding:10px; background:#1976d2; color:#fff; border:0; border-radius:4px; cursor:pointer; }
        input[type="submit"]:hover { background:#155fa0; }
    </style>
</head>
<body>
<div class="box">
    <h1>Sign in:</h1>
    <div class="hint">Test user: <script>alert(1)</script></div>
    <form action="<%= request.getContextPath() %>/LoginXSSServlet" method="post" onsubmit="return validateLogin();">
        <label for="login">Login</label>
        <input id="login" name="login" type="text" autocomplete="username" />
        <input type="submit" value="Sign in" />
    </form>
</div>

<script>
    function validateLogin() {
        var l = document.getElementById('login').value.trim();
        if (!l) {
            alert('Please enter both login.');
            return false;
        }
        return true;
    }
</script>
</body>
</html>
