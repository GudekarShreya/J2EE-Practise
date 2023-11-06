package com.jspiders.fileHandling.operations;

import java.io.File;
import java.io.IOException;

public class CreateFile2 {
	
	public static void main(String[] args) {
		
		File file=new File("D:\\J2EE\\WEJA3\\Demo1.txt");	//ABSOLUTE PATH-->PATH HAVING FOLDER PATH ALONG WITH FILE NAME AND EXTENTION
		
		try {
			file.createNewFile();
			System.out.println("File is created...");
		}
		catch (IOException e) {
			e.printStackTrace();
			System.out.println("File is not created...");
		}
		
				
		file=new File("Demo1.txt");
		if (file.exists()) {								//exists()-->USED TO CHECK WHETHER SPECIFIED FILE IS PRESENT OR NOT
			
			System.out.println("File is already exists...");
			
		} else {
			
			try {
				file.createNewFile();
				System.out.println("File is created");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("File is not created");
			}
			

		}
		
	}

}
