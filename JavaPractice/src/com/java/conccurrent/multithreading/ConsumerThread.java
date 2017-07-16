package com.java.conccurrent.multithreading;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

// particular thread should read from particular queue only 3 thread from 1 queue
public class ConsumerThread implements Runnable {
	private LinkedBlockingQueue linkedBlockingQueue;
	private CyclicBarrier barrier;
	private CountDownLatch latch;
	static volatile int count=1;

	public ConsumerThread(LinkedBlockingQueue<Notification> object, CyclicBarrier barrier,CountDownLatch latch) {
		this.linkedBlockingQueue = object;
		this.barrier = barrier;
		this.latch = latch;
	}

	@Override
	public void run() {
		System.out.println("start deque: " + linkedBlockingQueue.size()+ " "+Thread.currentThread().getId() + " " +Thread.currentThread().getName());
		System.out.println("count : " + count);
		System.out.println("    ");
		try {
			linkedBlockingQueue.take();
		//	latch.countDown();
		//	barrier.await(5000,TimeUnit.MILLISECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}/* catch (BrokenBarrierException e) {
		System.out.println("baarier broken exception");
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TimeoutException e) {
			System.out.println("timout occured");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

}
