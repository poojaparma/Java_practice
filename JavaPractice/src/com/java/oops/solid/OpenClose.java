package com.java.oops.solid;

public class OpenClose {
	/*Let’s continue with our same customer class example. 
	 * I have added a simple customer type property to the class. 
	 * This property decided if this is a “Gold” ora “Silver” customer.

	Depending on the same it calculates discount.
	 Have a look at the “getDiscount” function which returns discount accordingly.
	  1 for Gold customer and 2 for Silver customer.

	Guess, what’s the problem with the below code. Hahaha,
	 looks like this article will make you a GUESS championWink | ;-) .
	Ok, also let me add a HINT, look at the “IF” condition in the “getDiscount” function.*/

	class Customer
	{
	        private int _CustType;

	        public int CustType;
	        {
	       //     get { return CustType; }
	       //     set { CustType = value; }
	        }

	        public double getDiscount(double TotalSales)
	        {
	                if (_CustType == 1)
	                {
	                    return TotalSales - 100;
	                }
	                else
	                {
	                    return TotalSales - 50;
	                }
	        }
	}

	/*The problem is if we add a new customer type we need to go and 
	 * add one more “IF” condition in the “getDiscount” function,
	 *  in other words we need to change the customer class.

	If we are changing the customer class again and again, 
	we need to ensure that the previous conditions with new one’s are tested again ,
	 existing client’s which are referencing this class are working properly as before.

	In other words we are “MODIFYING” the current customer code for every change and 
	every time we modify we need to ensure that all the previous functionalities and 
	connected client are working as before.*/
	//How about rather than “MODIFYING” we go for “EXTENSION”.
	//In other words every time a new customer type needs to be added we create a new class as shown in the below. 
	//So whatever is the current code they are untouched and we just need to test and check the new classes.

	class Customer1
	{
	        public  double getDiscount(double TotalSales)
	        {
	            return TotalSales;
	        }
	}

	  class SilverCustomer extends Customer1
	    {
	        public  double getDiscount(double TotalSales)
	        {
	            return super.getDiscount(TotalSales) - 50;
	            
	        }
	    }


	class goldCustomer extends SilverCustomer
	    {
	        public  double getDiscount(double TotalSales)
	        {
	            return super.getDiscount(TotalSales) - 100;
	        }
	    }

}
