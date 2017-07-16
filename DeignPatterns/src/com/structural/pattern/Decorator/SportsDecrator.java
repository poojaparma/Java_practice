package com.structural.pattern.Decorator;

public class SportsDecrator extends DecoratorPattern{

	public SportsDecrator(Car car) {
		super(car);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void assemble() {
		 this.car.assemble();		
	}
}
