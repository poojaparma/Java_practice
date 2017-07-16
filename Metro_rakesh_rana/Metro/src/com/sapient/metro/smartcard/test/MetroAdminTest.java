package com.sapient.metro.smartcard.test;

import java.util.ArrayList;
import java.util.List;

import com.sapient.metro.smartcard.SmartCard;
import com.sapient.metro.smartcard.SmartCardHandler;
import com.sapient.metro.smartcard.WEEK;
import com.spaient.metro.smartcard.report.ReportGenerator;
import com.spaient.metro.smartcard.report.STATION;

public class MetroAdminTest {
static 	List< SmartCard>smarcards= new ArrayList<SmartCard>();
	public static void main(String[] args) {
		startMetroActivity();
	}

	private static void startMetroActivity() {
		SmartCardHandler smardcardHandler = SmartCardHandler.getInstace();
		for (int i = 0; i < 5; i++) {
			SmartCard smartCard = smardcardHandler.purchaseNewCard();
			startSwipeinandOut(smardcardHandler, smartCard);
		}
		reportGenerate();
		
		
	}

	private static void reportGenerateCardWise(SmartCard smarcard) {
	
			System.out.println("report per card:"+ ReportGenerator.getInstace().getPerCardReport(smarcard));
		}
	

	private static void reportGenerate() {
		for (STATION e : STATION.values()){
			System.out.println(" footfall for station " + e.name()
					+" is:  " +ReportGenerator.getInstace().getTotalFootFall(e));
		}
	}

	private static void startSwipeinandOut(SmartCardHandler smardcardHandler,
			SmartCard smartCard) {
		
		STATION[] arr = STATION.values();
		for (int i = 0; i < 10; i++) {
			if(i<6){
				smardcardHandler.swipeIN(smartCard, arr[i+2]);
			}else{
				smardcardHandler.swipeIN(smartCard, arr[i]);
			}
			if (i < 5) {
				System.out.println("smartcard number doing swipe in: " + smartCard.getCardNumber());
				SmartCard	 smartcard=smardcardHandler.swipeOUT(smartCard, arr[i], WEEK.WEEKDAY);
				System.out.println("smartcard number doing swipe in: " + smartCard.getCardNumber());
				reportGenerateCardWise(smartcard);
			} else {
				SmartCard	 smartcard=smardcardHandler.swipeOUT(smartCard, arr[i], WEEK.WEEKEND);
				reportGenerateCardWise(smartcard);
			}
		}
	}
}
