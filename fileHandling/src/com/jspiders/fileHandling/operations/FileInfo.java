package com.jspiders.fileHandling.operations;

import java.io.File;

public class FileInfo {
	
	public static void main(String[] args) {
		
		File file =new File("Demo1.txt");
		
		if (file.exists()) {
			
			System.out.println("File Name:- "+file.getName());
			System.out.println("File Path:- "+file.getAbsolutePath());
			
			if (file.canRead()) {
				System.out.println("File is Readable.");
			} else {
				System.out.println("File is Not Readable.");
			}
			
			if (file.canWrite()) {
				System.out.println("File is Writable.");

			} else {
				System.out.println("File is Not Writable.");

			}
			
			if (file.canExecute()) {
				System.out.println("File is Executable.");
			} else {
				System.out.println("File is Not Executable");
			}
			
			System.out.println("Length of File:- "+file.length());
			
			
		} else {
			System.out.println("File does not exist...");
		}
		
	}

}
