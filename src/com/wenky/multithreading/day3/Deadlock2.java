package com.wenky.multithreading.day3;
import java.util.concurrent.locks.ReentrantLock;

public class Deadlock2 {

	public static void main(String[] args) throws InterruptedException {
		Metro railways = new Metro();
		Thread trainA = new Thread(() -> {
			while(true) {
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				railways.passThroughA();
			}
		}, "TrainA") ;
		
		Thread trainB = new Thread(() -> {
			while(true) {
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				railways.passThroughB();
			}
		}, "TrainB") ;
		
		trainA.start();
		trainB.start();
		trainA.join();
		trainB.join();
	}
}

class Metro {
	private Object trackA = new Object();
	private Object trackB = new Object();
	private ReentrantLock myLock = new ReentrantLock();
	
	
	public void passThroughA() {
		//myLock.lock();
		if(myLock.tryLock()) {
			try {
				try {
					System.out.println(Thread.currentThread().getName() + 
							" is going to pass through A");
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + 
						" passed through A");
			}
			finally {
				myLock.unlock();
			}
		}
		else {
			System.err.println("******RED for " + Thread.currentThread().getName());
		}

	}
	
	public void passThroughB() {
		//myLock.lock();
		if(myLock.tryLock()) {
			try {
				try {
					System.out.println(Thread.currentThread().getName() + 
							" is going to pass through B");
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + 
						" passed through B");
			}
			finally {
				myLock.unlock();
			}			
		}
		else {
			System.err.println("*****RED for " + Thread.currentThread().getName());
		}

	}
}
