package com.java.eight.feature;

public class DiamondProblem implements Interface1, Interface2 {
	public static void main(String[] args) {
		/*
		 * DiamondProblem diamondProblem = new DiamondProblem();
		 * diamondProblem.log("dghhhhhhhhhhhhhhh"); Runnable r=()->{
		 * System.out.println("lambda exp"); };
		 */ // String s ="";
			// So lambda expressions are means to create anonymous classes of
			// functional interfaces easily. There are no runtime benefits of
			// using lambda expressions,
		// /so I will use it cautiously because I don’t mind writing few extra
		// lines of code.
		Interface1 ii1 = (s) -> {
			System.out.println(s);
		};
		//ii1.method1("interface........123");
	}

	@Override
	public void method2() {
		// TODO Auto-generated method stub

	}

	@Override
	public void method1(String str) {
		// TODO Auto-generated method stub

	}

	/**
	 * if both interface have same default method creating diamond problem then
	 * at compile time will be getting error to provide implementation of one
	 * interface and can give only one method implementation
	 */
	@Override
	public void log(String str) {
		// TODO Auto-generated method stub
		Interface1.super.log(str);
		Interface1.print("hjhjhh");
	Interface2.super.log("inerface 2");
	}

}

/*
 * A new annotation @FunctionalInterface has been introduced to mark an
 * interface as Functional Interface. @Functional Interface annotation is a
 * facility to avoid accidental addition of abstract methods in the functional
 * interfaces. It’s optional but good practice to use it.
 * 
 * @FunctionalInterface
 */
@FunctionalInterface
interface Interface1 {

	void method1(String str);

	// methods are added so that our code remains backward compatible.
	default void log(String str) {
		System.out.println("I1 logging::" + str);
	}

	/*
	 * Static methods are similar to default methods except that we can’t
	 * override them in the implementation classes. This feature helps us in
	 * avoiding undesired results incase of poor implementation in child
	 * classes. Let’s look into this with a simple example.
	 */
	static void print(String str) {
		System.out.println("Printing " + str);
	}

	// trying to override Object method gives compile time error as
	// "A default method cannot override a method from java.lang.Object"

	// default String toString(){
	// return "i1";
	// }

}

@FunctionalInterface
interface Interface2 {

	void method2();

	default void log(String str) {
		System.out.println("I2 logging::" + str);
	}

}
