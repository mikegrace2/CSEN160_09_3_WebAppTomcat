<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <title>Authentication Successful</title>
    <meta name="viewport" content="width=device-width,initial-scale=1" />
    <style>
        :root{
            --bg1:#f0fbf5;
            --bg2:#eefbf0;
            --card:#ffffff;
            --accent:#2e7d32;
            --muted:#4b5563;
            --shadow: 0 6px 20px rgba(18,38,63,0.06);
        }
        html,body{height:100%;margin:0;font-family:Segoe UI, Roboto, "Helvetica Neue", Arial, sans-serif;background:linear-gradient(135deg,var(--bg1),var(--bg2));color:#111}
        .wrap{min-height:100%;display:flex;align-items:center;justify-content:center;padding:32px;}
        .card{background:var(--card);max-width:680px;width:100%;border-radius:12px;box-shadow:var(--shadow);padding:28px;display:flex;gap:20px;align-items:center;flex-wrap:wrap}
        .illustration{flex:0 0 96px;height:96px;display:flex;align-items:center;justify-content:center;border-radius:10px;background:linear-gradient(180deg, rgba(46,125,50,0.08), rgba(46,125,50,0.02));}
        .icon{width:64px;height:64px;transform-origin:center;animation:pop .32s ease-out}
        @keyframes pop{from{transform:scale(.8);opacity:0}to{transform:scale(1);opacity:1}}
        .content{flex:1;min-width:220px}
        h1{margin:0;font-size:18px;color:#0b3b12}
        p.lead{margin:8px 0 0;font-size:14px;color:var(--muted);line-height:1.4}
        .success-badge{display:inline-block;margin-top:12px;padding:8px 12px;background:rgba(46,125,50,0.08);color:var(--accent);border-radius:8px;font-weight:600;font-size:13px}
        .hint{margin-top:14px;font-size:13px;color:var(--muted)}
        .footer{width:100%;text-align:center;margin-top:18px;font-size:12px;color:#9aa0a6}
        @media (max-width:520px){ .card{padding:18px} .illustration{flex-basis:72px;height:72px} .icon{width:48px;height:48px} }
    </style>
</head>
<body>
<div class="wrap">
    <main class="card" role="main" aria-labelledby="auth-success-heading">
        <div class="illustration" aria-hidden="true">
            <svg class="icon" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg" aria-hidden="true">
                <circle cx="12" cy="12" r="10" fill="#fff"/>
                <path d="M7.5 12.5L10.5 15.5L16.5 9.5" stroke="#2e7d32" stroke-width="1.6" stroke-linecap="round" stroke-linejoin="round"/>
            </svg>
        </div>

        <div class="content" role="status" aria-live="polite">
            <h1 id="auth-success-heading">Authentication Successful</h1>
            <div class="success-badge">Signed in</div>
            <p class="lead">Welcome back, <strong><%= request.getParameter("login") != null ? request.getParameter("login") : "user" %></strong>.</p>
            <p class="hint">You have successfully signed in. Continue to your dashboard or the application entry point.</p>
        </div>

        <div style="flex-basis:100%;height:0"></div>

        <div class="footer">This page confirms a successful sign-in — no additional actions are provided here.</div>
    </main>
</div>
</body>
</html>