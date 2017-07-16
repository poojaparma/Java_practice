/**
 * 
 */
package practice.com.serialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

/*serialize file size is bigger than the data saved surprise ..

 * First it writes out the serialization stream magic data - What is serialization stream magic data? 
 *This is nothing but the STREAM_MAGIC and STREAM_VERSION data (static data) so that JVM can deserialize it when it has to. 
 The STRAM_MAGIC will be "AC ED" and the STREAM_VERSION will be the version of the JVM.

 Then it writes out the metadata (description) of the class associated with an instance. 
 So in the below example after writing out the magic data, it writes out the description of "SerialClass" class. What does this description include? It includes the length of the class, the name of the class, serialVersionUID (or serial version), various flags and the number of fields in this class.
 Then it recursively writes out the metadata of the superclass until it finds java.lang.object. Again in the below example, it writes out the description of "SerialParent" and "SerialParentParent" classes.
 Once it finishes writing the metadata information, it then starts with the actual data associated with the instance. But this time, it starts from the top most superclass. So it starts from "SerialParentParent", then writes out "SerialParent".
 Finally it writes the data of objects associated with the instance starting from metadata to actual content. So here it starts writing the metadata for the class Contain and then the contents of it as usual recursively.*/
/*Matching to above concept i.e. constructor of super most class, we have similar concept in deserialization. 
 In deserialization process, it is required that all the parent classes of instance should be Serializable; and 
 if any super class in hirarchy is not Serializable then it must have a default constructor*/
public class PersistSerialClass implements Serializable {
	private static String str = null;

	PersistSerialClass(String s) {
		this.str = s;
		currentTime = Calendar.getInstance().getTime();
	}

	private Date currentTime;

	public Date getCurrentTime() {
		return currentTime;
	}

	public static void main(String[] args) {
		String filename = "c:/time.ser";

		PersistSerialClass time = new PersistSerialClass("hello");
		FileOutputStream fos = null;
		ObjectOutputStream out = null;

		try {
			fos = new FileOutputStream(filename);
			out = new ObjectOutputStream(fos);
			out.writeObject(time);
			out.close();
			System.out.println("stored time: " + time.getCurrentTime()
					+ "string:" + time);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return str;
	}
}
