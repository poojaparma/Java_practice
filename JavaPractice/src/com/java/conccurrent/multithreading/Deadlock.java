package com.java.conccurrent.multithreading;

public class Deadlock {
public static void main(String[] args) {
	Thread t1= new Thread(new ThreadExample());
	t1.start();
	
	//t1.interrupt();
}


}

class ThreadExample implements Runnable {

	@Override
	public void run() {
		//DeadlockScenario dc = new DeadlockScenario();
	//	dc.getDeadlock();
		throw new RuntimeException();
	}

}