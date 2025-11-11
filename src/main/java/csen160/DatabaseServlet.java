package csen160;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Servlet implementation class DatabaseServlet
 */
@WebServlet("/DatabaseServlet")
public class DatabaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DatabaseServlet() {
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
			System.out.println("\"" + sql + "\";\n");
			
			response.setContentType("text/html");
			PrintWriter pw=response.getWriter();
			pw.println("<h1>Database Access Example (Servlet)!</h1>");
			pw.println("<table>\n");
			pw.println("  <tr>\n");
			pw.println("    <th>Coffee Name</th>\n");
			pw.println("    <th>Supplier ID</th>\n");
			pw.println("    <th>Price</th>\n");
			pw.println("    <th>Sales</th>\n");
			pw.println("    <th>Total</th>\n");
			pw.println("  </tr>\n");

			ResultSet rs = stmt.executeQuery(sql);			
			while (rs.next()) {
				pw.println("  <tr>\n");									
				pw.println("    <td>" + rs.getString(1) + "</td>\n"); 
				pw.println("    <td>" + rs.getInt(2)    + "</td>\n");
				pw.println("    <td>" + rs.getFloat(3)  + "</td>\n");
				pw.println("    <td>" + rs.getInt(4)    + "</td>\n");
				pw.println("    <td>" + rs.getInt(5)    + "</td>\n");
				pw.println("  </tr>\n");						
			}
			pw.println("</table>\n");
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
