package com.wenky.multithreading.day1.lab2;
public class GuessingGameMain {
	public static void main(String[] args) throws InterruptedException {
		int target = (int)(Math.random() * 50); //77
		int guess = 50;
		int i = 1;
		
		while(i < 100) {
			guess = i;
			System.out.println("Guess: " + guess);
			if(guess > target) {
				System.out.println("Aim Lower");
			}
			else if(guess < target) {
				System.out.println("Aim Higher");
			}
			else {
				System.out.println("Correct");
				break;
			}
			Thread.sleep(100);
			i++;
		}
	}
}
