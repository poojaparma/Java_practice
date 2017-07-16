package com.java.conccurrent.multithreading;

import java.util.concurrent.Semaphore;

/**
 * semaphore permits specific no of threads others need to wait until lock is
 * release
 * 
 * Some Scenario where Semaphore can be used: 1) To implement better Database
 * connection pool which will block if no more connection is available instead
 * of failing and handover Connection as soon as its available.
 * 
 * 2) To put a bound on collection classes. by using semaphore you can implement
 * bounded collection whose bound is specified by counting semaphore.
 * 
 * 
 */
public class SemaphoreTest {

	Semaphore binary = new Semaphore(1);

	public static void main(String args[]) {
		final SemaphoreTest test = new SemaphoreTest();
		new Thread() {
			@Override
			public void run() {
				test.mutualExclusion();
			}
		}.start();

		new Thread() {
			@Override
			public void run() {
				test.mutualExclusion();
			}
		}.start();

	}

	private void mutualExclusion() {
		try {
			binary.acquire();

			// mutual exclusive region
			System.out.println(Thread.currentThread().getName() + " inside mutual exclusive region");
			Thread.sleep(1000);

		} catch (InterruptedException ie) {
			ie.printStackTrace();
		} finally {
			binary.release();
			System.out.println(Thread.currentThread().getName() + " outside of mutual exclusive region");
		}
	}

}
