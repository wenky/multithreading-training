package com.wenky.multithreading.day3;

import java.util.concurrent.locks.ReentrantLock;

public class DeadLockWithReEntrant {
	public static void main(String[] args) {
		Railways2 railways2 = new Railways2();

		Thread trainA = new Thread(() -> {
			while (true) {
				try {
					railways2.passThroughA();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}, "Train A");

		Thread trainB = new Thread(() -> {
			while (true) {

				try {

					railways2.passThroughB();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}, "Train B");

		trainA.start();
		trainB.start();
	}
}

class Railways2 {
	private Object trackA = new Object();
	private Object trackB = new Object();
	private ReentrantLock myLock = new ReentrantLock();

	public void passThroughA() throws InterruptedException {
		System.out.println();
		myLock.lock();
//		synchronized (trackA) {
			System.out.println(Thread.currentThread().getName() + " is going to pass through A");
			Thread.sleep(2000);
//			synchronized (trackB) {
				Thread.sleep(1000);
				System.out.println(Thread.currentThread().getName() + " is going to pass through B");
//			}
//		}
		System.err.println(Thread.currentThread().getName() + " passed");
		myLock.unlock();
	}

	public void passThroughB() throws InterruptedException {
		myLock.lock();
		System.out.println();

		System.out.println(Thread.currentThread().getName() + " is going to pass through B");
		Thread.sleep(1000);

		Thread.sleep(2000);
		System.out.println(Thread.currentThread().getName() + " is going to pass through A");

		System.err.println(Thread.currentThread().getName() + " passed");
		myLock.unlock();
	}

}