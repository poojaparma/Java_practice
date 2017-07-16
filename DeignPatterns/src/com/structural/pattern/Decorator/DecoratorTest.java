package com.structural.pattern.Decorator;
//There are various live examples of decorator pattern in Java API.
/*java.io.BufferedReader;
java.io.FileReader;
java.io.Reader;*/
public class DecoratorTest {
public static void main(String[] args) {
	Car sportsCar = new SportsDecrator(new BasicCar());
    sportsCar.assemble();
    System.out.println("\n*****");
     
    Car sportsLuxuryCar = new SportsDecrator(new LuxuaryCar(new BasicCar()));
    sportsLuxuryCar.assemble();
    
    Pizza pizza = new ChickenTikkaPizza(new BsicPizza());
    System.out.println(pizza.bakePizza());
}
}
