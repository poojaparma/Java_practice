package com.java.collection.practice;

import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


/**
 * this class covers following scenario of hashmap . 1. get and put internal
 * behavior . 2. hashcode and equals overridden impacts . 3. complexity of get
 * and put operations 4. rehashing process load factor 0.75. 5.
 *
 */
public class HashMapImpl {
	public static void main(String[] args) {
		HashMap<Employee, Object> hashmap = new HashMap<Employee, Object>();
		/**
		 * key is passed to get then hashCode method on the key object and
		 * applies returned hashValue to its own static hash function to find a
		 * bucket location(backing array) where keys and values are stored in
		 * form of a nested class called Entry (Map.Entry) .
		 * 
		 * 
		 * a. Using key.hashCode() [ see above step 4],determine initial
		 * hashvalue for the key
		 * 
		 * b. Pass intial hashvalue as hashValue in hash(hashValue) function, to
		 * calculate the final hashvalue.
		 * 
		 * c. Final hash value is then passed as a first parameter in the
		 * indexFor(int ,int )method . The second parameter is length which is a
		 * constant in HashMap Java Api , represented by
		 * DEFAULT_INITIAL_CAPACITY
		 * 
		 * The default value of DEFAULT_INITIAL_CAPACITY is 16 in HashMap Java
		 * Api .
		 * 
		 * indexFor(int,int) method returns the first entry in the appropriate
		 * bucket. The linked list in the bucket is then iterated over - (the
		 * end is found and the element is added or the key is matched and the
		 * value is returned )
		 * 
		 * The above function indexFor() works because Java HashMaps always have
		 * a capacity, i.e. number of buckets, as a power of 2.
		 * 
		 * The above function indexFor() works because Java HashMaps always have
		 * a capacity, i.e. number of buckets, as a power of 2. Let's work with
		 * a capacity of 256,which is 0x100, but it could work with any power of
		 * 2. Subtracting 1 from a power of 2 yields the exact bit mask needed
		 * to bitwise-and with the hash to get the proper bucket index, of range
		 * 0 to length - 1. 256 - 1 = 255 0x100 - 0x1 = 0xFF E.g. a hash of 257
		 * (0x101) gets bitwise-anded with 0xFF to yield a bucket number of 1.
		 */
		hashmap.get("");
		// return null if no mapping found null retruns or previous element
		Employee emp = new Employee(2, "emp");
		hashmap.put(emp, "emp");
		System.out.println("print at first entry: " + hashmap + "get: " + hashmap.get(emp));
		Employee emp1 = new Employee(4, "ds");
		hashmap.put(emp1, "emp1");
		System.out.println("print at second entry: " + hashmap + "get: " + hashmap.get(emp1));
		Employee emp2 = new Employee(3, "ssss");
		hashmap.put(emp2, "emp2");
		System.out.println("print at third entry: " + hashmap + "get: " + hashmap.get(emp2));
		Employee emp3 = new Employee(4, "ssss");
		hashmap.put(emp3, "emp3");
		System.out.println("print at fourth entry: " + hashmap + "get: " + hashmap.get(emp1));
		System.out.println("print at fourth entry: " + hashmap + "get: " + hashmap.get(emp3));
		
		//Collections.sort(hashmap);
		

		/*
		 * System.out.println("print at fourth entry: " + hashmap);
		 * System.out.println("print hascode1: " + emp.hashCode());
		 * System.out.println("print hascode2: " + emp1.hashCode());
		 * System.out.println("print hasmap:  " + hashmap);
		 */ /*
			 * Collections.sort(null); Arrays.sort(new int[0]);
			 */
		/**
		 * comparable and comparator : . Objects which implement Comparable in
		 * Java can be used as keys in a SortedMap like treemap or elements in a
		 * SortedSet for example TreeSet, without specifying any Comparator.
		 * 
		 * 
		 * 
		 */
		// http://javahungry.blogspot.com/2013/08/hashing-how-hash-map-works-in-java-or.html
		Hashtable table = new Hashtable();
		// dows not permit null value and null key
		// table.put(new Employee(4, "xx"), null);

		/*
		 * The hashmap implementation provides constant time performance for
		 * (get and put) basic operations i.e the complexity of get() and put()
		 * is O(1) , assuming the hash function disperses the elements properly
		 * among the buckets.
		 */
		// create a synchronized map
		// It is imperative that the user manually synchronize on the returned
		// map when iterating over any of its collection views:

		Map m = Collections.synchronizedMap(new HashMap());
		Set s = m.keySet(); // Needn't be in synchronized block
		synchronized (m) { // Synchronizing on m, not s!
			Iterator i = s.iterator(); // Must be in synchronized block
			while (i.hasNext()) {

			}
			// foo(i.next());
		}

		// Failure to follow this advice may result in non-deterministic
		// behavior.
		Map<Employee, Object> syncMap = Collections.synchronizedMap(hashmap);
	}
}

/**
 * Employee is a key . should overide hashcode : to store entity object in
 * particular index in bucket bucket is linked list for hash map to store key
 * value pair .
 * 
 * @author rakerana
 *
 */

class Employee implements Comparable<Employee> {
	private Integer id;
	private String department;

	public Employee(int id, String dept) {
		this.id = id;
		this.department = dept;

	}

	/**
	 * As much as is reasonably practical, the hashCode method defined by*class
	 * 
	 * {@code Object}does return
	 * 
	 * distinct integers for distinct*objects.( This is typically implemented by
	 * converting the internal* address of the object into an integer,but this
	 * implementation* technique is not required by the*Java&trade; programming
	 * language.)
	 **/
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	};

	/*
	 * Override only hashCode
	 * 
	 * Imagine you have this
	 * 
	 * MyClass first = new MyClass("a","first"); MyClass second = new
	 * MyClass("a","second"); If you only override hashCode then when you call
	 * myMap.put(first,someValue) it takes first, calculates its hashCode and
	 * stores it in a given bucket. Then when you call
	 * myMap.put(second,someOtherValue) it should replace first with second as
	 * per the Map Documentation because they are equal (according to our
	 * definition).
	 * 
	 * But the problem is that equals was not redefined, so when the map hashes
	 * second and iterates through the bucket looking if there is an object k
	 * such that second.equals(k) is true it won't find any as
	 * second.equals(first) will be false.
	 * 
	 * Override only equals
	 * 
	 * If only equals is overriden, then when you call
	 * myMap.put(first,someValue) first will hash to some bucket and when you
	 * call myMap.put(second,someOtherValue) it will hash to some other bucket
	 * (as they have a different hashCode). So, although they are equal, as they
	 * don't hash to the same bucket, the map can't realize it and both of them
	 * stay in the map.
	 */
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return this.id.equals(((Employee) obj).id);
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int compareTo(Employee employee) {
		if (this.id == employee.id) {
			return 0;
		} else if (this.id > employee.id) {
			return 1;
		} else {
			return -1;
		}
	}
}
