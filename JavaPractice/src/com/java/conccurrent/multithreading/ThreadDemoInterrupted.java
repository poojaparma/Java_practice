package com.java.conccurrent.multithreading;

public class ThreadDemoInterrupted implements Runnable{

	   Thread t;

	   ThreadDemoInterrupted() {

	   t = new Thread(this);
	   System.out.println("Executing " + t.getName());
	   // this will call run() fucntion
	   t.start();
	        
	   // interrupt the threads
	   if (!t.interrupted()) {
		   System.out.println("interrupted called");
	   t.interrupt();
	   }
	   // block until other threads finish
	  /* try {  
	   t.join();
	   } catch(InterruptedException e) { System.out.println("interupt a join");}
	  
	   }*/
	   }

	   public void run() {
	   try {       
	   while (true) {
		   System.out.println("inside run ");
	 //  Thread.sleep(1000);
	   }
   } catch (Exception e) {
	   System.out.print(t.getName() + " interrupted:");
	  // System.out.println(e.toString());
	   }
	   }

	   public static void main(String args[]) {
	   new ThreadDemoInterrupted();
	 //  new ThreadDemoInterrupted();
	   }
}
