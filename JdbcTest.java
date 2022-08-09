package org.com.jdbc;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class JdbcTest {
	   static final String DB_URL = "jdbc:mysql://localhost/nishat";
	   static final String USER = "root";
	   static final String PASS = "Nishat1234";
	   static final String QUERY = "SELECT employeeid FROM Employeed where employeename in ('anvi')";

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn=null;
		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Connected to Database successfully");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(QUERY);
			while (rs.next()) {
				System.out.println("Employee Id is " + rs.getInt("employeeid"));
			}
			conn.close();
 		  System.out.println("Program Finished");
		}
		catch(SQLException ex) {
			System.out.println("Exception Occured " + ex);	
		}
		finally {
			System.out.println("Closing the SQL COnnection");
			conn.close();
		}
	}

}
