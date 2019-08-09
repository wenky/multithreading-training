package com.wenky.multithreading.day2;

public class BackgroundThreads {
public static void main(String[] args) {
	DumbThread d=new DumbThread();
	
//  Daemon Thread
//	A background thread that dies after the main thread dies
	d.setDaemon(true);
	d.start();
	System.out.println("end of main");
}
}

class DumbThread extends Thread {
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(1000);
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}