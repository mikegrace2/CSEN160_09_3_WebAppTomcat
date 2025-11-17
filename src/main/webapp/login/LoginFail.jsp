<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <title>Authentication Failed</title>
    <meta name="viewport" content="width=device-width,initial-scale=1" />
    <style>
        :root{
            --bg1:#f0f4f8;
            --bg2:#eef6ff;
            --card:#ffffff;
            --accent:#d32f2f;
            --muted:#6b7280;
            --shadow: 0 6px 20px rgba(18,38,63,0.08);
        }
        html,body{height:100%;margin:0;font-family:Segoe UI, Roboto, "Helvetica Neue", Arial, sans-serif;background:linear-gradient(135deg,var(--bg1),var(--bg2));color:#222}
        .wrap{min-height:100%;display:flex;align-items:center;justify-content:center;padding:32px;}
        .card{background:var(--card);max-width:680px;width:100%;border-radius:12px;box-shadow:var(--shadow);padding:28px 28px;display:flex;gap:20px;align-items:center;flex-wrap:wrap}
        .illustration{flex:0 0 96px;height:96px;display:flex;align-items:center;justify-content:center;border-radius:10px;background:linear-gradient(180deg, rgba(211,47,47,0.08), rgba(211,47,47,0.02));}
        .icon{width:64px;height:64px;transform-origin:center;animation:pop .32s ease-out}
        @keyframes pop{from{transform:scale(.8);opacity:0}to{transform:scale(1);opacity:1}}
        .content{flex:1;min-width:220px}
        h1{margin:0;font-size:18px;color:#111}
        p.lead{margin:8px 0 0;font-size:14px;color:var(--muted);line-height:1.4}
        .error-badge{display:inline-block;margin-top:12px;padding:8px 12px;background:rgba(211,47,47,0.06);color:var(--accent);border-radius:8px;font-weight:600;font-size:13px}
        .hint{margin-top:14px;font-size:13px;color:var(--muted)}
        .footer{width:100%;text-align:center;margin-top:18px;font-size:12px;color:#9aa0a6}
        @media (max-width:520px){ .card{padding:18px} .illustration{flex-basis:72px;height:72px} .icon{width:48px;height:48px} }
    </style>
</head>
<body>
<div class="wrap">
    <main class="card" role="main" aria-labelledby="auth-failed-heading">
        <div class="illustration" aria-hidden="true">
            <svg class="icon" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg" aria-hidden="true">
                <circle cx="12" cy="12" r="10" fill="#fff"/>
                <path d="M15.5 8.5L8.5 15.5" stroke="#d32f2f" stroke-width="1.6" stroke-linecap="round" stroke-linejoin="round"/>
                <path d="M8.5 8.5L15.5 15.5" stroke="#d32f2f" stroke-width="1.6" stroke-linecap="round" stroke-linejoin="round"/>
            </svg>
        </div>

        <div class="content" role="alert" aria-live="polite">
            <h1 id="auth-failed-heading">Authentication Failed</h1>
            <div class="error-badge">Login unsuccessful</div>
            <p class="lead">The credentials you provided were not accepted. Your account may be locked or credentials expired.</p>
            <p class="hint">If you think this is an error, contact your system administrator for help. Provide any relevant error details or timestamps.</p>
        </div>

        <div style="flex-basis:100%;height:0"></div>

        <div class="footer">This page only displays the failure notice — no retry option is provided here.</div>
    </main>
</div>
</body>
</html>