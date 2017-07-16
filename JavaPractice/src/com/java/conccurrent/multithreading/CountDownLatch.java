package com.java.conccurrent.multithreading;

/**
 * This is useful when you want one or more threads to wait until a set of
 * operations being performed in other threads completes ets take a case here;
 * sometimes you want to start multiple threads at the same time in parallel to
 * main thread and once all the threads complete, you have to perform some
 * actions on your main thread. This can be done easily if we create a
 * CountDownLatch.
 * 
 * Any thread, usually main thread of application, which calls
 * CountDownLatch.await() will wait until count reaches zero or its interrupted
 * by another thread
 * 
 * @author rakerana
 *
 */
public class CountDownLatch {
	/*
	 * As soon as count reaches zero, Thread awaiting starts running. One of the
	 * disadvantages/advantages of CountDownLatch is that its not reusable once
	 * count reaches to zero you can not use CountDownLatch any more.
	 * 
	 * edit:
	 * 
	 * Use CountDownLatch when one thread like main thread, requires to wait for
	 * one or more thread to complete, before it can start processing.
	 * 
	 * Classical example of using CountDownLatch in Java is any server side core
	 * Java application which uses services architecture, where multiple
	 * services are provided by multiple threads and application can not start
	 * processing until all services have started successfully.
	 */
	public static void main(String[] args) {
		java.util.concurrent.CountDownLatch _latch = new java.util.concurrent.CountDownLatch(10);
		for (int i = 0; i < 10; i++) {
			new Thread(new MyWorker(_latch)).start();
		}
		try {
			_latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("*** Main Thread in Action ***");
	}
}
class MyWorker implements Runnable {
	private java.util.concurrent.CountDownLatch _latch = null;

	public MyWorker(java.util.concurrent.CountDownLatch _latch) {
		this._latch = _latch;
	}

	@Override
	public void run() {
System.out.println("inside run of worker thread");
_latch.countDown();
	}
}
