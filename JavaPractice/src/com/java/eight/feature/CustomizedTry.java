package com.java.eight.feature;

public class CustomizedTry implements AutoCloseable {

	public void doIt() {
        System.out.println("MyAutoClosable doing it!");
    }
	@Override
	public void close() throws Exception {
		System.out.println("closing .");
	}
public static void main(String[] args)  {
	 try(CustomizedTry myAutoClosable = new CustomizedTry()){
	        myAutoClosable.doIt();
	    } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
}
