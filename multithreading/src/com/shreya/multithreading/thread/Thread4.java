package com.shreya.multithreading.thread;

public class Thread4 extends Thread{
	
	@Override
	public void run() {
		for (int i = 0; i < 3; i++) {
			System.out.println(this.getName()+ " is running..");
		}
	}
	
}
