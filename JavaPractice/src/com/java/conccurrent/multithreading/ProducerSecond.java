package com.java.conccurrent.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerSecond implements Runnable {
	List<Partition> partionList = new ArrayList<Partition>();

	private LinkedBlockingQueue link3;
	private LinkedBlockingQueue link4;
	private static volatile int count;

	public ProducerSecond(List<Partition> partitionlist) {
		this.partionList = partitionlist;

		link3 = new LinkedBlockingQueue<Runnable>();
		Partition.map.put("part3", link3);
		link4 = new LinkedBlockingQueue<Runnable>();
		Partition.map.put("part4", link4);
	}

	@Override
	public void run() {
		// thread for every notification
		for (Partition part : partionList) {
			Notification notify = new Notification();
			notify.setPart_id(count);
			notify.setMessage(part.toString());
			notify.setOffset(count);
			if (part.toString().equals("part3")) {
				System.out.println("started enqeue data for second producer link3:" + " count:  "+ ++count);
				link3.offer(notify);
			} else {
				System.out.println("started enqeue data for second producer link 4:" + " count " + ++count);
				link4.offer(notify);
			}
		
		}

	}

}
