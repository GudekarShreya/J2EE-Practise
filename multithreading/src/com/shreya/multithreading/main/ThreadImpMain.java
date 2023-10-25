package com.shreya.multithreading.main;

import com.shreya.multithreading.thread.ThreadImplement;

public class ThreadImpMain {
	
	public static void main(String[] args) {
		
		ThreadImplement threadImplement=new ThreadImplement();
		Thread thread=new Thread(threadImplement);
		thread.start();
		
	}

}
