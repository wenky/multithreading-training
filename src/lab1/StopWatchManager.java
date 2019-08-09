package lab1;

import java.util.Scanner;

public class StopWatchManager implements Runnable{
	
	StopWatch stopWatch;
	
	public StopWatchManager(StopWatch stopWatch) {
		super();
		this.stopWatch = stopWatch;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getState());
		Scanner scanner=new Scanner(System.in);
		StopWatch stopWatch=new StopWatch("StopWatch");		
		while(true) {
			if(scanner.hasNextInt()) {
				switch(scanner.nextInt()) {
				case 1:
					stopWatch.startTimer();
					break;
				case 0:
					stopWatch.stopTimer();
					break;
				}						
			}
		}	
		
	}

}
