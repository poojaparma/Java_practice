package com.datastructure.list;

import java.util.ArrayList;

public class Test {
public static void main(String[] args) {
	Object obj= new Object();
if(obj instanceof Object){
	System.out.println("msggggggggg");
}
	/*
	
	
	int count=0;
	String[] str= {"hello0","hello1","hello2","hello3","hello4","hello5","hello6"};
	ArrayList ar= new ArrayList(str.length);
	int[]  ii = {1,3,6};
		for(int i=0;i<str.length;i++){
			boolean ispresent =false;
			for(int j:ii){
if(i==j){
	ispresent=true;		
	
	break;
}
count++;
}
			if(!ispresent)
			ar.add(str[i]);
	}
	//for(int i=0;i<str.length;i++){
	System.out.println("string ..: " + ar+ count);
//	}
	boolean isHello=true;
	 boolean isTello=false;
	 Test test= new Test();
	 System.out.println("hello");
	if((isHello=test.isHello()) && (isTello=test.isTello())){
		System.out.println("left to right ");
	}
	if( (isTello=test.isTello())&&(isHello=test.isHello() )){
		System.out.println("right to left");
	}
*/}

public boolean isHello(){
	return false;
}
public boolean isTello(){
	return true;
}


}
