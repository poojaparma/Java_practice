package com.java.conccurrent.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class Producer implements Runnable {
	List<Partition> partionList = new ArrayList<Partition>();
	private LinkedBlockingQueue link1;
	private LinkedBlockingQueue link2;

	private volatile static int count=0;

	public Producer(List<Partition> partitionlist) {
		this.partionList = partitionlist;
		link1 = new LinkedBlockingQueue<Runnable>();
		Partition.map.put("part1", link1);
		link2 = new LinkedBlockingQueue<Runnable>();
		Partition.map.put("part2", link2);

	}

	@Override
	public void run() {
		// thread for every notification
		// partion detail should be passed from kafka
		for (Partition part : partionList) {
			
			Notification notify = new Notification();
			notify.setPart_id(count);
			notify.setMessage(part.toString());
			notify.setOffset(count);

			if (part.toString().equals("part1")) {
				System.out.println("started enqeue data for partition link1 :" + "count  "+ ++count);
				link1.offer(notify);
			}
			/*if (part.toString().equals("part2")) {
				System.out.println("started enqeue data for partition link2 :" + part+ "count "+ ++count );
				link2.offer(notify);
			}*/

		}
	}
}