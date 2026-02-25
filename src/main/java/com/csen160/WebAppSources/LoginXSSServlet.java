package com.csen160.WebAppSources;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.*;

/**
 * Servlet implementation class DatabaseServlet
 */
@WebServlet("/LoginXSSServlet")
public class LoginXSSServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginXSSServlet() {
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
		System.out.println("LoginXSSServlet invoked");

		String login=request.getParameter("login");
		System.out.println("LoginXSSServlet: login="+login);

		String target = "/login/LoginReflectXSS.jsp";
		System.out.println("Dispatching to: " + target);

		// Forward to JSP so errors are visible and resource resolution is within the webapp
		RequestDispatcher rd = request.getRequestDispatcher(target);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
