package com.test.data.strucuter;

public class LinkedListTesting {
public static void main(String[] args) {
	LinkedList tl= new LinkedList();
for(int i=0;i<7;i++){
tl.insertAtBeigining(i);
//System.out.println("linked list: " +tl);
}
tl.insertAtMiddle(3, 3);
System.out.println("inserting middle: "+tl);
tl.deleteEndElement();
System.out.println("till.." + tl);


}
}
