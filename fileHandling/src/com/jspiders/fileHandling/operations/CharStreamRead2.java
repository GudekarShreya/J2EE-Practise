package com.jspiders.fileHandling.operations;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CharStreamRead2 {
	
	public static void main(String[] args) throws FileNotFoundException {
		
		File file=new File("Demo.txt");
		
		if (file.exists()) {
			
			Scanner scan = new Scanner(file);
			
			while (scan.hasNextLine()) {
				System.out.println(scan.nextLine());
			}
			System.out.println("\nData fetched from the file...");
			scan.close();
			
		} else {
			
			System.out.println("File does not found....");

		}
		
	}

}
