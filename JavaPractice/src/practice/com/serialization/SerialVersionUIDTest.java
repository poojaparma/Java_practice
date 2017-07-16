package practice.com.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Lion implements Serializable {
	
	/*Even though serialVersionUID is a static field, it gets serialized along with the object. 
	This is one exception to the general serialization rule that, “static fields are not serialized”*/
	
	/**
	 * // This is generated id ., if we change any field of the class and any but
	//  then it gives different generated id  at the time of de-serializtion we are
	// getting exception if we change values result invalid clas exception.
	
	 */
	//private static final long serialVersionUID = 8167911844129777499L;
	/**
	 * deault  id if we keep 1l that default generated id then it will
	 * not give any exception but need to see  compiler implementation could create different id need to check
	 * and customixed and default id is same or not i think same.
	 *
	 */
//	private static final long serialVersionUID = 1L;
	
	// if we have default version id then at the time of de seriliztion default
	// Generated id could be different as if we do change some field or compiler
	// implementation then at deserialization it will give exception

	// if we don't generated any id then serilize and serialize tht will be
	// successfull the if we change varible or add var the deserialize then it
	// will give deseriliztion

	private String sound;

	public Lion(String sound) {
		this.sound = sound;
	}

	public String getSound() {
		return sound;
	}

	

}

public class SerialVersionUIDTest {

	public static void main(String args[]) throws IOException, ClassNotFoundException {
		Lion leo = new Lion("roar");
		// serialize

		/*
		  System.out.println("Serialization done."); FileOutputStream fos = new
		 FileOutputStream("serial.out"); ObjectOutputStream oos = new
		  ObjectOutputStream(fos); oos.writeObject(leo);*/
		 

		// deserialize
		FileInputStream fis = new FileInputStream("serial.out");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Lion deserializedObj = (Lion) ois.readObject();
		System.out.println("DeSerialization done. SerialVersionUIDTest: " + deserializedObj.getSound() + "volume: "
		/* + deserializedObj.getVolume() */);
	}
}
