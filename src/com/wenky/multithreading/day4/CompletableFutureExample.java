package com.wenky.multithreading.day4;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import com.wenky.multithreading.util.ConcurrencyUtil;

public class CompletableFutureExample {
	public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {

		CompletableFuture<Void> a = CompletableFuture.supplyAsync(() -> {
			ConcurrencyUtil.sleep(5);
			return (int) (Math.random() * 1000);
		}).thenAccept(num->System.out.print("Here's my output "+num));
		
//		ConcurrencyUtil.sleep(2);
		System.out.println("End of Main"+a.get());
	}
}
