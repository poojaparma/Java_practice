package practice.com.clonning;

public class DeepCopyTest {
	public static void main(String[] args) {
		// Original Object
		//In this figure, the object mainObj1 has fields field1 a primitive data type say int, and 
		//an object of type String When we do a deep copy of mainObj1, mainObj2 is created with field2 
	//	containing the copied value of field1 and objStr2 is created which contains the copied value of
	//	objStr1 So any changes made to objStr1 in mainObj1 will not reflect in mainObj2.

		PupilVO1 stud = new PupilVO1("Johnathan", "Algebra");
		System.out.println("Original Object: " + stud.getName() + " - "
				+ stud.getSubj().getName()); 
		// Clone Object 
		PupilVO1 clonedStud = (PupilVO1) stud.clone();
		System.out.println("Cloned Object: " + clonedStud.getName() + " - "
				+ clonedStud.getSubj().getName());
		stud.setName("Daniel");
		stud.getSubj().setName("Physics");
		System.out.println("Original Object after it is updated: "
				+ stud.getName() + " - " + stud.getSubj().getName());
		System.out
				.println("Cloned Object after updating original object: "
						+ clonedStud.getName() + " - "
						+ clonedStud.getSubj().getName());
												// }
	}
}
