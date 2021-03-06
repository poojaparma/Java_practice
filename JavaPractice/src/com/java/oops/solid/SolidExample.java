package com.java.oops.solid;
/**
 * This is basically example of SOLID
 * s: single responsibility principle
 * o : open closed prnciple
 * L : liskov substitution principle
 * I: Interface segragation pricnciple
 * D: dependency injection
 * @author rakerana
 *
 */
public class SolidExample {
	//Customer class should do customer data validations, call the customer data access layer etc ,
	//but if you see the catch block 
	//closely it also doing LOGGING activity. In simple words its over loaded with lot of responsibility.
	class Customer
    {
        public void Add()
        {
            try
            {
                // Database code goes here
            }
            catch (Exception ex)
            {
                System.out.print("c:\\Error.txt"+ ex);
            }
        }
    }
//	So SRP says that a class should have only one responsibility and not multiple.
	//So if we apply SRP we can move that logging activity to some other class
	//who will only look after logging activities.
//	Hide   Copy Code

	class FileLogger
	    {
	        public void Handle(String error)
	        {
	        	 System.out.print("c:\\Error.txt"+ error);
	        }
	    }
	//Now customer class can happily delegate the logging activity to the 
	//“FileLogger” class and he can concentrate on customer related activities.
//	Hide   Copy Code

	class Customer1
	    {
	        private FileLogger obj = new FileLogger();
	         void Add()
	        {
	            try
	            {
	                // Database code goes here
	            }
	            catch (Exception ex)
	            {
	                obj.Handle(ex.toString());
	            }
	        }
	    }

}
