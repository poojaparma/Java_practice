package com.java.practice;

public class ObjaectReference {
	private int x =0;
private	String ss="hey";
public static void main(String[] args) {
	ObjaectReference pnt1 = new ObjaectReference();
	ObjaectReference pnt2 = new ObjaectReference();
	
	/*String name="hellossds";
	String name1 = new String("ds");
	ob.createString(name);
	System.out.println("print: "+ name);
ob.createString(name1);
System.out.println("print: "+ name1);*/
	/*ObjaectReference ob = new ObjaectReference();
	boolean name=false;
	Boolean name1 = new Boolean(false);
	ob.createString(name);
	System.out.println("print: "+ name);
ob.createString(name1);
System.out.println("print: "+ name1);*/
	System.out.println("X: " + pnt1.x + " Y: " +pnt1.ss); 
	  System.out.println("X: " + pnt2.x + " Y: " +pnt2.ss);
	  System.out.println(" ");
	  tricky(pnt1,pnt2);
	  System.out.println("X: " + pnt1.x + " Y:" + pnt1.ss); 
	  System.out.println("X: " + pnt2.x + " Y: " +pnt2.ss); 
}
boolean createString(Boolean s){
return s=true;
}
String createString(String s){
return s="hello";
}
public static void tricky(ObjaectReference arg1, ObjaectReference arg2)
{
  arg1.x = 100;
  arg1.ss = "changed";
  ObjaectReference temp = arg1;
  arg1 = arg2;
  arg2 = temp;
arg2.x =101;
arg2.ss="hi";
arg1.x =103;
arg1.ss="hi3";
}
}
