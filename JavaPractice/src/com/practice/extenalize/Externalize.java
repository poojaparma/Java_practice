package com.practice.extenalize;

public class Externalize {
	/*
	 * Well, when serialization by implementing Serializable interface is
	 * serving your purpose, why should you go for externalization?
	 * 
	 * Good question! Serializing by implementing Serializable interface has
	 * some issues. Lets see one by one what they are.
	 * 
	 * Serialization is a recursive algorithm. What I mean to say here is, apart
	 * from the fields that are required, starting from a single object, until
	 * all the objects that can be reached from that object by following
	 * instance variables, are also serialized. This includes the super class of
	 * the object until it reaches the "Object" class and the same way the super
	 * class of the instance variables until it reaches the "Object" class of
	 * those variables. Basically all the objects that it can read. This leads
	 * to lot of overheads. Say for example, you need only car type and licence
	 * number but using serialization, you cannot stop there. All the
	 * information that includes description of car, its parts, blah blah will
	 * be serialized. Obviously this slows down the performance.
	 * 
	 * Both serializing and deserializing require the serialization mechanism to
	 * discover information about the instance it is serializing. Using the
	 * default serialization mechanism, will use reflection to discover all the
	 * field values. Also the information about class description is added to
	 * the stream which includes the descption of all the serializable
	 * superclasses, the description of the class and the instance data
	 * associated with the specific instance of the class. Lots of data and
	 * metadata and again performance issue.
	 * 
	 * You know that serialization needs serialVersionUID, a unique Id to
	 * identify the information persisted. If you dont explicitly set a
	 * serialiVersionUID, serialization will compute the serialiVersionUID by
	 * going through all the fields and methods. So based on the size of the
	 * class, again serialization mechanism takes respective amount of time to
	 * calculate the value. A third performance issue.
	 * 
	 * 
	 * Above three points confirm serialization has performance issues. Apart
	 * from performance issues, When an object that implements Serializable
	 * interface, is serialized or de-serialized, no constructor of the object
	 * is called and hence any initialization which is done in the constructor
	 * cannot be done. Although there is an alternative of writing all
	 * initialization logic in a separate method and call it in constructor and
	 * readObject methods so that when an object is created or deserialized, the
	 * initialization process can happen but it definitely is a messy approach.
	 */
	/*
	 * How serialization happens? JVM first checks for the Externalizable
	 * interface and if object supports Externalizable interface, then
	 * serializes the object using writeExternal method. If the object does not
	 * support Externalizable but implement Serializable, then the object is
	 * saved using ObjectOutputStream. Now when an Externalizable object is
	 * reconstructed, an instance is created first using the public no-arg
	 * constructor, then the readExternal method is called. Again if the object
	 * does not support Externalizable, then Serializable objects are restored
	 * by reading them from an ObjectInputStream.
	 */
	/*
	 * However, it is strongly recommended that all serializable classes
	 * explicitly declare serialVersionUID values, s ince the default
	 * serialVersionUID computation is highly sensitive to class details that
	 * may vary depending on compiler implementations and can produce different
	 * serialVersionUID in different environments. This can result in unexpected
	 * InvalidClassException during de-serialization.
	 * 
	 * Therefore, to guarantee a consistent serialVersionUID value across
	 * different java compiler implementations, a serializable class must
	 * declare an explicit serialVersionUID value. It is also strongly advised
	 * that explicit serialVersionUID declarations use the private modifier in
	 * serialVersionUID where possible, since such declarations apply only to
	 * the immediately declaring class. SerialVersionUID field is not useful as
	 * inherited member.
	 */}

