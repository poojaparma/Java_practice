package com.structural.pattern.Decorator;
/**
 * Decorator design pattern is used to modify the functionality of 
 * an object at runtime.
 *  At the same time other instances of the same class will not be affected by this
 * @author rakerana
 * But if we want to get a car at runtime that has both the features of sports car and luxury car, 
 * then the implementation gets complex and if further more we want to specify which features should be added first, it gets even more complex. 
 * Now image if we have ten different kind of cars, the implementation logic using inheritance and composition will be impossible to manage. 
 * To solve this kind of programming situation, we apply decorator pattern.
 * In short this pattern adds additional functionalities to the object by wrapping it.
 * Intent:
At times it is required when addition of functionalities is not possible by subclassing as it might create loads of subclasses.
Add or remove additional functionalities or responsibilities from the object dynamically without impacting the original object.
 *
 */
public class DecoratorPattern implements Car{
	protected Car car;
	public DecoratorPattern(Car car){
		this.car=car;
	}
	@Override
	public void assemble() {
		 this.car.assemble();		
	}

}
