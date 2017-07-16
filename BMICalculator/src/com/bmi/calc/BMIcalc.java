package com.bmi.calc;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;





@Path("/bmi")
public class BMIcalc {

@GET
//@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
@Produces(MediaType.APPLICATION_JSON)
public Response getBMI(/*MultivaluedMap<String, String>params@FormParam(value = "weight") int weight,@FormParam(value = "height") int height,String units*/){
	return Response.status(201).entity("success").build();
/*String heights ="123"	;//params.getFirst("height");
String weights="233";//params.getFirst("weight");

int height=Integer.parseInt(heights);
int weight=Integer.parseInt(weights);
System.out.println("height is: " +height+ "weight is: " +weight);
	String units ="s";
//	if(units.equalsIgnoreCase("M")){
	double heightm=height*2.54;
	System.out.println("height in m: " + heightm);
double metre=heightm/100;
	System.out.println("inches are: "+ metre);
	//}
	double bmi=bmiKG(weight,metre);
	String healthStatus=null;
	if(bmi<18.5){
		healthStatus="under Weight";
	}else if(bmi>18.5&&bmi<24.9){
		healthStatus="Healthy";
	}else if(bmi>25&&bmi<29.9){
		healthStatus="OverWeight";	
	}else if(bmi>30){
		healthStatus=	"Obese";
	}
	String response=bmi+","+healthStatus;
	return	Response.status(201).entity(response).build();*/

}
/*else{
Double	lbs =weight*2.2046;
int inches= convertToInch(height);
System.out.println("lbs is: " + lbs + "inches: " +inches);
return Response.status(201).entity(String.valueOf(bmiLB(lbs,inches));

}*/
//}
private int convertToInch(int height) {
int digit =height;
int temp=0;
int divider=10;

int inches =0;
 temp =digit/divider;
    digit = digit % divider;
    inches =temp*12 +digit;
return inches;
}
private double bmiLB(Double weight, int height) {
	int hsquare=height*height;
	double BMI=weight/hsquare;
return BMI*703;
}
private Double bmiKG(int weight,double height) {
	System.out.println("inisde kg");
	double hsquare=height*height;
	System.out.println("height is: " + hsquare + "weweight is: " + weight);
	double BMI=weight/hsquare;
	System.out.println("Bmi is: " + BMI);

	return BMI;
}
}
