package com.wenky.multithreading.day3.lab5;

import java.util.Scanner;

public class CoffeeMachine extends Thread {

	int milk = 1000;

	@Override
	public void run() {
		Scanner scanner = new Scanner(System.in);
		try {
			while (scanner.hasNextInt()) {
				char choice=(char)scanner.nextInt();
				if(choice=='c'|| choice=='e'|| choice=='r'|| choice=='q')
					dispense(choice);
			}
		} catch (InterruptedException e) {

		}
	}

	void dispense(String mesg, int quantity) throws InterruptedException {
		if (milk >= quantity) {
			System.out.println(mesg);
			if (mesg.contains("Espresso"))
				Thread.sleep(1000);
			else
				Thread.sleep(2000);
			milk -= quantity;
		} else {
			Thread.sleep(5000);
			System.err.println("Unable to Dispense");
		}
	}
	
	synchronized void  refill(int quantity) throws InterruptedException {
		System.err.println("Refilling ...");		
		Thread.sleep(10000);
		milk=1000;
		System.err.println("Refilling Done..");
	}

	public synchronized  void dispense(char choice) throws InterruptedException {
		switch (choice) {
		case 'e':
			dispense("Fetching Espresso ...", 100);
			break;
		case 'c':
			dispense("Fetching Cappucino..", 200);
			break;
		case 'r':
			refill(1000);
			break;
		case 'q':
			return;
		}
		System.out.println("Milk Quantity Available now: " + milk + "ml");
	}
	public int getMilk() {
		return milk;
	}
}
