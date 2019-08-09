package com.wenky.multithreading.day3;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
public static void main(String[] args) throws InterruptedException {
	CountDownLatch latch=new CountDownLatch(6);
	SchoolKid sam=new SchoolKid(latch,"Sam");
	SchoolKid ram=new SchoolKid(latch,"Ram");
	SchoolKid ravi=new SchoolKid(latch,"ravi");
	SchoolKid joe=new SchoolKid(latch,"Joe");
	SchoolKid virat=new SchoolKid(latch,"Virat");
	SchoolKid anuhska=new SchoolKid(latch,"Anushka");
	sam.start();
	ram.start();
	ravi.start();
	joe.start();
	virat.start();
	anuhska.start();
	System.out.println("***Van has arrived to pick up the children***");
	latch.await();
	System.out.println("***Van is ready to leave now***");
}
}

class SchoolKid extends Thread{
	private CountDownLatch latch;

	public  SchoolKid(CountDownLatch latch,String name) {
		this.latch=latch;
		this.setName(name);
	}

	public void run() {
		try {
			System.out.println(getName()+" is in school");
			Thread.sleep(2000);
			latch.countDown();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}
