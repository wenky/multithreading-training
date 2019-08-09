package com.wenky.multithreading.day2.lab1;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PowerThreadWuthResultSum {
	private static final int MAX_THREADS = 6;
	static final int MAX_WAITING_TIME = 1000 * 15;

	public static void main(String[] args) throws InterruptedException {

		List<MultiplicationThread> l = Arrays.asList(
				new MultiplicationThread(new BigDecimal("20000"), new BigDecimal("410")),
				new MultiplicationThread(new BigDecimal("1212122"), new BigDecimal("434")),
				new MultiplicationThread(new BigDecimal("21212"), new BigDecimal("422")),
				new MultiplicationThread(new BigDecimal("2000000000"), new BigDecimal("7844")),
				new MultiplicationThread(new BigDecimal("48903982"), new BigDecimal("231234")),
				new MultiplicationThread(new BigDecimal("22"), new BigDecimal("89")));

		for (MultiplicationThread m : l)
			m.start();

		Runnable runnable = () -> {
			boolean allCompleted = false;
			while (!allCompleted) {
				allCompleted=true;
				for (MultiplicationThread m : l) {
					if (m.getState() != Thread.State.TERMINATED) {
						allCompleted=false;
					}
				}
			}
		};

		Thread aggregationThread = new Thread(runnable);
		aggregationThread.join(MAX_WAITING_TIME);
		BigDecimal result=BigDecimal.ZERO;
		for (MultiplicationThread m : l) {
			if (m.getState() != Thread.State.TERMINATED) {
				m.interrupt();
			}else {
				if(result!=null)
				result=result.add(m.getResult());
			}
		}
		
		System.out.println("SUM::"+result);

	}
}