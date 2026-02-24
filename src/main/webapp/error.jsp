<%@ page isErrorPage="true" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Application Error (Dev)</title>
    <style>
        body{font-family:Segoe UI, Roboto, Arial, sans-serif; padding:24px; background:#f9fafb;color:#111}
        .box{background:#fff;border-radius:8px;padding:18px;box-shadow:0 4px 14px rgba(0,0,0,0.06)}
        pre{background:#f3f4f6;padding:12px;border-radius:6px;overflow:auto}
    </style>
</head>
<body>
<div class="box">
    <h1>Application Error (development)</h1>
    <p>An exception occurred while processing your request. For development only — do not expose stack traces in production.</p>
    <h2>Exception</h2>
    <p><strong><%= (
            request.getAttribute("exception") != null ? ((Throwable)request.getAttribute("exception")).getClass().getName() :
            (request.getAttribute("javax.servlet.error.exception") != null ? ((Throwable)request.getAttribute("javax.servlet.error.exception")).getClass().getName() :
            (exception != null ? exception.getClass().getName() : "Unknown"))
        ) %></strong></p>
    <h3>Message</h3>
    <p><%= (
            request.getAttribute("exception") != null ? ((Throwable)request.getAttribute("exception")).getMessage() :
            (request.getAttribute("javax.servlet.error.exception") != null ? ((Throwable)request.getAttribute("javax.servlet.error.exception")).getMessage() :
            (exception != null ? exception.getMessage() : "(no message)"))
        ) %></p>

    <h3>Stack trace</h3>
    <pre><%
        Throwable ex = null;
        if (request.getAttribute("exception") != null) ex = (Throwable) request.getAttribute("exception");
        else if (request.getAttribute("javax.servlet.error.exception") != null) ex = (Throwable) request.getAttribute("javax.servlet.error.exception");
        else if (exception != null) ex = exception;

        String stack = "(no stack available)";
        if (ex != null) {
            java.io.StringWriter sw = new java.io.StringWriter();
            java.io.PrintWriter pw = new java.io.PrintWriter(sw);
            ex.printStackTrace(pw);
            pw.flush();
            stack = sw.toString();
        }
    %><%= stack %></pre>
</div>
</body>
</html>
