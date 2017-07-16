package com.java.concurrent.api;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * this class covers following scenario of consurrenthashmap . 1. get and put
 * internal behavior . 2. hashcode and equals overridden impacts . 3. complexity
 * of get and put operations 4. rehashing process load factor 0.75. 5.
 *
 */
public class ConcurrentHashMapImpl {
	/*
	 * ConcurrentHashMap synchronizes or locks on the certain portion of the Map
	 * . To optimize the performance of ConcurrentHashMap , Map is divided into
	 * different partitions depending upon the Concurrency level . So that we do
	 * not need to synchronize the whole Map Object.
	 * 
	 * 
	 * 3. Null Key
	 * 
	 * 
	 * ConcurrentHashMap does not allow NULL values . So the key can not be null
	 * in ConcurrentHashMap .While In HashMap there can only be one null key .
	 */
	public static void main(String[] args) {
		/*
		 * synchronizedHashMap is more faster than HashTable because in
		 * HashTable lock is on the object level (i.e HashTable itself) while in
		 * synchronizedHashMap the lock is at the bucket level, which improves
		 * performance.
		 * 
		 * Secondly, When you come to make a choice between a
		 * synchronizedHashMap and concurrentMap; go for concurrentMap, it
		 * offers better performance.
		 */
		// Collections.synchronizedCollection();
		/**
		 * It is not mandatory that abstract class should have atleast one
		 * abstract function
		 * 
		 * Cant mark class as abstract and final both ....both have opposite
		 * meaning
		 */
		/*
		 * . Clone() method copy technique: Both HashSet and TreeSet uses
		 * shallow copy technique to create a clone of their objects
		 */
		HashSet<String> s = new HashSet<String>();
		// shallow cloning means: if any happens in original object will reflect
		// in clone object also
		s.clone();
		/*
		 * Fail-fast iterator can throw ConcurrentModificationException in two
		 * scenarios :
		 * 
		 * 
		 * 
		 * difference between fail fast iterator and fail safe iterator Single
		 * Threaded Environment
		 * 
		 * After the creation of the iterator , structure is modified at any
		 * time by any method other than iterator's own remove method.
		 * 
		 * Multiple Threaded Environment
		 * 
		 * If one thread is modifying the structure of the collection while
		 * other thread is iterating over it .
		 */
		List<String> list = new ArrayList<String>();
		list.add("st");
		list.add("at");
		list.add("dt");
		list.add("ct");
		Iterator it = list.iterator();
		list.remove(3);
		while (it.hasNext()) {
			it.next();
		}
		ConcurrentHashMap conc = new ConcurrentHashMap();
conc.keySet().iterator();
ConcurrentHashMap<String,String> premiumPhone = 
new ConcurrentHashMap<String,String>();
premiumPhone.put("Apple", "iPhone");
premiumPhone.put("HTC", "HTC one");
premiumPhone.put("Samsung","S5");

Iterator iterator = premiumPhone.keySet().iterator();

while (iterator.hasNext())
{
System.out.println(premiumPhone.get(iterator.next()));
premiumPhone.put("Sony", "Xperia Z");
}

}

	/*
	 * Fail Safe Iterator makes copy of the internal data structure (object
	 * array) and iterates over the copied data structure.Any structural
	 * modification done to the iterator affects the copied data structure. So ,
	 * original data structure remains structurally unchanged .Hence , no
	 * ConcurrentModificationException throws by the fail safe iterator.
	 * 
	 * Two issues associated with Fail Safe Iterator are :
	 * 
	 * 1. Overhead of maintaining the copied data structure i.e memory.
	 * 
	 * 2. Fail safe iterator does not guarantee that the data being read is the
	 * data currently in the original data structure.
	 */
	/*ConcurrentHashMap

	You should use ConcurrentHashMap when you need very high concurrency in your project.
	It is thread safe without synchronizing the whole map.
	Reads can happen very fast while write is done with a lock.
	There is no locking at the object level.
	The locking is at a much finer granularity at a hashmap bucket level.
	ConcurrentHashMap doesn’t throw a ConcurrentModificationException if one thread tries to modify it while another is iterating over it.
	ConcurrentHashMap uses multitude of locks.*/
}
