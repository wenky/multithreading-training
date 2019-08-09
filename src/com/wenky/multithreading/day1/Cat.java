package com.wenky.multithreading.day1;

public class Cat implements Runnable{

	@Override
	public void run() {
		while(true) {
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			meow();
			stare();
		}
		
	}
	
	private void meow() {
		System.out.println(Thread.currentThread().getName()+" Meow Meow");
	}
	
	private void stare() {
		System.out.println(Thread.currentThread().getName()+" Starring");
		
	}

}
