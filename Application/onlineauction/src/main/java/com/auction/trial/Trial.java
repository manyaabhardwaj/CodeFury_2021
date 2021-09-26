package com.auction.trial;
import java.util.Calendar;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

public class Trial {
	
	public void timer(){
	System.out.println("Inside here");
	Calendar today = Calendar.getInstance();
	today.set(Calendar.HOUR_OF_DAY, 18);
	today.set(Calendar.MINUTE, 20);
	today.set(Calendar.SECOND, 0);

	Timer timer = new Timer();
	Trial obj = new Trial();
	
	timer.schedule(new com.auction.trial.BackgroundTask(), today.getTime(), TimeUnit.MILLISECONDS.convert(1, TimeUnit.MINUTES));
	}
}