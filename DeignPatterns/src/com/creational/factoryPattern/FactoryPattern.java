package com.creational.factoryPattern;

/*Factory Method is known as a creational pattern - 
 * it's used to construct objects such that they can be decoupled from the implementing system. 
 * Thedefinition of Factory Method provided in the original Gang of Four book on DesignPatterns states: 

Define an interface for creating an object, 
but let the subclasses decide which class to instantiate.
 The Factory method lets a class defer instantiation to subclasses
Now, let's take a look at the diagram definition of the Factory Method  pattern. 
The Creator hides the creation and instantiation of the Product from the client. 
This is a benefit to the client as they are now insulated from any future changes - 
the Creator will look after all of their creation needs, allowing to decoupling. Furthermore, once the Creator and the Product conform to an interface that the client knows, the client doesn't need to know about the concrete implementations of either. The factory method pattern really encourages coding to an interface in order to deal with future change.
*/
/*The idea behind the Factory Method pattern is that it allows for the case where a client 
doesn't know what concrete classes it will be required to create at runtime, but just wants to get a class that will do the job. The FactoryMethod builds on the concept of a simple Factory, but lets the subclasses decide which implementation of the concrete class to use.  You'll see factories used in logging frameworks, and in a lot of scenarios where the client doesn't 
need to know about the concrete implementations. It's a good approach to encapsulation.
//A. Using new operator to create objects is a valid approach but it�s like hard coding the object type. If we are 100% sure that our object will be of the same class all the time, then we use new operator to create an object. In scenarios where the nature of the object can change according to the nature of the program, we use creational design patterns which offer 
 * flexible approach for creating class instances.
*/public class FactoryPattern {
	public static Dog getDog(String criteria) {
		if (criteria.equals("small"))
			// return new Poodle();
			if (criteria.equals("big"))
				// return new Rottweiler();
				if (criteria.equals("working"))
					// return new SiberianHusky();

					return null;
		return null;
	}
}
