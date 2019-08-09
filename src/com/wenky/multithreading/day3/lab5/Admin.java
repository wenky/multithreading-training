package com.wenky.multithreading.day3.lab5;

public class Admin {

	public static void main(String[] args) {
		CoffeeMachine coffeeMachine = new CoffeeMachine();
		coffeeMachine.start();
		System.out.println("Press e for Espresso, c for Cappuccino, r to refill and q to quit.");

		User users = new User(coffeeMachine);
		users.start();

		Runnable refiller = () -> {
			while (true) {
				try {
					if (coffeeMachine.getMilk() == 0)
						coffeeMachine.refill(1000);
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		};
		
		Thread refillerThread = new Thread(refiller);
		refillerThread.setName("Refiller");
		refillerThread.start();
	}
}
