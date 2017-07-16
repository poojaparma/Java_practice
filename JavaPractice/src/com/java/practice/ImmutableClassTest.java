package com.java.practice;

import java.util.*;

public class ImmutableClassTest {

   public static void main(String[] args) {
	

    String localName=new String("rakesh"); //local
   
     List< String> localMap = new ArrayList<String>(); //local
     localMap.add("hello");
   
     EmployeeImuttable immutableClass = new EmployeeImuttable( localName, localMap);
    

     System.out.println("----Display ImmutableClass members before changing----");
     System.out.println(immutableClass.getPerson());  // "rakesh"
     System.out.println(immutableClass.getList());        // hello

     //Comparing ImmutableClass members with local before changing
     System.out.println(localName==immutableClass.getPerson());  //true
     System.out.println(localMap == immutableClass.getList());  //false

    
     //change local
     localName = new String("mittal");
     localMap.add( "ferarri");

     System.out.println("----Display ImmutableClass members before changing----");
     System.out.println(immutableClass.getPerson());  // "rakesh"
     System.out.println(immutableClass.getList());        // hello

     //Comparing ImmutableClass members with local before changing
     System.out.println(localName==immutableClass.getPerson());  //false
     System.out.println(localMap == immutableClass.getList());  //false

    
     System.out.println("\n----Display ImmutableClass members after changing----");
      }
}
