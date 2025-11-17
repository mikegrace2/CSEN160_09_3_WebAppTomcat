package com.csen160.WebAppSources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseSimpleClass {
    private static final Logger logger = LoggerFactory.getLogger(DatabaseSimpleClass.class);

	public static String[][] getTable() {
        logger.info("DatabaseSimpleClass.getTable() called");
		Connection conn = null;
		Statement stmt = null;

		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "Admin");
			stmt = conn.createStatement();

			// Execute query
			String sql = "SELECT * FROM COFFEES";
            logger.info("\"" + sql + "\";\n");

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
		} catch (SQLException e) {
			e.printStackTrace(); // Handle errors for JDBC
            logger.error("SQLException: ", e);
		} catch (Exception e) {
			e.printStackTrace(); // Handle errors for Class.forName
            logger.error("Exception: ", e);
		} finally {
			try {
				stmt.close();
				conn.close();				
			} catch (SQLException e) {
				e.printStackTrace();
                logger.error("Finally Exception: ", e);
			}
		}
		return null;
	}
}
