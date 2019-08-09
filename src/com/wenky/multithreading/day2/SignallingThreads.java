package com.wenky.multithreading.day2;

import java.io.IOException;
import java.util.Date;

public class SignallingThreads {
	public static void main(String[] args) throws InterruptedException {
	
		LongRunningThread thread=new LongRunningThread();
		thread.start();
		Thread.sleep(5000);
		thread.interrupt();
	}
}


class LongRunningThread extends Thread{
	@Override
	public void run() {
		while(true) {
			try {
				System.out.println(new Date());				
				Thread.sleep(1000);
				
			} catch (InterruptedException e) {
				System.out.println(getState());
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}