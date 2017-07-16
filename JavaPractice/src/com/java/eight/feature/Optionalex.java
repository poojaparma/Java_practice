package com.java.eight.feature;

import java.util.NoSuchElementException;
import java.util.Optional;

public class Optionalex {
public static void main(String[] args) {
	try
    {
      String str="add";
      
		/* empty */
        Optional emptyOptional = Optional.empty();
   //    /* System.out.println(*/ emptyOptional.get() /*)*/;
       Optional nonEmptyOptional = Optional.of( str );
       System.out.println( nonEmptyOptional.get() );
      //replace value
        nonEmptyOptional =nonEmptyOptional.of("s");
       System.out.println( nonEmptyOptional.get() );
      
       //give value
    //gives null pointer
      // nonEmptyOptional.of(null);
       
       String strNull = null;
     
       Optional nullableOptional = Optional.ofNullable( strNull );

    }
    catch( NoSuchElementException ex )
    {
        System.out.println( "expected NoSuchElementException" ); //this is executed
    }
}
}
