package com.wenky.multithreading.day2.lab1;

import java.math.BigDecimal;
import java.util.Scanner;

public class PowerThread {
	private static final int  MAX_THREADS=6;
	 static final int MAX_WAITING_TIME=1000*10;

	public static void main(String[] args) throws InterruptedException {
		Scanner scanner=new Scanner(System.in);
		
		while(scanner.hasNextBigDecimal()) {
			BigDecimal num=scanner.nextBigDecimal();	
			System.out.print(" power ");
			BigDecimal pow=scanner.nextBigDecimal();	
			
			while(Thread.activeCount()>MAX_THREADS) {
				Thread.sleep(5000);
				System.out.println("Please wait..You are exhausted "+Thread.activeCount()+"/"+MAX_THREADS);
			}
			
			MultiplicationThread multiplicationThread=new MultiplicationThread(num, pow);
			multiplicationThread.start();
			multiplicationThread.join(MAX_WAITING_TIME);
			System.out.println(multiplicationThread.getState());
			System.out.println(Thread.currentThread().getState());
			if(multiplicationThread.getState()==Thread.State.RUNNABLE) {
				multiplicationThread.interrupt();
				System.out.println(multiplicationThread.getName()+" : Time Up");
			}						
		}		
	}
}