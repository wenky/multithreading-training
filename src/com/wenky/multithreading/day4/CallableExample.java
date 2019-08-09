package com.wenky.multithreading.day4;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import com.wenky.multithreading.util.ConcurrencyUtil;

public class CallableExample {
public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
	ExecutorService es=Executors.newCachedThreadPool();
	Future<Integer> future=es.submit(()->{
		ConcurrencyUtil.sleep(5);		
		return (int)(Math.random()*1000);
	});

	while(!future.isDone()) {
		System.out.print(".");
		ConcurrencyUtil.sleep(1);
	}
	
	
	
	
	
	System.out.println();
	System.out.println(future.get());
	
	Runnable runnable=()->System.out.println("runnable..");
	Future<?> a = es.submit(runnable);
	System.out.println(a.get());
	System.out.println("End of main");
}
}
