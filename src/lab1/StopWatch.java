package lab1;

public class StopWatch extends Thread{

	long timer;
	boolean isOn;
	public StopWatch(String name) {
		super(name);
		timer=0;
	}

	@Override
	public void run() {	
		try {
		while(true) {					
				Thread.currentThread().sleep(1000);
				timer++;
			
		}	
		} catch (InterruptedException e) {
			System.out.println("interrupted");
			Thread.currentThread().stop();
		}
		System.out.println(Thread.currentThread().getName()+" finished execution");
	}
	
	public void stopTimer(){
		System.out.println("stoptimer.."+Thread.currentThread().getState());
		if(getState().equals(Thread.State.RUNNABLE)) {
			System.out.println("Stopping the Timer");
			Thread.currentThread().interrupt();
			System.out.println("stoptimer.."+Thread.currentThread().getState());
		}
		System.out.println("Time: "+timer+"sec");
		timer=0;
	}
	
	public void startTimer() {		
		System.out.println("starttimer.."+Thread.currentThread().getState());
		if(getState()==Thread.State.NEW) {		
			System.out.println("Starting the Timer");
			start();			
		}
	}

}
