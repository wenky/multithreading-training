package com.wenky.multithreading.day1;

public class DogUser {
	
	public static void main(String[] args) throws InterruptedException {
		System.out.println("This is main.."+Thread.currentThread().getName());
		DogThread snoopy=new DogThread("snoopy");
		snoopy.start();
		
		DogThread rocky=new DogThread("rocky");
		rocky.start();
		
		Cat cat=new Cat();
		Thread snow=new Thread(cat,"snow");
		snow.start();
		
	}

}
