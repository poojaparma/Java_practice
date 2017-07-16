package com.java.exception;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Superclass {
 void method() throws NullPointerException{
	System.err.println("method...........");
}
public void method1() throws FileNotFoundException{
	System.err.println("method1...........");
}
public void method2() {
	System.err.println("method2...........");
}
}
