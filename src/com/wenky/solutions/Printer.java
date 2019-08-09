package com.wenky.solutions;

public class Printer  extends Thread{
	public Printer(String name) {
		this.setName(name);
	}
	
	@Override
	public void run() {
		while(true) {
			System.out.println(getName());
		}
	}

}
