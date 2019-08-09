package com.wenky.multithreading.day3.lab5;

import java.util.Random;

public class User extends Thread{
	CoffeeMachine coffeeMachine;
	final int ASCII_a=97;
	final int ASCII_z=122;
	
	public User(CoffeeMachine coffeeMachine) {
		this.coffeeMachine=coffeeMachine;
	}



	@Override
	public void run() {
		try {
		while(true) {
			Random random=new Random();
			char choice=(char)random.nextInt(ASCII_z);		
			
			if(choice=='e' || choice =='c'  || choice=='q') {
				System.out.println(choice);
				coffeeMachine.dispense(choice);
			}
		}
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
