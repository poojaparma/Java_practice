package practice.com.clonning;

public class ShallowCopyTest {
	public static void main(String[] args) {
		// Original Object

		/*
		 * In this figure, the object - mainObj1 has fields field1 of a
		 * primitive type say int, and an object of type String When we do a
		 * shallow copy of mainObj1, mainObj2 is created with field2 of type int
		 * which contains the copied value of field1 but the String object in
		 * mainObj2 - still points to objStr itself. Since field1 is a primitive
		 * data type, the value of it is copied into field2. But since objStr is
		 * an object, mainObj2 is pointing to the same address of objStr. So any
		 * changes made to objStr via mainObj1 get reflected in mainObj2.
		 */
		PupilVO stud = new PupilVO("Johnathan", "Algebra");
		System.out.println("Original Object: " + stud.getName() + " - "
				+ stud.getSubj().getName());
		// Clone Object
		PupilVO clonedStud = (PupilVO) stud.clone();
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
