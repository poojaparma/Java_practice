package com.java.eight.feature;
@FunctionalInterface
public interface RetryService<T> {
	T noOfTries();
	default void log(){
		System.out.println("int logging...........");
	}
}
