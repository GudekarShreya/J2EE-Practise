package com.jspiders.jdbc.operations;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCInsert2 {
	
	private static Driver driver;
	private static Connection connection;
	private static Statement statement;
	private static String query;
	
	
	public static void main(String[] args) {
		
		try {
			connection=openConnection();
			statement=connection.createStatement();
			query="INSERT INTO student VALUES(2,'Rani','rani@gmail.com',22,20000)";		//STATIC QUERY
			int row=statement.executeUpdate(query);		
			System.out.println(row+" row(s) affected...");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				
				closeConnection();
				
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
	}
	
	private static Connection openConnection() throws SQLException {
		
		driver=new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(driver);
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/weja3","root","root");
				
	}
	
	private static void closeConnection() throws SQLException {
		
		if (statement!=null) {
			statement.close();
		} 
		if(connection!=null) {
			connection.close();
		}
		DriverManager.deregisterDriver(driver);
		
	}
}
