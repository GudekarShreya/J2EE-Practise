package com.jspiders.fileHandling.operations;

import java.io.File;

public class DeleteFile {
	
	public static void main(String[] args) {
		
		File file=new File("D:\\J2EE\\WEJA3\\Demo1.txt");
		if (file.exists()) {
			
			System.out.println("File is present");
			file.delete();
			System.out.println("File is deleted...!");
			
		} else {
			
			System.out.println("File does not exists...");

		}
		
	}

}
