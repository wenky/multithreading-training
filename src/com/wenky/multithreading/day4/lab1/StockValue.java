package com.wenky.multithreading.day4.lab1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;

import com.wenky.multithreading.util.ConcurrencyUtil;
import com.wenky.multithreading.util.HttpUtil;

public class StockValue {
	public static void main(String[] args) throws InterruptedException {
		List<String> stocks = Arrays.asList("HP", "GOOG", "FB", "WIPRO", "INFY", "DELL", "HUL");
		ExecutorService es = Executors.newCachedThreadPool();

		BlockingDeque<String> blockingDeque = new LinkedBlockingDeque<>();

		for (String stck : stocks) {
			es.submit(() -> {
				while (true) {
					 es.submit(() -> {
						 blockingDeque.add(HttpUtil.get("http://healthycoder.in/stocks.php?symbol=" + stck));
					});
					ConcurrencyUtil.sleep(3);
				}
			});
		}

		es.submit(() -> {
			while (true) {
				ConcurrencyUtil.sleep(1);
				System.out.println(blockingDeque.remove());
			}
		});

	}
}
