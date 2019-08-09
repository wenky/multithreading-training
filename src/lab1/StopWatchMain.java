package lab1;

import java.util.Scanner;

public class StopWatchMain {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Press 1 to start the stopwatch, 0 to stop the stopwatch");	
		Thread.currentThread().setName("Main Thread");
		StopWatch stopWatch=new StopWatch("StopWatch");		
		StopWatchManager stopWatchManager=new StopWatchManager(stopWatch);	
		Thread t=new Thread(stopWatchManager,"StopWatchManager");
		
		System.out.println(t.getState());
		t.start();			
		Thread.currentThread().sleep(5000);
		System.out.println(Thread.currentThread().getState());
	}
}
