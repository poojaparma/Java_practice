package com.java.eight.feature;

public class SparkCleint {
public String getrecording(){
	String	value = null;
	Retry<RetryService<String>, String> example = new Retry<RetryService<String>, String>(3);
		try {
			value = example.retryPolicy(() -> {
				throw new RuntimeException();
				// value="succesfull";

				// return value;
			});

		}catch(Exception e){
		System.out.println("print value");
	}
	return value;
	
}
}
