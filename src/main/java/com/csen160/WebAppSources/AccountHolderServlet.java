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
@WebServlet("/AccountHolderServlet")
public class AccountHolderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountHolderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		System.out.println("AccountHolderServlet AccountHolderServlet AccountHolderServlet AccountHolderServlet");
		
		String accountNumber=request.getParameter("accountNumber");
		System.out.println("AccountHolderServlet: accountNumber="+accountNumber);
		
		Connection conn = null;
		Statement stmt = null;

		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "Admin");
			stmt = conn.createStatement();

			// Execute query
			String sql = "SELECT * FROM AccountHolders WHERE accountNumber = '"+accountNumber+"'";
			System.out.println("AccountHolderServlet: sql="+sql);
			
			ResultSet rs = stmt.executeQuery(sql);
			
			String[][] myArr=new String[10][100];
            boolean anyRows=false;
			for (int i=0;rs.next();i++) {
                anyRows=true;
				String tempAccNumber=""+rs.getInt(1);
				String tempHolName=rs.getString(2);
				String tempBalance=""+rs.getFloat(3);
				String tempAccType=rs.getString(4);
				
				System.out.println(
						"Account Number: " + tempAccNumber + 
						"\tHolder Name: "  + tempHolName + 
						"\tBalance: "     + tempBalance +
						"\tAccount Type: " + tempAccType);
				
				myArr[i][0]=tempAccNumber;
				myArr[i][1]=tempHolName;
				myArr[i][2]=tempBalance;
				myArr[i][3]=tempAccType;
			}
			
			HttpSession session = request.getSession();
            if (!anyRows) {
                myArr=null;
            }
			session.setAttribute("myArr", myArr);
												
			String red="/CSEN160_09_3_WebAppTomcat_war/AccountHolder/AccountHolderShow.jsp";
			response.sendRedirect(red);
				
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
