package com.test.data.strucuter;

import java.util.Iterator;
import java.util.Iterator;
public class LinkedList {
Node head=null;
Node tail=null;
Node currentNode=null;
int size=0;
//LinkedList l = new LinkedList();
public LinkedList(){
	 head = new Node(0);
	head.setNext(null);
}
public int Size(){
	while(currentNode!=null){
		size++;
	currentNode= currentNode.getNext();
	}
	return size;
}
//insertion challange 
//1.at beigining 
//2.at middlle
//3.at end
public void insertAtBeigining(int data){
	Node node =new Node(data);
	currentNode =node;
	node.setNext(head.getNext());
	head.setNext(node);
	
}public void insertAtLast(int data){
	Node node =new Node(data);
	node.setNext(null);
	tail.setNext(node);
	
}
public void insertAtMiddle(int data,int index){
	if(index==1){
		insertAtBeigining(data);
	}
	int count=1;
	while(!(count==index-1)){
	currentNode=	currentNode.getNext();
	
	}
	Node node = new Node(data);
	node.setNext(currentNode.getNext());
	currentNode.setNext(node);
	
}
//deletion challange 
//1.at first 
//2.at middlle
//3.at end
public void deleteFirstElement(){
	currentNode=head.getNext();
head.setNext(currentNode.getNext());
currentNode.setNext(null);
}
public void deleteEndElement(){
	currentNode=tail;
head.setNext(currentNode.getNext());
currentNode.setNext(null);
}
public void deleteMiddleElement(int data,int index){
	if(index==1){
		deleteFirstElement();
	}
	int count=index-1;
	while(!(count==index-1)){
	currentNode=	currentNode.getNext();
	
	}
	
	
	Node node=currentNode.getNext().getNext();
	currentNode.getNext().setNext(null);
	currentNode.setNext(node);
}
public String toString() {
  //need to implement iterator or List iterator .
	Iterator i = iterator();
if (! i.hasNext())
    return "[]";

StringBuilder sb = new StringBuilder();
sb.append('[');
for (;;) {
    Node e = (Node) i.next();
    sb.append(e);
    if (! i.hasNext())
	return sb.append(']').toString();
    sb.append(", ");
}

}
public Iterator<Node> iterator() {
	return new Myitr();
   }
//Private class for iterator 



private class Myitr implements Iterator<Node>{
	
	/**
	 * Index of element to be returned by subsequent call to next.
	 */
	int cursor = 0;

	@Override
	public boolean hasNext() {

		return cursor!=Size();
	}

	@Override
	public Node next() {
Node node=get(cursor);
cursor++;		
return node;
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}

}
public Node get(int cursor) {
	int count=0;
			currentNode=head;
	while(!(count==cursor)){
	currentNode=currentNode.getNext();
	
	}
	return currentNode;
	
}

}
