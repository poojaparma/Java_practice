package com.creational.singleton;

public class SingletonFactoryMethod {
	//initailzed during class loading
    private static final SingletonFactoryMethod INSTANCE = new SingletonFactoryMethod();
  
    //to prevent creating another instance of Singleton
    private SingletonFactoryMethod(){}

    public static SingletonFactoryMethod getSingleton(){
        return INSTANCE;
    }

}
/*nother problem with conventional Singletons are that once you implement serializable 
interface they are no longer remain Singleton because readObject() method always return a new instance just like constructor in Java. 
you can avoid that by using readResolve() method and discarding newly created instance by replacing with Singeton as shwon in below example :

    //readResolve to prevent another instance of Singleton
    private Object readResolve(){
        return INSTANCE;
    }

This can become even more complex if your Singleton Class maintain state, 
as you need to make them transient, but witn Enum Singleton, Serialization is guarnateed by JVM.

*/
