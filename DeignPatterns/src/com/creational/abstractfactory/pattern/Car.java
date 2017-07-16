package com.creational.abstractfactory.pattern;
/*Abstract factory pattern is yet another creational design pattern and is considered as another layer of abstraction over factory pattern. In this post, i will expand the problem statement discussed in previous post and will see, how abstract factory pattern solve the problem.



In my previous post, “Implementing factory design pattern in java“, we discussed how to abstract the car making process for various car model types and their additional logic included in car making process. Lets expand this use case. Now, imagine if our car maker decide to go global.

Becoming global will require to enhance the system to support different car making styles for different countries. For example we will consider USA, Asia and default for all other countries.*/
public abstract class Car {
	 public Car(CarType model, Location location){
	        this.model = model;
	        this.location = location;
	    }
	 
	    protected abstract void construct();
	 
	    protected CarType model = null;
	    private Location location = null;
	 
	    public CarType getModel() {
	        return model;
	    }
	 
	    public void setModel(CarType model) {
	        this.model = model;
	    }
	 
	    public Location getLocation() {
	        return location;
	    }
	 
	    public void setLocation(Location location) {
	        this.location = location;
	    }
	 
	    @Override
	    public String toString() {
	        return "Model- "+model + " built in "+"location";
	    }
}
