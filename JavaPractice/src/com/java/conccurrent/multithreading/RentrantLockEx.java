package com.java.conccurrent.multithreading;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Lock this is base interfac for lock api Condition ReadWriteLock ReentrantLock
 * 1. thread wait for specific peroid for lock . 2. if farinesss is set to true
 * then longest waiting thread will be getting lock 3.try catch make code dirty
 * 4. we can create different condtions and different threads can wait for
 * different condition
 * 
 *
 */
public class RentrantLockEx implements Runnable {
	public static void main(String[] args) {
		Lock l = new ReentrantLock();
		/**
		 * If the lock is not available then the current thread becomes disabled
		 * for thread scheduling purposes and lies dormant until the lock has
		 * been acquired. A {@code Lock} implementation may be able to detect
		 * erroneous use of the lock, such as an invocation that would cause
		 * deadlock, and may throw an (unchecked) exception in such
		 * circumstances.
		 */
		// l.lock();

		// Acquires the lock unless the current thread is
		try {
			if (l.tryLock(10, TimeUnit.SECONDS))
				l.lockInterruptibly();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		 * e that, I am using tryLock() method to make sure my thread waits only
		 * for definite time and if it’s not getting the lock on object, it’s
		 * just logging and exiting. Another important point to note is the use
		 * of try-finally block to make sure lock is released even if
		 * doSomething() method call throws any exception.
		 */
		finally {
			l.unlock();
		}
		/*
		 * Condition: Condition objects are similar to Object wait-notify model
		 * with additional feature to create different sets of wait. A Condition
		 * object is always created by Lock object. Some of the important
		 * methods are await() that is similar to wait() and signal(),
		 * signalAll() that is similar to notify() and notifyAll() methods.
		 */
		l.newCondition();
		// ReadWriteLock l;
		// read write lock maintains pair of lock : 1 for read only and one or
		// write only
		// read lock may be held simultanoeusly by multiple readeras long as no
		// write thread

		/**
		 * .Multiple Threads can acquire multiple read Locks, but only a single
		 * Thread can acquire mutually-exclusive write Lock .Other threads
		 * requesting readLocks have to wait till the write Lock is released A
		 * thread is allowed to degrade from write lock to read lock but not
		 * vice-versa Allowing a read thread to upgrade would lead to a deadlock
		 * as more than one thread can try to upgrade its lock. The
		 * ReentrantReadWriteLock also supports all the features of the
		 * Reentrant lock like providing fair mechanism ,reentrantLocks,
		 * Condition Support (on a write Lock only), allowing interruption on
		 * read as well as write Locks.
		 */
		ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
		 readlock=readWriteLock.readLock();
		 writeLock=readWriteLock.writeLock();
		
     //  System.out.println("Printing the First Element : "+threadSafeArrayList.get(1))
	}
	static Lock readlock;
	static Lock writeLock;

	public <E> void set(E o)
	{
		writeLock.lock();
		try
		{
			//list.add(o);
			System.out.println("Adding element by thread"+Thread.currentThread().getName());
	        }
		finally
		{
			writeLock.unlock();
		}
	}
	
	public <E> E get(int i)
	{
		readlock.lock();
		try
		{
                        System.out.println("Printing elements by thread"+Thread.currentThread().getName());
			return null;//list.get(i);
		}
		finally
		{
			readlock.unlock();
		}
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub

	}
}
