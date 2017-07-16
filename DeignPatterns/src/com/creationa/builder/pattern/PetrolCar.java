package com.creationa.builder.pattern;

public class PetrolCar implements CarBuilder{
	private CarPlan car;
	
	public PetrolCar(){
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
