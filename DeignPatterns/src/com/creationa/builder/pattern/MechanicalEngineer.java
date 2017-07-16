package com.creationa.builder.pattern;
/**
 * This calss is used to build car by invoking build method ,internall thre ae multipke steps use to build object
 * Builder provudes an interface for creating the parts that make up aproduct and concrete builde provides an 
 * implementation if this interface and keeps track of representation it creates .
 * Director constructs the object throgh the builder's interface p,product is the object ,usually complex 
 * @author rakerana
 *
 */
public class MechanicalEngineer {
private CarBuilder carbuilder;
private CarPlan car;
	public MechanicalEngineer(CarBuilder carbuilder){
	this.carbuilder=carbuilder;
}
public void build(){
	carbuilder.buidEngine();
	carbuilder.buildBase();
}

public static void main(String[] args) {
	MechanicalEngineer engg = new MechanicalEngineer(new CngCarBuilder());
	engg.build();
	System.out.println("Build your : " +engg.carbuilder);
	MechanicalEngineer engg1 = new MechanicalEngineer(new PetrolCar());
	engg1.build();
	System.out.println("Build your : " +engg.carbuilder);
}
public CarPlan getCar() {
	return carbuilder.getCar();
}

}
