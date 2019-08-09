package com.wenky.multithreading.day3;

public class DeadLock {
	public static void main(String[] args) {
		Railways railways=new Railways();
		
		Thread trainA=new Thread(()->{
			while(true) {
				try {
					railways.passThroughA();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		},"Train A");
		
		Thread trainB=new Thread(()->{
			while(true) {
				
				try {
					
					railways.passThroughB();					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		},"Train B");
		
		trainA.start();
		trainB.start();
	}
}

class Railways {
	private Object trackA = new Object();
	private Object trackB = new Object();

	public void passThroughA() throws InterruptedException {
		System.out.println();
		synchronized (trackA) {
			System.out.println(Thread.currentThread().getName()+" is going to pass through A");
			Thread.sleep(2000);
			synchronized (trackB) {
				Thread.sleep(1000);
				System.out.println(Thread.currentThread().getName()+" is going to pass through B");
			}
		}
		System.err.println(Thread.currentThread().getName()+" passed");
	}

	public void passThroughB() throws InterruptedException {
		System.out.println();
		synchronized (trackB) {
			System.out.println(Thread.currentThread().getName()+" is going to pass through B");
			Thread.sleep(1000);
			synchronized (trackA) {
				Thread.sleep(2000);
				System.out.println(Thread.currentThread().getName()+" is going to pass through A");
			}
		}
		System.err.println(Thread.currentThread().getName()+" passed");
	}

}