package com.creationa.builder.pattern;

public class CngCarBuilder implements CarBuilder{
private CarPlan car;
public CngCarBuilder(){
 car = new CarPlan();
}	
@Override
	public void buildBase() {
		// TODO Auto-generated method stub
		car.setbase("basement");
	}

	@Override
	public void buidEngine() {
		// TODO Auto-generated method stub
		car.setEngine("engine");
	}
	@Override
	public String toString(){
		return "CarType : "+ "CNG " +"parts: " +car;
	}
	
	public CarPlan getCar(){
		return car;
	}
}
