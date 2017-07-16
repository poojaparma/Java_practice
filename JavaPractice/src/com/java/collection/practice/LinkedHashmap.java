package com.java.collection.practice;

import java.util.LinkedHashMap;

public class LinkedHashmap {
	// it extends hashap entry class and add before and after pointer to make
	// doubley liked list
	// it maintains order as per instertion by default also maintains access
	// order
	static LinkedHashMap<String, String> link = new LinkedHashMap<String, String>();

	public static void main(String[] args) {
		// link.put("", value)
		/*
		 * First and foremost difference between LinkedHashMap and HashMap is
		 * order, HashMap doesn't maintain any order while LinkedHashMap
		 * maintains insertion order of elements in Java.
		 * 
		 * 
		 * 2) LinkedHashMap also requires more memory than HashMap because of
		 * this ordering feature. As I said before LinkedHashMap uses doubly
		 * LinkedList to keep order of elements.
		 * 
		 * 
		 * 3) LinkedHashMap actually extends HashMap and implements Map
		 * interface.
		 * 
		 * Read more:
		 * http://java67.blogspot.com/2012/08/difference-between-hashmap-and-
		 * LinkedHashMap-Java.html#ixzz3yhdJeRFK
		 */
		/*2) Re-entering a mapping, doesn't alter insertion order of LinkedHashMap. For example, if you already have mapping for a key, and want to update it's value by calling put(key, newValue), insertion order of LinkedHashMap will remain same.


	3) Access order is affected by calling get(key), put(key, value) or putAll(). When a particular entry is accessed, it moves towards end of the doubly linked list, maintained by LinkedHashMap.


	4) LinkedHashMap can be used to create LRU cache in Java. Since in LRU or Least Recently Used Cache, oldest non accessed entry is removed, which is the head of the doubly linked list maintained by LinkedHashMap.

	Read more: http://java67.blogspot.com/2012/08/difference-between-hashmap-and-LinkedHashMap-Java.html#ixzz3yheHzUhd	
*/	}
}
