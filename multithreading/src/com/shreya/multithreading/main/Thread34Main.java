package com.shreya.multithreading.main;

import com.shreya.multithreading.thread.Thread3;
import com.shreya.multithreading.thread.Thread4;

public class Thread34Main {

	public static void main(String[] args) {
		
		Thread3 thread3=new Thread3();
		thread3.setName("Thread3");
		
		Thread4 thread4 = new Thread4();
		thread4.setName("Thread4");
		
		thread3.start();
		thread4.start();
		
	}
	
}
