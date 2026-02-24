package com.csen160.WebAppSources;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DatabaseServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * Simple HTML escape helper to avoid external dependencies (development use)
	 */
	private static String escapeHtml(String s) {
		if (s == null) return "";
		return s.replace("&", "&amp;")
		       .replace("<", "&lt;")
		       .replace(">", "&gt;")
		       .replace("\"", "&quot;")
		       .replace("'", "&#39;");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		System.out.println("LoginServlet invoked");

		String login=request.getParameter("login");
		String password=request.getParameter("password");
		System.out.println("LoginServlet: login="+login);
		System.out.println("LoginServlet: password="+password);
		
		boolean isOK=false;

		try {
			// Ensure the driver class is loaded/registered before requesting a connection
			Class.forName("org.postgresql.Driver");
			try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "Admin");
					Statement stmt = conn.createStatement()) {
				// Execute query
				String sql = "SELECT * FROM USERS where username='"+login+"' AND password_hash='"+password+"'";
				System.out.println("LoginServlet: sql="+sql);

				ResultSet rs = stmt.executeQuery(sql);

				while (rs.next()) {
					System.out.println(
						"ID: "   + rs.getInt(1) +
						"\tusername: " + rs.getString(2)    + 
						"\tpassword_hash: " + rs.getString(3));
					isOK=true;
				}

				String target;
				if (isOK) {
					target = "/login/LoginCorrect.jsp";
				} else {
					target = "/login/LoginFail.jsp";
				}
				System.out.println("Dispatching to: " + target);

				// Forward to JSP so errors are visible and resource resolution is within the webapp
				RequestDispatcher rd = request.getRequestDispatcher(target);
				rd.forward(request, response);
			}
		} catch (SQLException se) {
			se.printStackTrace(); // Handle errors for JDBC
			// Development helper: write stack trace directly to response so we always see it
			response.setContentType("text/html;charset=UTF-8");
			java.io.StringWriter sw = new java.io.StringWriter();
			java.io.PrintWriter pw = new java.io.PrintWriter(sw);
			se.printStackTrace(pw);
			pw.flush();
			response.getWriter().write("<html><head><title>Error</title></head><body><h1>Exception (development)</h1><pre>" + escapeHtml(sw.toString()) + "</pre></body></html>");
			response.getWriter().flush();
			return;
		} catch (Exception e) {
			e.printStackTrace(); // Handle errors for Class.forName
			response.setContentType("text/html;charset=UTF-8");
			java.io.StringWriter sw = new java.io.StringWriter();
			java.io.PrintWriter pw = new java.io.PrintWriter(sw);
			e.printStackTrace(pw);
			pw.flush();
			response.getWriter().write("<html><head><title>Error</title></head><body><h1>Exception (development)</h1><pre>" + escapeHtml(sw.toString()) + "</pre></body></html>");
			response.getWriter().flush();
			return;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
