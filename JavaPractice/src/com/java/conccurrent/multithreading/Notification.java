package com.java.conccurrent.multithreading;

public class Notification /*implements Runnable*/{
	volatile static int count ;
private int offset;
private String message;
private int part_id;
public int getOffset() {
	return offset;
}
public void setOffset(int offset) {
	this.offset = offset;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public int getPart_id() {
	return part_id;
}
public void setPart_id(int part_id) {
	this.part_id = part_id;
}
//@Override
public void run() {
	System.out.println("start deque: " + message+offset+ " "+Thread.currentThread().getId() + " " +Thread.currentThread().getName());
	// TODO Auto-generated method stub
	
}
}
