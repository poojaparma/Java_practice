package com.sapient.metro.smartcard.test;

import com.sapient.metro.smartcard.SmartCard;
import com.sapient.metro.smartcard.SmartCardHandler;
import com.sapient.metro.smartcard.WEEK;
import com.spaient.metro.smartcard.report.STATION;


public class SmartCardHandlerTest {
public static void main(String[] args) {
	SmartCardHandlerTest smartCardHandlerTest = new SmartCardHandlerTest();
	smartCardHandlerTest.getSwipeOutdetails();
}
	public void getSwipeOutdetails(){
		SmartCardHandler smardcardHandler = SmartCardHandler.getInstace();
		for (int i = 0; i < 2; i++) {
			SmartCard smartCard = smardcardHandler.purchaseNewCard();
			STATION[] arr = STATION.values();
			SmartCardHandler.getInstace().swipeOUT(smartCard,arr[i] , WEEK.WEEKDAY);
		}
		
}
}
