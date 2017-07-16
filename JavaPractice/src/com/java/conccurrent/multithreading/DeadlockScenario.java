package com.java.conccurrent.multithreading;

public class DeadlockScenario {
	int i=0;
public void getDeadlock(){
	
	synchronized (this) {
		i++;
		System.out.println("first block");
		deadlockNested();
	}
}

private synchronized void deadlockNested() {
	i++;
	System.out.println("second block");
	if(i==150||i==151){
		return;
	}
	getDeadlock();	
}
}
