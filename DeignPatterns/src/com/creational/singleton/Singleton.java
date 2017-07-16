package com.creational.singleton;
/*This is by far biggest advantage, 
if you have been writing Singletons prior ot Java 5 than you know that even with 
double checked locking you can have more than one instances. though that issue is fixed with Java memory model improvement and 
gurantee provided by volatile variables from Java 5 onwards but it still tricky to write for many beginners. compared to
double checked locking with synchronization Enum singletons are cake walk. 
If you don't believe than just compare below code for conventional singleton with double checked locking and Enum Singletons:
*/
public enum Singleton {
INSTANCE;
}
/*This is the way we generally declare Enum Singleton , 
it may contain instace variable and instance method but for sake of simplicity 
I haven’t used any, just beware that if you are using any instance method than you need to ensure thread-safety of that method
if at all it affect the state of object. By default creation of Enum instance is thread safe but any other method on Enum is programmers responsibility.
*/

/*u can use double check singleton
Now Just look at amount of code needed to create a lazy loaded thread-safe Singleton. 
With Enum Singleton pattern you can have that in one line because creation of Enum instance is thread-safe and guranteed by JVM.

*/
