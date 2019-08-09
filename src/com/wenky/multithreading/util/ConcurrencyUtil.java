package com.wenky.multithreading.util;

public class ConcurrencyUtil {
	public static void sleep(long s) {
		try {
			Thread.currentThread().sleep(s*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
