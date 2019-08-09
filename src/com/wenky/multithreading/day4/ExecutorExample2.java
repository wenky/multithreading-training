package com.wenky.multithreading.day4;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.wenky.multithreading.util.ConcurrencyUtil;

public class ExecutorExample2 {
	public static void main(String[] args) throws InterruptedException {
		ExecutorService es=Executors.newFixedThreadPool(20);
//		ExecutorService es=Executors.newCachedThreadPool();
		
		for(int i=0;i<10;i++) {
			es.execute(()->{
				final int id=(int)(Math.random()*1000);
				while(true) {					
					System.out.println(id +" executed by  "+Thread.currentThread().getName());
					ConcurrencyUtil.sleep(1);
				}
			});
		}
	
		
		es.awaitTermination(10, TimeUnit.SECONDS);
//		es.shutdownNow();//es cannot be used furthur
//		es.shutdown();
	}
}
