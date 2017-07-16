package com.java.eight.feature;

/**
 * Each lambda corresponds to a given type specified by an interface. A so
 * called functional interface must contain exactly one abstract method
 * declaration. Each lambda expression of that type will be matched to this
 * abstract method. Since default methods are not abstract you're free to add
 * default methods to your functional interface. We can use arbitrary interfaces
 * as lambda expressions as long as the interface only contains one abstract
 * method. To ensure that your interface meet the requirements, you should add
 * the @FunctionalInterface annotation. The compiler is aware of this annotation
 * and throws a compiler error as soon as you try to add a second abstract
 * method declaration to the interface.
 * But different to anonymous objects the variable num does not have to be declared final. This code is also valid:
 * However num must be implicitly final for the code to compile. The following code does not compile:
 * We can read final local variables from the outer scope of lambda expressions
 * Writing to num from within the lambda expression is also prohibited.
 * 
 *
 */
public class LambdaExpression {
	LambdaExpression lam = new LambdaExpression();

	// Funaction interface is one abstract method only
	public static void main(String[] args) {
		// lambda expresion works only on abstract methoda not on default
		// doSomerWorkinmain((int a,int b)->System.out.println("print"));
		// interface or functional in both we can use lambda
		doSomerWorkinmain(() -> System.out.println("lambda expreession"));

		// spark file impl
	}

	static void doSomerWorkinmain(WorkerInterface worker) {
		// using default method but need object for interface or implementation
		worker.doSomeWork1(1, 2);

		worker.doSomeWork();
	}
}

// define a functional interface
// @FunctionalInterface
interface WorkerInterface {
	/*The key difference between Anonymous class and Lambda expression is the usage of 'this' keyword. In the anonymous classes, ‘this’ keyword resolves to anonymous class itself, whereas for lambda expression ‘this’ keyword resolves to enclosing class where lambda expression is written.

	Another difference between lambda expression and anonymous class is in the way these two are compiled. Java compiler compiles lambda expressions and convert them into private method of the class. It uses invokedynamic instruction that was added in Java 7 to bind this method dynamically.

	- See more at: http://www.java2novice.com/java_interview_questions/lamda-expression-anonymous-class/#sthash.4QOxeJ78.dpuf
	*/
	public void doSomeWork();

	// default method can multiple written in java interface in both interface
	// and
	// functional interface,lambda expression does not work with default method will give compile error
	public default void doSomeWork1(int a, int b) {
		System.out.println("print value" + a + b);
	}

	// default method can be written in java interface in both interface and
	// functional interface
	public default void doSomeWork12(int a, int b) {
		System.out.println("print value : " + a + b);
	}

}
