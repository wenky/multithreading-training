package com.wenky.multithreading.day2.lab1;

import java.math.BigDecimal;

class MultiplicationThread extends Thread{
	 BigDecimal num,pow,result;
	 
	 public MultiplicationThread(BigDecimal num,BigDecimal pow) {
		super();
		this.num=num;
		this.pow=pow;
		this.setName("MultiplicationThread:"+num+"^"+pow);
		this.result=null;
	}
	
	public void runOld() {
			BigDecimal i=new BigDecimal(1);
			BigDecimal result=new BigDecimal(1);
			
			
			Runnable timer=()->{
				try {				
					Thread.sleep(PowerThread.MAX_WAITING_TIME);
					this.interrupt();
					System.err.println("\nunable to Perform "+num+"^"+pow);
				} catch (InterruptedException e) {					
				}
			};
			Thread timerThread=new Thread(timer,"Timer:"+num+"^"+pow);
			timerThread.start();
			

			
		while(i.compareTo(pow)<=0) {
			if(this.isInterrupted()) return;
			result=result.multiply(num);
			i=i.add(new BigDecimal(1));
		}
		
		if(!isInterrupted())
		System.out.println(num+"^"+pow+"="+result);
		timerThread.interrupt();		
	}
	
@Override
	public void run() {
			BigDecimal i=new BigDecimal(1);
			BigDecimal result=new BigDecimal(1);

			
		while(i.compareTo(pow)<=0) {
			if(this.isInterrupted()) return;
			result=result.multiply(num);
			i=i.add(new BigDecimal(1));
		}
		
		if(!isInterrupted()) {
			this.result=result;
			System.out.println(num+"^"+pow+"="+result);	
		}
	}

public BigDecimal getResult() {
	return result;
}
	
	
	
}