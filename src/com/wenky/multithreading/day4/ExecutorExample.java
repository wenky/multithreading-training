package com.wenky.multithreading.day4;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.wenky.multithreading.util.ConcurrencyUtil;

public class ExecutorExample {
	public static void main(String[] args) throws InterruptedException {
		ExecutorService es=Executors.newFixedThreadPool(1);
		es.execute(()->{
			for(int i=0;i<5;i++) {
				System.out.println("A "+new Date()+" in "+Thread.currentThread().getName());
				ConcurrencyUtil.sleep(1);
			}
		});
		es.execute(()->{
			for(int i=0;i<5;i++) {
				System.out.println("B "+new Date()+" in "+Thread.currentThread().getName());
				ConcurrencyUtil.sleep(1);
			}
		});
		
		es.awaitTermination(10, TimeUnit.SECONDS);
		es.shutdownNow();//es cannot be used furthur
		es.shutdown();
	}
}
