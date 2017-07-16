package com.java.practice;

public class ServiceException {
public int callDao(){
	System.out.println("inside service");
	int i=4;
	try{
	 i=new DaoException().connect();
	System.out.println("connect is called" +i);
	}catch(Exception e){
		System.out.println("calght");
		throw new NullPointerException();
	}
	return 1;
}
}
