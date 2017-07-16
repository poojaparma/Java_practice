package com.practice.extenalize;

public class Employee {
private String status ;
private int code =0;
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public int getCode() {
	return code;
}
public void setCode(int code) {
	this.code = code;
}
public static void main(String[] args) {
	final Employee emp = new Employee();
	emp.setCode(0);
	emp.setStatus("sds");
	System.out.println(emp.getCode() + emp.getStatus());
emp.setCode(12);
emp.setStatus("sdsadsd");
System.out.println(emp.getCode() + emp.getStatus());
}
@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
}
