package com.sapient.metro.smartcard;

import com.spaient.metro.smartcard.report.ReportGenerator;
import com.spaient.metro.smartcard.report.STATION;

public class SmartCardHandler implements ISmartCard {
	private static SmartCardHandler smarcardHandler = null;

	private SmartCardHandler() {

	}

	public static SmartCardHandler getInstace() {
		if (smarcardHandler == null)
			smarcardHandler = new SmartCardHandler();
		return smarcardHandler;
	}

	@Override
	public SmartCard purchaseNewCard() {
		SmartCard smarcard = new SmartCard();
		smarcard.setBalance(0);
		smarcard.setCardNumber( (int)(Math.random()*1000));
		SmartcardRecord smarcardRecord = new SmartcardRecord();
		smarcard.setRecord(smarcardRecord);
		System.out.println("card is ready");
	return smarcard;
	}

	@Override
	public void swipeIN(SmartCard smartCard, STATION station) {
		if (smartCard.getBalance() < 5.5) {
			System.out.println("low balance : please recharge you card");
			return;
		}
		smartCard.getRecord().setSourcestation(station);
		ReportGenerator.getInstace().saveStationWiseINOUT(station);
		System.out.println("swipe in successfully at: " + station.toString());

	}

	@Override
	public SmartCard swipeOUT(SmartCard smartCard, STATION destStation, WEEK day) {
		STATION source=	smartCard.getRecord().getSourcestation();
			int stationTravelled=getStationtravelled(source,destStation);
		if(stationTravelled==0){
			stationTravelled=1;
		}
	// need to change in classes to remove if else
		double totalCharge = 1;
		if (WEEK.WEEKDAY.equals(day)) {
			totalCharge = 7.7 * stationTravelled;
		} else {
			totalCharge = 5.5 * stationTravelled;
		}
		if (totalCharge > smartCard.getBalance()) {
			System.out.println("insufficent balance not able to exit");
			return null;
		}
		smartCard.setBalance(smartCard.getBalance() - totalCharge);
	
		smartCard.getRecord().setDestName(destStation);
		smartCard.getRecord().setFare(totalCharge);
		
		System.out.println("swipe out successfully");
	return smartCard;
	}

	private int getStationtravelled(STATION source, STATION destStation) {
		int srcCount=0;
		int destCount=0;
		int netCount=0;
		for(STATION station:STATION.values()){
			if(station.equals(source))
			{
				srcCount++;
			}
			if(station.equals(destStation))
			{
				destCount++;
			}
		if(srcCount !=0 && destCount!=0){
	break;
		}
			if(srcCount !=0 ||destCount!=0){
				netCount++;
			}
		}
		return netCount;
	}

	@Override
	public void handOver(SmartCard smartCard) {
		smartCard = null;
	}

}
