package com.threads.practice;

import java.util.concurrent.LinkedBlockingQueue;

public class ThreadPool {
	private final LinkedBlockingQueue lbq;
	private final Thread[] workerThread;
	private  volatile boolean shutdown;
	
	public ThreadPool(int n){
		lbq=new LinkedBlockingQueue();
	workerThread=new Thread[n];
	for(int i=0 ;i<n;i++){
	workerThread[i]=new ThreadWorker("Thread: " + i+1);
	workerThread[i].start();
	}
	
	}
public void addTask(Runnable run){
	try {
		lbq.put(run);
    } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
    }
	}
public void shutdown()
{
    while (!lbq.isEmpty()) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            //interruption
        }
    }
    shutdown = true;
    /*for (Thread workerThread : workerThreads) {
        workerThread.interrupt();
    }*/
}

public class ThreadWorker extends Thread{
	public ThreadWorker(String name)
    {
        super(name);
    }
	public void run(){
		try {
		Runnable obj	=(Runnable) lbq.take();
		obj.run();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

}
