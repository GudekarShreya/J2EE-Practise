package com.jspiders.jdbc.operations;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCSelect {
	
	private static Connection connection;
	private static Statement statement;
	private static ResultSet resultSet;
	private static String query;
	
	
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		
		
		try {
			connection=openConnection();
			statement=connection.createStatement();
			query="select * from student";		//STATIC QUERY
			statement.executeQuery(query);
			resultSet=statement.getResultSet();
			while (resultSet.next()) {
//				System.out.print(resultSet.getInt(1)+"	"+resultSet.getString(2)+"	"+resultSet.getString(3)+"	"+resultSet.getInt(4)+"	"+resultSet.getDouble(5));
//				System.out.println();
				System.out.println(resultSet.getInt(1));
				System.out.println(resultSet.getString(2));
				System.out.println(resultSet.getString(3));
				System.out.println(resultSet.getInt(4));
				System.out.println(resultSet.getDouble(5));
				System.out.println("----------------------");
				
			}
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
	
	private static Connection openConnection() throws SQLException, IOException, ClassNotFoundException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		File file=new File("D:\\J2EE\\WEJA3\\jdbc\\dbInfo.txt");
		FileReader fileReader=new FileReader(file);
		Properties properties=new Properties();
		properties.load(fileReader);
		return DriverManager.getConnection(properties.getProperty("url"),properties);
				
	}
	
	private static void closeConnection() throws SQLException {
		
		if (resultSet!=null) {
			resultSet.close();
		}
		
		if (statement!=null) {
			statement.close();
		} 
		if(connection!=null) {
			connection.close();
		}
		
		
	}

}
