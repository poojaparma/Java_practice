package practice.com.serialization;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Calendar;

//Class to read the time from a flat file time.ser
public class ReadSerialClass {

  public static void main(String [] args) {
      String filename = "c:/time.ser";

      if(args.length > 0){
          filename = args[0];
      }
		
      PersistSerialClass time = null;
      FileInputStream fis = null;
      ObjectInputStream in = null;

      try{
          fis = new FileInputStream(filename);
          in = new ObjectInputStream(fis);
          time = (PersistSerialClass)in.readObject();
          in.close();
      }catch(IOException ex){
          ex.printStackTrace();
      }catch(ClassNotFoundException cnfe){
          cnfe.printStackTrace();
      }

      // print out restored time
      System.out.println("Restored time: " + time.getCurrentTime() + "String: " + time);

      // print out the current time
      System.out.println("Current time: " 
			+ Calendar.getInstance().getTime());

   }
}
