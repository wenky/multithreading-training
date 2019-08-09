package com.wenky.multithreading.day3;

public class SyncExample {
	public static void main(String[] args) throws InterruptedException {
		Counter counter=new Counter();
		IncrementingThread incThread=new IncrementingThread(counter);
		DecrementingThread decThread=new DecrementingThread(counter);
		incThread.start();
		decThread.start();
		System.out.println(counter.getItem());
	}
}

class DecrementingThread extends Thread{
	private Counter counter;
	public DecrementingThread(Counter counter) {
		this.counter=counter;
	}
	
	@Override
	public void run() {
		for(int i=0;i<Integer.MAX_VALUE;i++) {
			counter.decrement();
		}
	}
	
}

class IncrementingThread extends Thread{
	private Counter counter;
	public IncrementingThread(Counter counter) {
		this.counter=counter;
	}
	
	@Override
	public void run() {
		for(int i=0;i<Integer.MAX_VALUE;i++) {
			counter.increment();
		}
	}
}

class Counter{
	int item;
	public synchronized void increment() {
		item++;
	}

	public synchronized  void decrement() {
		item--;
	}
	public int getItem() {
		return item;
	}
	
}
