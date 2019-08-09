package com.wenky.multithreading.day1.lab2;
public class GuessingGameMultiThreaded {
	public static void main(String[] args) throws InterruptedException {
		
		Gamer gamer=new Gamer();
		
		Guesser guesser1=new Guesser(gamer,Algorithms::binarySearch,"guesser1") ;
		guesser1.start();
		
		
		Guesser guesser2=new Guesser(gamer,Algorithms::looping,"guesser2");
		guesser2.start();
		
		
	
		
		Thread referee=new Thread(()->{
			int i=0;
			while(i < 10) {
					try {
						System.out.println(".");
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
				i++;
			}
			System.out.println("Time Up");
			System.exit(0);
		});
		
		
		referee.start();
	}
}

class Gamer{
	final int target= (int)(Math.random() * 50);
	public boolean isCorrect(int number) {
		return target==number;
	}
}
