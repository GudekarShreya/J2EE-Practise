package com.jspiders.fileHandling.operations;

import java.io.File;
import java.io.IOException;

public class CreateFile1 {
	
	public static void main(String[] args) {
		
		File file = new File("Demo1.txt");
		try {
			file.createNewFile();		//createNewFile()--> USED TO CREATE NEW FILE.... IT IS PRESENT INSIDE FILE CLASS...
			System.out.println("File is created....");
		} catch (IOException e) {
			System.out.println("File is not created...");
		}
		
	}

}
