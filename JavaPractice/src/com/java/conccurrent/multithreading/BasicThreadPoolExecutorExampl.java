package com.java.conccurrent.multithreading;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class Task implements Runnable {

	private String name;

	public Task(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public void run() {
		 try {
		Long duration = (long) (Math.random() * 10);
		System.out.println("Doing a task during : " + name);
			System.out.println("Doing a task during : " + name);
			System.out.println("Doing a task loop : " + name);
		 TimeUnit.SECONDS.sleep(duration);
	} 
		  catch (InterruptedException e) { e.printStackTrace(); }
		 
	 }

}

public class BasicThreadPoolExecutorExampl {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// Use the executor created by the newCachedThreadPool() method
		// only when you have a reasonable number of threads
		// or when they have a short duration.
		// this pool creates thread when new request comes ,re-use the pooled
		// threads,also termaintes the htread whihc are ideal for 60 sec .
		
		// is there ny linit for maximu threads ?
		
		// ThreadPoolExecutor executor = (ThreadPoolExecutor)
		// Executors.newCachedThreadPool();

		// executor provides fixed pool other threads will wait in unbounded
		// queue
		// If any thread terminates due to a failure during execution prior to
		// shutdown, a new one will take its place if needed to execute
		// subsequent tasks
		
		//
		ExecutorService executor = Executors.newFixedThreadPool(5);
		

		while (!executor.isTerminated()) {
		}
		System.out.println("Finished all threads");

		for (int i = 0; i <= 5; i++) {
			Task task = new Task("Task " + i);
			System.out.println("A new task has been added : " + task.getName());
			//executor.execute(task);
			//runnable wil give 
			Future/*<List<?>>*/ future=executor.submit(task);
			
		//	Future/*<List<?>>*/ futureCallable= executor.submit(new CallableTask("task: " + i));
		
		
			/*	System.out.println("future runnable: " + future.get());
			System.out.println("future callable: " + futureCallable.get());*/
		}
		/*
		 * shutdownNow(): This method shut downs the executor immediately. It
		 * doesn’t execute the pending tasks. It returns a list with all these
		 * pending tasks. The tasks that are running when you call this method
		 * continue with their execution, but the method doesn’t wait for their
		 * finalization.
		 * 
		 * isTerminated(): This method returns true if you have called the
		 * shutdown() or shutdownNow() methods and the executor finishes the
		 * process of shutting it down. isShutdown(): This method returns true
		 * if you have called the shutdown() method of the executor.
		 * 
		 * awaitTermination(longtimeout,TimeUnitunit): This method blocks the
		 * calling thread until the tasks of the executor have ended or the
		 * timeout occurs. The TimeUnit class is an enumeration with the
		 * following constants: DAYS, HOURS, MICROSECONDS etc.
		 */

		// this method try to stop active threads using interrupt only,
		executor.shutdownNow();
		// this method will not entertain any new task i that case it will throw
		// rejectedexecuton exception
		//
		executor.shutdown();
	}
	class RejectedExecutionHandlerImpl implements RejectedExecutionHandler {
		 
	    @Override
	    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
	        System.out.println(r.toString() + " is rejected");
	    }
}
}