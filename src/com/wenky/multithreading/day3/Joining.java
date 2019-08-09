package com.wenky.multithreading.day3;

import java.util.concurrent.CountDownLatch;

public class Joining {
public static void main(String[] args) throws InterruptedException {
	CountDownLatch latch=new CountDownLatch(1);
	Kid son=new Kid(latch);
	son.setName("Wenky");
	son.start();
//	son.join();
	latch.await();
	System.out.println("let's go home");
}
}

class Kid extends Thread{
	private CountDownLatch latch;
	public Kid(CountDownLatch latch) {
		this.latch=latch;
	}

	public void run() {
		try {
			System.out.println(getName()+" is in school");
			Thread.sleep(1000);
			latch.countDown();
			
			Thread.sleep(2000);
			
			latch.countDown();
			System.out.println(".."+latch.getCount());
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}
