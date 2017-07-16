package com.datastructure.list;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class A {
int a = 0;
int b=10;
public A(int a,int b){
	this.a=a;
this.b=b;
}
public A(){
	a=9;
}
}

class B extends A implements Serializable {
	private static final long serialVersionUID = 1L;  
int c=1;
B(int a,int b,int c ){
	super(a,b);
	this.c=c;
}
}


public class Test1 {

/**
* @param args
*/
public static void main(String[] args) {
// TODO Auto-generated method stub
B b = new B(4,5,6);
B b1;
A a1;
try{
FileOutputStream f = new FileOutputStream("emp.ser");
ObjectOutputStream obj = new ObjectOutputStream(f);
obj.writeObject(b);
System.out.println("Object is serialized ");

}catch(Exception e){
e.printStackTrace();
}

try{
FileInputStream f1= new FileInputStream("emp.ser");
ObjectInputStream obj1 = new ObjectInputStream(f1);
b1 = (B)obj1.readObject();
a1=b1;
System.out.println("new object values : " + b1.c);
System.out.println("new object values : " + b1.a);
System.out.println("new object values : " + a1.b);

}catch (Exception e){
e.printStackTrace();
}
}
}