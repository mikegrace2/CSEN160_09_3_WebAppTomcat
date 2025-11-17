package com.csen160.WebAppSources;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		System.out.println("LoginServlet LoginServlet LoginServlet LoginServlet");
		
		String login=request.getParameter("login");
		String password=request.getParameter("password");
		System.out.println("LoginServlet: login="+login);
		System.out.println("LoginServlet: password="+password);
		
		Connection conn = null;
		Statement stmt = null;

		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "Admin");
			stmt = conn.createStatement();

			// Execute query
			String sql = "SELECT * FROM USERS where username='"+login+"' AND password_hash='"+password+"'";
			System.out.println("LoginServlet: sql="+sql);
			
			ResultSet rs = stmt.executeQuery(sql);
						
			boolean isOK=false;
			
			while (rs.next()) {
				System.out.println(
						"ID: "   + rs.getInt(1) + 
						"\tusername: " + rs.getString(2)    + 
						"\tpassword_hash: " + rs.getString(3));
				isOK=true;
			}
			
			//HttpSession session = request.getSession();
			//session.setAttribute("myArr", myArr);
									
			if (isOK) {
				String red="/CSEN160_09_3_WebAppTomcat_war_exploded/login/LoginCorrect.jsp";
				response.sendRedirect(red);
			}else {
				String red="/CSEN160_09_3_WebAppTomcat_war_exploded/login/LoginFail.jsp";
				response.sendRedirect(red);
			}
				
		} catch (SQLException se) {
			se.printStackTrace(); // Handle errors for JDBC
		} catch (Exception e) {
			e.printStackTrace(); // Handle errors for Class.forName
		} finally {
			try {
				stmt.close();
				conn.close();				
			} catch (SQLException e) {
				e.printStackTrace();
			}
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
