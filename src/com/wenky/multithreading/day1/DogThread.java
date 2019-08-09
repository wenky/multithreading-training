package com.wenky.multithreading.day1;

public class DogThread extends Thread{
	public DogThread(String name) {
		super(name);
	}
	@Override
	public void run() {
		while(true) {		
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			walk();
			wag();
		}

	}
	
	private void walk() {
		System.out.println(getName()+" Walking");
	}
	
	private void wag() {
		System.out.println(getName()+" Wagging");
	}

}
