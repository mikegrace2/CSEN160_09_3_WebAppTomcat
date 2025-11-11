package csen160;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseSimpleClass {
	public static String[][] getTable() {
		Connection conn = null;
		Statement stmt = null;

		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "Admin");
			stmt = conn.createStatement();

			// Execute query
			String sql = "SELECT * FROM COFFEES";
			System.out.println("\"" + sql + "\";\n");

			ResultSet rs = stmt.executeQuery(sql);
			
			String[][] myArr=new String[5][100];
			for (int i=0;rs.next();i++) {
				myArr[0][i]=rs.getString(1);
				myArr[1][i]=""+rs.getInt(2);
				myArr[2][i]=""+rs.getFloat(3);
				myArr[3][i]=""+rs.getInt(4);
				myArr[4][i]=""+rs.getInt(5);				
			}
			
			return myArr;
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
		return null;
	}
}
