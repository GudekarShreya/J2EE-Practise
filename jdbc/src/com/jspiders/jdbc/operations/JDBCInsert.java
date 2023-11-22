package com.jspiders.jdbc.operations;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCInsert {
	
	public static void main(String[] args) throws SQLException {
		
		//REGISTER DRIVER
		Driver driver = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(driver);
		
		//OPEN CONNECTION
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/weja3?user=root&&password=root");
		
		//CREATE STATEMENT
		Statement statement=connection.createStatement();
		
		//EXECUTE STATEMENT
		statement.execute("insert into student values(4,'Mahesh','mahesh@gmail.com',25,25000)");
		
		//PROCESS RESULT
		System.out.println("Data inserted..");
		
		//CLOSE CONNECTION
		statement.close();
		connection.close();
		
		//DE-REGISTER DRIVER
		DriverManager.deregisterDriver(driver);
		
	}

}
