package com.creationa.builder.pattern;

public class CarPlan {
	private String base;
	private String engine;
public void setbase(String basement){
	this.base=basement;
}
public void setEngine(String engine)
{
	this.engine=engine;
}
@Override
public String toString(){
	return "base: "+base+" engine: " +engine;
}
}
