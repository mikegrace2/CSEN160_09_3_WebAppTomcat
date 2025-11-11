package csen160;

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
@WebServlet("/DatabaseJspServlet")
public class DatabaseJspServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DatabaseJspServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = null;
		Statement stmt = null;

		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "Admin");
			stmt = conn.createStatement();

			// Execute query
			String sql = "SELECT * FROM COFFEES";
			response.setContentType("text/html");
			ResultSet rs = stmt.executeQuery(sql);
			
			String[][] myArr=new String[5][100];
			for (int i=0;rs.next();i++) {
				myArr[0][i]=rs.getString(1);
				myArr[1][i]=""+rs.getInt(2);
				myArr[2][i]=""+rs.getFloat(3);
				myArr[3][i]=""+rs.getInt(4);
				myArr[4][i]=""+rs.getInt(5);				
			}
			
			HttpSession session = request.getSession();
			session.setAttribute("myArr", myArr);
						
			response.sendRedirect("http://localhost:8080/Week07_D_Tomcat3TierWebApp/DatabaseJsp/databaseJSP.jsp");
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
