package com.java.exception;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
* However the overriding method should not throw checked exceptions that are
* new or broader than the ones declared by the overridden method
* 
*
*/
public class ExceptionOveriding extends Superclass{
//as for unchecked exception there is no issue
//can not reduce the visbility or narrow down
	/*private void method() throws RuntimeException {
	// TODO Auto-generated method stub
	super.method();
}
*/	//here we can not brod the exception
	/*public void method1() throws Exception {
		// TODO Auto-generated method stub
		super.method();
	}*/
	//here we can not throw new excpetion than super mentioned
	/*public void method1() throws FileNotFoundException,InterruptedException {
		// TODO Auto-generated method stub
		super.method();
	}*/
	
	//throw exception 
	/*@Override
		public void method2() throws IOException{
			// TODO Auto-generated method stub
			super.method2();
		}*/
}
