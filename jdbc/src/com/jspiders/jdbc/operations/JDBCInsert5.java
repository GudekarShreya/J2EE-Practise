package com.jspiders.jdbc.operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCInsert5 {
	
	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static String query;
	
	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		
		try {
			connection=openConnection();
			query="insert into student values(?,?,?,?,?)";
			preparedStatement=connection.prepareStatement(query);
			
			for (int i = 1; i <= 2; i++) {
				System.out.println("Enter Student Id-->");
				int id=scanner.nextInt();
				scanner.nextLine();
				System.out.println("Enter Student Name-->");
				String name=scanner.nextLine();
				System.out.println("Enter Student Email-->");
				String email=scanner.nextLine();
				System.out.println("Enter Student Age-->");
				int age=scanner.nextInt();
				System.out.println("Enter Student Fees-->");
				double fees=scanner.nextDouble();
				System.out.println("---------------------------");
				
				preparedStatement.setInt(1,id);
				preparedStatement.setString(2, name);
				preparedStatement.setString(3,email);
				preparedStatement.setInt(4,age);
				preparedStatement.setDouble(5,fees);
				preparedStatement.addBatch();
				
			}
			
			scanner.close();
			int[] row=preparedStatement.executeBatch();
			System.out.println(row.length+"row(s) affected");
			
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
	
	private static Connection openConnection() throws SQLException, ClassNotFoundException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/weja3","root","root");
		
	}
	
	private static void closeConnection() throws SQLException {
		
		if (preparedStatement != null) {
			preparedStatement.close();
		}
		if (connection != null) {
			connection.close();
		}
		
	}

}
