package com.java.practice;

public class Test {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//sum of triangle 
		String s = "25#45#13";
		String [] s1 = s.split("#");
		if(s1.length == 1)
		if(s.contains("#"))
		System.out.println("s1.length:"+ s1.length );

		int sum = 0;
		int transverse = 0;
		int max = -1 ;
		for(int i = 1; i < s1.length; i++){
		System.out.println("printing i: " + i);
		if(transverse == s1.length){
		break;
		}
		for(int j = 1; j <= i ; j++){

		try{
		System.out.println("printing j: " + j);


		if(transverse < s1.length){
		System.out.println("transverse:" + transverse +" (s1[transverse]): " + (s1[transverse]));
		max = Math.max(max, Integer.parseInt(s1[transverse]));


		}else{
		System.out.println("Invalid");
		System.exit(1);
		}

		transverse++;
		}catch(NumberFormatException e){
		System.out.println("Invalid");
		System.exit(1);
		}
		}
		System.out.println("max: " + max);
		System.out.println("I ma adding");
		sum = sum + max;
		System.out.println("Inner sum:" + sum);
		max = 0;
		}

		System.out.println(sum);

		}
/*public static void main(String[] args) {
	StringBuilder builder =new StringBuilder();
	//for(int i=1;i<=1010;i++){
	builder.append(i).append("5#9#6#4");
	
	//}
	//builder.append("#");
	validInputString(builder.toString());
	System.out.println("buildr os:  " + builder.toString());
}*/

	/*public static String validtrianglesum(String input1) {
		String[] sarray = input1.split("#");
		int var = -1;
		int i = 0, j = 0, k = -1, total_max = -0, row_max = 0;
		// Write code here
		while (j < sarray.length && sarray[j] != null) {
			k = 0;
			row_max = -1;
			while (k <= i) {
				try {

					var = Integer.parseInt(sarray[j]);
					if (var >= 0 && var <= 9) {
						row_max = Math.max(row_max, var);
						j++;
						k++;
					} else {
						return "Invalid";
					}
				} catch (Exception e) {
					return "Invalid";
				}
			}
			total_max += row_max;
			i++;
		}
		return String.valueOf(total_max);

	}*/


	private static void validInputString(String input1) {

		String arrayString[] = new String[1009];
		if(input1.endsWith("#")){
		System.out.println("ends with #");
			return;
		}
		arrayString = input1.split("#");
		int max = 0;
		int total_max = 0;
		int index = 0;
		int pointer = 0;
		int element=0;
		int old_value=0;
		while (index < arrayString.length) {
			int rowTimes = -1;
			while(!(rowTimes==index)){
			
				rowTimes++;
				if(pointer<arrayString.length){
			try{
					element=Integer.parseInt(arrayString[pointer]);
			}catch(NumberFormatException ne){
				System.out.println("consecutive # occured");
			return;
			}
					System.out.println("element: "+ element);
				if(max<element)
					max=element;
				pointer++;
				}else{
					System.out.println("output ennded");
					return;
				}
				}
			
			if(!(old_value+1==rowTimes)){
				System.out.println("traingle is not formed");
				return ;
			}
			old_value=rowTimes;
			index++;
			System.out.println("max value is : " + max + "for index is: " + index);
			total_max = total_max + max;
			max = 0;

		}
	}

	
	/*public static String validInputString(String input1) {
		String[] sarray = input1.split("#");
		int var = -1;
		int i = 0, j = 0, k = -1, total_max = -0, row_max = 0;
		// Write code here
		while (j < sarray.length && sarray[j] != null) {
			k = 0;
			row_max = -1;
			while (k <= i) {
				try {
					if (sarray[j] == null) {
						System.out.println("Invalid");
						System.exit(0);
					}
					var = Integer.parseInt(sarray[j]);
					if (var >= 0 && var <= 9) {
						row_max = Math.max(row_max, var);
						j++;
						k++;
					} else {
						System.out.println("Invalid");
						System.exit(0);
					}
				} catch (NumberFormatException e) {
					System.out.println("Invalid");
					System.exit(0);
				}
			}
			total_max += row_max;
			i++;
		}
		return String.valueOf(total_max);

	}*/


}
