package com.jspiders.jdbc.operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCUpdate2 {
	
	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static String query;
	
	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter student id -->");
		int id = scanner.nextInt();
		System.out.println("Enter new fees-->");
		double fees = scanner.nextDouble();
		scanner.close();
		
		try {
			
			connection=openConnection();
			query="update student set fees=? where id=?";
			preparedStatement= connection.prepareStatement(query);
			preparedStatement.setDouble(1, fees);
			preparedStatement.setInt(2, id);
			int row = preparedStatement.executeUpdate();
			System.out.println(row + " row(s) affected..");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	private static Connection openConnection() throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/weja3","root","root");
		
	}
	
	private static void closeConnection() throws SQLException {
		
		if (preparedStatement!=null) {
			preparedStatement.close();
		}
		if (connection!=null) {
			connection.close();
		}
		
	}

}
