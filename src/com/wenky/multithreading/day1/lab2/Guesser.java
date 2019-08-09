package com.wenky.multithreading.day1.lab2;

public class Guesser  extends Thread{
	Gamer gamer;
	Algorithm algorithm;
	
	public Guesser(Gamer gamer, Algorithm algorithm,String name) {
		this.gamer=gamer;
		this.algorithm=algorithm;
		this.setName(name);
	}

	@Override
	public void run() {
		System.out.println(getName()+" started");
		while(true) {
			if(gamer.isCorrect(algorithm.getRandomNumber())) {
				System.out.println(getName()+" wins");
				break;
			}
		}
	}
	
}
