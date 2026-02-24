<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%-- index.jsp --%>
<%
    String serverTime = new java.util.Date().toString();
    boolean comparison = 75 < 6;
    String upper = new String("Hello World").toUpperCase();
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Fancy JSP Home</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style>
        :root{
            --bg:#0f1724; --card:#0b1220; --accent:#7c3aed; --muted:#94a3b8; --glass: rgba(255,255,255,0.03);
        }
        *{box-sizing:border-box}
        body{
            margin:0; font-family:Inter,Segoe UI,Helvetica,Arial,sans-serif;
            background: linear-gradient(180deg,var(--bg),#071028 80%);
            color:#e6eef8; -webkit-font-smoothing:antialiased;
        }
        .wrap{max-width:1000px;margin:40px auto;padding:24px;}
        header{
            display:flex;align-items:center;gap:16px;margin-bottom:18px;
        }
        .logo{
            width:64px;height:64px;border-radius:12px;
            background:linear-gradient(135deg,#0ea5e9,#7c3aed);display:flex;
            align-items:center;justify-content:center;font-weight:700;color:white;
            font-size:20px;box-shadow:0 6px 18px rgba(0,0,0,0.45);
        }
        h1{margin:0;font-size:1.6rem}
        p.lead{margin:2px 0 0;color:var(--muted)}
        .grid{
            display:grid;grid-template-columns:1fr 320px;gap:18px;margin-top:20px;
        }
        .card{
            background:linear-gradient(180deg,var(--card), rgba(255,255,255,0.02));
            border-radius:12px;padding:18px;box-shadow:0 6px 18px rgba(2,6,23,0.6);
        }
        .meta{font-size:0.95rem;color:var(--muted);margin-bottom:12px}
        .big{font-weight:600;color:#eaf2ff}
        .tiles{
            display:grid;grid-template-columns:repeat(auto-fill,minmax(140px,1fr));gap:10px;
            margin-top:12px;
        }
        .tile{
            background:var(--glass);padding:10px;border-radius:8px;font-size:0.9rem;color:#dbeafe;
            border:1px solid rgba(255,255,255,0.03);
        }
        footer{margin-top:18px;color:var(--muted);font-size:0.9rem;text-align:center}
        @media (max-width:820px){
            .grid{grid-template-columns:1fr; }
        }
    </style>
</head>
<body>
<div class="wrap">
    <header>
        <div class="logo">JW</div>
        <div>
            <h1>INTELLIJ: Fancy JSP Demo</h1>
            <p class="lead">INTELLIJ: A small styled homepage rendered with JSP expressions and scriptlets.</p>
        </div>
    </header>

    <div class="grid">
        <div class="card">
            <div class="meta">Server Time</div>
            <div class="big"><%= serverTime %></div>

            <hr style="border:none;height:12px;opacity:0"/>

            <div class="meta">Examples</div>
            <div style="display:flex;gap:10px;flex-wrap:wrap">
                <div class="tile">Uppercase: <strong><%= upper %></strong></div>
                <div class="tile">25 × 5 = <strong><%= 25 * 5 %></strong></div>
                <div class="tile">Boolean (75 &lt; 6): <strong><%= comparison %></strong></div>
            </div>

            <div style="margin-top:14px;color:var(--muted)">Output 100 times "HelloWorld"</div>
            <div class="tiles">
                <% for (int i = 1; i <= 100; i++) { %>
                <div class="tile"><%= i %>. HelloWorld</div>
                <% } %>
            </div>
        </div>

        <aside class="card">
            <div class="meta">Quick Actions</div>
            <div style="display:flex;flex-direction:column;gap:10px;margin-top:8px">
                <a href="#" style="text-decoration:none">
                    <div style="padding:10px;border-radius:8px;background:linear-gradient(90deg, rgba(124,58,237,0.15), rgba(14,165,233,0.08));color:#eaf2ff">
                        Explore
                    </div>
                </a>
                <a href="#" style="text-decoration:none">
                    <div style="padding:10px;border-radius:8px;background:rgba(255,255,255,0.02);color:var(--muted)">
                        Documentation
                    </div>
                </a>
            </div>

            <hr style="margin:14px 0;border:none;height:1px;background:rgba(255,255,255,0.03)"/>

            <div class="meta">About</div>
            <div style="font-size:0.95rem;color:var(--muted)">Simple JSP page with improved styling and safer scriptlet usage.</div>
        </aside>
    </div>

    <footer>Made with JSP • Minimal demo</footer>
</div>
</body>
</html>