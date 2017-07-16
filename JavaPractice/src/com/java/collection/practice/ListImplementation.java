package com.java.collection.practice;

import java.util.ArrayList;

/**
 * This class will explain diference between different implementation of list as
 * well different frequent methods
 * 
 * this class covers following scenario of hashmap . 1. get and put internal
 * behavior . 2. hashcode and equals overridden impacts . 3. complexity of get
 * and put operations 4. rehashing process load factor 0.75. 5.
 *
 * 
 * @author rakerana
 *
 */
public class ListImplementation {
	static ArrayList list = new ArrayList();

	public static void main(String[] args) {
		list.add("hh");
		/*
		 * Quicksort has O(n log n) average and O(n^2) worst case performance,
		 * that is the best "average case" a sort algorithm can be, there are
		 * other sort algorithms that have this performance, but quicksort tends
		 * to perform better than most.
		 * 
		 * According to the Javadoc, only primitive arrays are sorted using
		 * Quicksort. Object arrays are sorted with a Mergesort as well. So
		 * Collections.sort seems to use the same sorting algorithm as
		 * Arrays.sort for Objects.
		 * 
		 * 
		 * The API guarantees a stable sorting which Quicksort doesn’t offer.
		 */
	}
}
