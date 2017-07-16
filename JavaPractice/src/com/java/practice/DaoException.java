package com.java.practice;


public class DaoException {
public int connect(){
	System.out.println("exception occured");
	{
	throw new NullPointerException("hi in connect");
	}
}
}
