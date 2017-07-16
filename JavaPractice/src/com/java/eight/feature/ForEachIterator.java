package com.java.eight.feature;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ForEachIterator {
public static void main(String[] args) {
	//creating sample Collection
    List<Integer> myList = new ArrayList<Integer>();
    for(int i=0; i<10; i++) myList.add(i);
  //iterable for each called again and again till the last element
    //benefit of this default implementation is that can focus on business logic
    //t separate place resulting in higher separation of concern and cleaner code
    myList.forEach(new Consumer<Integer>() {
    	

		@Override
		public void accept(Integer t) {
		    System.out.println("forEach anonymous class Value::"+t);// TODO Auto-generated method stub
			
		}

		
	});
    //we can have default and static method in interface 1.8 onwards
    //iterable for each called again and again till the last element
    //benefit of this default implementation is that can focus on business logic
    //t separate place resulting in higher separation of concern and cleaner code
    myList.forEach((Integer i)->
    	System.out.println("string"));
   }
}
