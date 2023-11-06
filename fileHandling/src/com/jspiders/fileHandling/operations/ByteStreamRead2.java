package com.jspiders.fileHandling.operations;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ByteStreamRead2 {
	
public static void main(String[] args) throws IOException {
		
		File file=new File("Test.txt");
		
		if (file.exists()) {
			
			Scanner scanner=new Scanner(file);
			while (scanner.hasNextLine()) {
				System.out.println(scanner.nextLine());
			}
			System.out.println("Data is fetched from the file...");
			scanner.close();
			
		} else {
			
			System.out.println("File does not exists...");

		}
		
	}

}
