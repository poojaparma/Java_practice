package com.spaient.metro.smartcard.report;

import java.util.HashMap;
import java.util.Map;

import com.sapient.metro.smartcard.SmartCard;

public class ReportGenerator implements IReportGenerator,StationINOUT {
	public static Map<STATION, Integer> totalFootFall = new HashMap<STATION, Integer>();
	private static ReportGenerator reportGenerator = null;
	public static ReportGenerator getInstace() {
	
		if (reportGenerator == null)
			reportGenerator = new ReportGenerator();
		return reportGenerator;
	}
	private ReportGenerator(){
		
	}
	// notified whenever swipe
	// and out swipe out happened for particular station
	@Override
	public  Integer getTotalFootFall(STATION station) {

		return totalFootFall.get(station);
	}

	// source and destination station
	@Override
	public String getPerCardReport(SmartCard card) {
		StringBuilder builder = new StringBuilder("Card: ");
		try{
		builder.append(Integer.valueOf(card.getCardNumber()));
		}catch(Exception e){
			
		}
		builder.append("used to travel from ");
		builder.append(card.getRecord().getSourcestation());
		builder.append(" to station: ");
		builder.append(card.getRecord().getDestName());
		builder.append(" Fare is Rs ");
		builder.append(card.getRecord().getFare());
		builder.append(" balance on the card is: ");
		builder.append(card.getBalance());
		return builder.toString();
	}

	public   void saveStationWiseINOUT(STATION station) {
		int count=0;
		if(totalFootFall.containsKey(station)){
		 count = totalFootFall.get(station);
		
		}
		count++;
		totalFootFall.put(station, count);
	}
}
