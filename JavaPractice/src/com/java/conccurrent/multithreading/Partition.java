package com.java.conccurrent.multithreading;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


//4 partion
public class Partition {
	public static HashMap<String, Object> map;
	static ThreadPoolExecutor executor;
	static ThreadPoolExecutor executor1;
	private String name = null;

	Partition(String name) {
		this.name = name;
	}

	static {
		map = new HashMap<String, Object>();
		executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);

	}

	public static void main(String[] args) {
		Partition part1 = new Partition("part1");
		Partition part2 = new Partition("part2");
		Partition part3 = new Partition("part3");
		Partition part4 = new Partition("part4");

		List<Partition> partitionlist = new ArrayList<Partition>();
		List<Partition> partitionlist1 = new ArrayList<Partition>();

		partitionlist.add(part1);
		partitionlist.add(part2);
		partitionlist1.add(part3);
		partitionlist1.add(part4);
		final Producer consumerFirst = new Producer(partitionlist);
		final ProducerSecond consumerSecond = new ProducerSecond(partitionlist1);
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				int count = 0;
				// in real this loop will not be present
				while (count < 4) {
				//	System.out.println("executor submitted for: producer first and second notification number : " + count);
					// partion 1 and 2
				//to ensure multiple execution of execute method leads to complete seprate thread pool
					executor.execute(consumerFirst);

					/*// partion 3 and 4
					executor.execute(consumerSecond);*/
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					count++;
				}				
			}
		}).start();
		
	new Thread(new Runnable() {
			
			@Override
			public void run() {
				CyclicBarrier barrier = new CyclicBarrier(3);
				CyclicBarrier barrier1 = new CyclicBarrier(3);
				CyclicBarrier barrier2 = new CyclicBarrier(3);
				CyclicBarrier barrier3 = new CyclicBarrier(3);
				
				CountDownLatch latch = new CountDownLatch(3);
				CountDownLatch latch1 = new CountDownLatch(3);
				CountDownLatch latch2= new CountDownLatch(3);
				CountDownLatch latch3= new CountDownLatch(3);
				
				ConsumerThread consumer = new ConsumerThread((LinkedBlockingQueue<Notification>) map.get("part1"), barrier,latch);
				ConsumerThread consumer1 = new ConsumerThread((LinkedBlockingQueue<Notification>) map.get("part2"), barrier1,latch1);
				ConsumerThread consumer2 = new ConsumerThread((LinkedBlockingQueue<Notification>) map.get("part3"), barrier2,latch2);
				ConsumerThread consumer3 = new ConsumerThread((LinkedBlockingQueue<Notification>) map.get("part4"), barrier3,latch3);
				
				/*ThreadPoolExecutor executor1 = new ThreadPoolExecutor(3, 3, 10000, TimeUnit.MILLISECONDS,
						(LinkedBlockingQueue) map.get("part1"));
					executor1.execute(consumer);
				*/
			ExecutorService exc=	Executors.newFixedThreadPool(3);
			exc.execute(consumer);
			/*	ThreadPoolExecutor executor2 = new ThreadPoolExecutor(3, 3, 10000, TimeUnit.MILLISECONDS,
						(LinkedBlockingQueue) map.get("part2"));
				executor2.execute(consumer1);*/
				
			/*	ThreadPoolExecutor executor3 = new ThreadPoolExecutor(3, 3, 10000, TimeUnit.MILLISECONDS,
						(LinkedBlockingQueue) map.get("part3"));
				executor3.execute(consumer2);
				
				ThreadPoolExecutor executor4 = new ThreadPoolExecutor(3, 3, 10000, TimeUnit.MILLISECONDS,
						(LinkedBlockingQueue) map.get("part4"));
				executor4.execute(consumer3);
				*/
			}
		}).start();
	
		// three consumer thread for each

	}

	@Override
	public String toString() {
		return this.name;
	}
}
