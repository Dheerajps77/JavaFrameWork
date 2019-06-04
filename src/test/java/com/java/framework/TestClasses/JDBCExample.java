package com.java.framework.TestClasses;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCExample {

		// JDBC driver name and database URL
		static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		static String DB_URL = "jdbc:sqlserver://10.11.2.121:1433;databaseName=PersonsDetails";

		// Database credentials
		static String USER = "dheeraj";
		static String PASS = "dheeraj";

		public static void main(String[] args) {

	 		Connection conn = null;
			Statement stmt = null;

			try {

				// STEP 2: Register JDBC driver
				Class.forName("com.mysql.jdbc.Driver");

				// STEP 3: Open a connection
				System.out.println("Connecting to database...");
				conn = DriverManager.getConnection(DB_URL, USER, PASS);

				// STEP 4: Execute a query
				System.out.println("Creating statement...");
				stmt = conn.createStatement();	
				ResultSet rs1 = stmt.executeQuery("select name from sys.tables");
				String string=rs1.toString();
				System.out.println(string);
				ResultSet rs = stmt.executeQuery("select * from Customers");
				

				// STEP 5: Extract data from result set
				while (rs.next()) {
					// Retrieve by column name
					int companyName = rs.getInt("CustomerID");
					String customerName = rs.getString("CustomerName");
					String contactName = rs.getString("ContactName");
					String country = rs.getString("Country");
					// Display values
					System.out.println(companyName + " : : " + customerName + " : : " + contactName + country);

				}
				/*
				String queryToInsertString="insert into Customers(CustomerID, CustomerName, ContactName, Country) values(?, ?, ?, ?)";
				PreparedStatement ps=conn.prepareStatement(queryToInsertString);
				ps.setInt(1, 6);
				ps.setString(2, "Dheeraj Pratap Singh");
				ps.setString(3, "Maria Anders");
				ps.setString(4, "India");
				boolean b=ps.execute();
				
				 //STEP 4: Execute a query
			      System.out.println("Inserting records into the table...");
				stmt=conn.createStatement();
				
				String query1="insert into Customers(CustomerID, CustomerName, ContactName, Country) values(6, 'Dheeraj Pratap Singh', 'John Cena', 'India')";
				stmt.executeUpdate(query1);
				// STEP 6: Clean-up environment
				rs.close();
				stmt.close();
				conn.close();

*/
			} catch (SQLException se) {
				// Handle errors for JDBC
				se.printStackTrace();
			} catch (Exception e) {
				// Handle errors for Class.forName
				e.printStackTrace();
			} finally {
				// finally block used to close resources
				try {
					if (stmt != null)
						stmt.close();
				} catch (SQLException se2) {
				} // nothing we can do
				try {
					if (conn != null)
						conn.close();
				} catch (SQLException se) {
					se.printStackTrace();
				} // end finally try
			} // end try
			System.out.println("Goodbye!");
		}
	}

