package com.datastructure.list;

public class LinkList {
	Node currentNode=null;
Node head=null;
	public LinkList( ){
	this.head=new Node();
//this.currentNode=head;
}
public void add(int data,int index){
	if(index==0){
		insertAtBegining();
	}
	else {
		insert( index);
	}
}

private void insert(int index) {
Node node=new Node();
node.setData(23);
Node previousNode=null;
if(index==(this.size())-1){
	while(currentNode.next!=null){
		currentNode=currentNode.next;
			
		}
	node.next=null;
	currentNode.next=node;	
}else{
	int count=0;
	while(currentNode.next!=null){
		previousNode=currentNode;
		currentNode=currentNode.next;
			count ++;
			if(count-1==index){
			previousNode.next=node;
			node.next=currentNode;
				break;
			}
		}
}


}
private void insertAtBegining() {
	Node node = new Node();
	node.setData(12);
	node.setNext(null);
	head.setNext(node);
	currentNode=node;
}
public void remove(int index){
currentNode=head;
if(index==0){
removeAtBegining();
}	else{
while(currentNode.next!=null){
		currentNode=currentNode.next;
			
		}
}
}
private void removeAtBegining() {
	currentNode=currentNode.next;
	head.next=currentNode.next;
	currentNode.next=null;
}
public int size(){
	int count=0;
	currentNode=head;
	while(currentNode.next!=null){
		currentNode=currentNode.next;
			count++;
		}
	return count;
}
}
