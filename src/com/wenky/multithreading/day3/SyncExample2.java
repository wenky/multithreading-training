package com.wenky.multithreading.day3;
public class SyncExample2 {

	public static void main(String[] args) {
		Store store = new Store();
		Thread t1 = new Thread(() -> {
			for(int i = 0; i < Integer.MAX_VALUE; i++) {
				store.increment();
			}
		}); 
		Thread check = new Thread(() -> {
			while(true){
				store.check();
			}
		}); 
		t1.start();
		check.start();
	}
}

class Store {
	private volatile int a;
	private volatile int b;
	
	public void increment() {
		a++;
		b++;
	}
	
	public void check() {
		if(b > a) {
			System.out.println("b is greater than a");
		}
	}
	
}
