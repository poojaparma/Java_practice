package com.java.practice;

import java.util.ArrayList;
import java.util.List;
//If the instance fields include references to mutable objects, don't allow those objects to be changed:

//Don't provide methods that modify the mutable objects.
//Don't share references to the mutable objects. Never store references to external,
//mutable objects passed to the constructor; if necessary, create copies, and store references to the copies. 
//Similarly,
//create copies of your internal mutable objects when necessary to avoid returning the originals in your methods
public class EmployeeImuttable {
	/** 5b) String is immutable class,
     *     any changes made to Sting object produces new String object.
     *     so return reference variable of String.
     */
	private final String person;
	 /** 5c) HashMap is mutable class,
     *     any changes made to HashMap object won't produce new HashMap object.
     *     so return copy/clone of object, not reference variable of HashMap.*/
private final List<String> list;

public EmployeeImuttable (String person ,List<String> list){
	this.person=person;
	this.list=list;
}

public String getPerson() {
	return person;
}
/** 5c) HashMap is mutable class,
 *     any changes made to HashMap object won't produce new HashMap object.
 *     so return copy/clone of object, not reference variable of HashMap.*/
public List<String> getList() {
	return new ArrayList<String>(list);
}
}
