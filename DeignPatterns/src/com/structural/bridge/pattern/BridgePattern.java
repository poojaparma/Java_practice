package com.structural.bridge.pattern;
/**
 * 
“Decouple an abstraction from its implementation so that the two can vary independently” is the intent for bridge design pattern as stated by GoF.

Bridge design pattern is a modified version of the notion of “prefer composition over inheritance”
 * @author rakerana
 *
 *The Bridge pattern should be used when both the class as well as what it does vary often.
 * The bridge pattern can also be thought of as two layers of abstraction.
 *  When the abstractions and implementations should not be bound at compile time, and should be independently extensible the pattern should be used. 

In particular this pattern is useful in graphic toolkits that need to run on multiple platforms. You'll  see this in AWT, 
where a component has a component peer which does the OS specific operations. 
Also the Collections framework has examples of the bridge interface: ArrayList and LinkedList are implement List. 
And List provides common methods to add, remove or check size. 
 */
public class BridgePattern {

}
