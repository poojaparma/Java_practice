package com.java.practice;

public class TestException {
public static void main(String[] args) {
String s ="sdsdsdsd_%s";
Integer  i =new Integer("22");
System.out.println("sdsdsd"+i.toString());

System.out.println("String:  " + String.format(s, i));
	//	callService();
	
}

private static int callService() {
	// TODO Auto-generated method stub
ServiceException ser= new ServiceException();
int i=5;
try{
 i=ser.callDao();
System.out.println("inside Test");	
}catch(	Exception e){
System.out.println(i);}
return 0;
}
}
