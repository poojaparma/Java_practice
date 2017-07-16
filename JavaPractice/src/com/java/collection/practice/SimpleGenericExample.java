package com.java.collection.practice;

/**
 * 
 * Generic T,or K parmaeter are being is used where generic with some particular
 * type passed
 * e.g : T will be replcaed by any type .
 * where T also extends object so if we right Object instead of T then type casting happens but here it is replcing 
 *
 *
 *
 * @param <T>
 */
public class SimpleGenericExample<T> {
	private T object = null;

	// constructor to accept type parameter T
	public SimpleGenericExample(T param) {
		this.object = param;
	}

	public T getobject() {
		return this.object;
	}

	// this method prints the holding parameter type
	public void printType() {
		System.out.println("Type: " + object.getClass().getName());
	}

public static void main(String[] args) {
	SimpleGenericExample<String> simpleGeneric = new SimpleGenericExample<String>("print");
	simpleGeneric.printType();
	SimpleGenericExample<Boolean> booleanGeneric = new SimpleGenericExample<>(Boolean.TRUE);
	System.out.println("print: "+booleanGeneric.getobject());
}
}
