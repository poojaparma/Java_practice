package com.budget.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class HelloController{
	@RequestMapping(value="/get",method = RequestMethod.GET,headers="Accept=application/json")
	// @RequestMapping(value="/get",method = RequestMethod.GET,headers="Accept=application/json"/*,produces = "application/json; charset=utf-8"*//*,consumes="application/json; charset=utf-8"*/)
	@ResponseBody
	public   List<HomeBudget> getHomeBudget(/*@PathVariable HomeBudget home*/) {

		//JSONArray jsonObject=null;
		//JSONParser parser = new JSONParser();
		HomeBudget alarm=null;
		 List<HomeBudget> alarms = new ArrayList<HomeBudget>();
		try {
	
		//	Object obj = parser.parse(new FileReader("c:/alarmsGrid - Copy.json"));
	 
		//	 jsonObject = (JSONArray) obj;
	
			//System.out.println("inside get request");
	for(int i=0;i<3;i++){
			alarm = new HomeBudget();
	 alarm.setBillPayments("3300"+i);
	 alarm.setCosmeticsItems("700"+i);
	 alarm.setDailyExpenditure("1111"+i);
	 alarm.setDateI("5"+i+"-04-2015");
	 alarm.setKidExpenses("1111"+i);
	 alarm.setMedicalExpenses("111"+i);
	 alarm.setRentEmi("23000"+i);
	 alarm.setOfficeExpenses("3000"+i);
	 alarm.setTravellingExpenses("300"+i);
	 alarm.setVehicleExpenses("300"+i);
	 alarms.add(alarm);
	}
	// System.out.println("alarm returned: " + alarms);
			// loop array
			/*Iterator<String> iterator = msg.iterator();
			while (iterator.hasNext()) {
				System.out.println(iterator.next());
			}*/
	 
		} /*catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}*/ catch (Exception e) {
			e.printStackTrace();
		}

		return alarms;
		
	

   }
	@RequestMapping(value="/post",method = RequestMethod.PUT,headers="Accept=application/json")
	// @RequestMapping(value="/get",method = RequestMethod.GET,headers="Accept=application/json"/*,produces = "application/json; charset=utf-8"*//*,consumes="application/json; charset=utf-8"*/)
	@ResponseBody
	public   List<HomeBudget> updateHomeBudget(@RequestBody HomeBudget home) {

		//JSONArray jsonObject=null;
		//JSONParser parser = new JSONParser();
		HomeBudget alarm=null;
		 List<HomeBudget> alarms = new ArrayList<HomeBudget>();
		try {
	
		//	Object obj = parser.parse(new FileReader("c:/alarmsGrid - Copy.json"));
	 
		//	 jsonObject = (JSONArray) obj;
	
			System.out.println("update is called " +home);
	for(int i=0;i<3;i++){
			alarm = new HomeBudget();
	 alarm.setBillPayments("3300"+i);
	 alarm.setCosmeticsItems("700"+i);
	 alarm.setDailyExpenditure("1111"+i);
	 alarm.setDateI("5"+i+"-04-2015");
	 alarm.setKidExpenses("1111"+i);
	 alarm.setMedicalExpenses("111"+i);
	 alarm.setRentEmi("23000"+i);
	 alarm.setOfficeExpenses("3000"+i);
	 alarm.setTravellingExpenses("300"+i);
	 alarm.setVehicleExpenses("300"+i);
	 alarms.add(alarm);
	}
	// System.out.println("alarm returned: " + alarms);
			// loop array
			/*Iterator<String> iterator = msg.iterator();
			while (iterator.hasNext()) {
				System.out.println(iterator.next());
			}*/
	 
		} /*catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}*/ catch (Exception e) {
			e.printStackTrace();
		}

		return alarms;
		
	

   }
	@RequestMapping(value="/create",method = RequestMethod.POST/*,headers="Accept=application/json",consumes = "application/json; charset=utf-8"*/)
	// @RequestMapping(value="/get",method = RequestMethod.GET,headers="Accept=application/json"/*,produces = "application/json; charset=utf-8"*//*,consumes="application/json; charset=utf-8"*/)
	@ResponseBody
	public  List <HomeBudget> createHomeBudget(@RequestBody  HomeBudget home) {
		
		System.out.println("create is called: " + home);
		HomeBudget alarm=null;
		 List<HomeBudget> alarms = new ArrayList<HomeBudget>();
		try {
	
		
		}	 catch (Exception e) {
			e.printStackTrace();
		}

	return alarms;
		
	

   }
	@RequestMapping(value="/destroy",method = RequestMethod.DELETE/*,headers="Accept=application/json",consumes = "application/json; charset=utf-8"*/)
	// @RequestMapping(value="/get",method = RequestMethod.GET,headers="Accept=application/json"/*,produces = "application/json; charset=utf-8"*//*,consumes="application/json; charset=utf-8"*/)
	@ResponseBody
	public  List <HomeBudget> deleteHomeBudget(@RequestBody  String home) {
		
		System.out.println("delete is called: " + home);
		HomeBudget alarm=null;
		 List<HomeBudget> alarms = new ArrayList<HomeBudget>();
		try {
	
		
		}	 catch (Exception e) {
			e.printStackTrace();
		}

	return alarms;
		
	

   }
	
	//should be made in different controllerin mvc 
	@RequestMapping(value="/user",method = RequestMethod.GET,headers="Accept=application/json")
	// @RequestMapping(value="/get",method = RequestMethod.GET,headers="Accept=application/json"/*,produces = "application/json; charset=utf-8"*//*,consumes="application/json; charset=utf-8"*/)
	@ResponseBody
	public   boolean getUser(/*@PathVariable HomeBudget home*/) {
		return true;
	}
	//should be made in different controllerin mvc 
	@RequestMapping(value="/register",method = RequestMethod.GET,headers="Accept=application/json")
	// @RequestMapping(value="/get",method = RequestMethod.GET,headers="Accept=application/json"/*,produces = "application/json; charset=utf-8"*//*,consumes="application/json; charset=utf-8"*/)
	@ResponseBody
	public   boolean registerUser(/*@PathVariable HomeBudget home*/) {
		System.out.println("registering.........");
		return true;
	}
}