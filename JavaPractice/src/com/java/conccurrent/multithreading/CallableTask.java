package com.java.conccurrent.multithreading;

import java.util.concurrent.Callable;

public class CallableTask implements Callable<String>{
private String name;
	public  CallableTask(String string) {
this.name=string;
}
	@Override
	public String call() throws InterruptedException  {
System.out.println("callable called: " + name);
try {
	Thread.sleep(1000);
} catch (InterruptedException e) {
	e.printStackTrace();
	throw new InterruptedException();
}
		return "sdsdsdsd";
	}

}
