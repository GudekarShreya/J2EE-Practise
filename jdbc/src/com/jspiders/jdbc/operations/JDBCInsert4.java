package com.jspiders.jdbc.operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCInsert4 {
	
	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static String query;
	
	
	public static void main(String[] args) throws ClassNotFoundException {
		
		Scanner scanner=new Scanner(System.in);
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
		scanner.close();
		
		
		try {
			connection=openConnection();
			query="insert into student values(?,?,?,?,?)";
			preparedStatement=connection.prepareStatement(query);
			
			
//			preparedStatement=connection.prepareStatement("insert into student values(?,?,?,?,?)");	//DYNAMIC QUERY
			
			preparedStatement.setInt(1,id);
			preparedStatement.setString(2,name);
			preparedStatement.setString(3,email);
			preparedStatement.setInt(4,age);
			preparedStatement.setDouble(5,fees);
			
			int row=preparedStatement.executeUpdate();
			
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
	
	private static Connection openConnection() throws SQLException, ClassNotFoundException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/weja3","root","root");
				
	}
	
	private static void closeConnection() throws SQLException {
		
		if (preparedStatement!=null) {
			preparedStatement.close();
		} 
		if(connection!=null) {
			connection.close();
		}
	}


}
