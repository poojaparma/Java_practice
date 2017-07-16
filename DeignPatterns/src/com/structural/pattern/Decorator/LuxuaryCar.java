package com.structural.pattern.Decorator;

public class LuxuaryCar extends DecoratorPattern{

	public LuxuaryCar(Car car) {
		super(car);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void assemble() {
		 this.car.assemble();		
	}
}
