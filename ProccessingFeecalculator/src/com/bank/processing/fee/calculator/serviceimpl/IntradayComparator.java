package com.bank.processing.fee.calculator.serviceimpl;

import java.util.Comparator;

import com.bank.processing.fee.calculator.bean.TransactionBean;

public class IntradayComparator implements Comparator<TransactionBean> {
	private static final String SELL="SELL";
	private static final String BUY="BUY";	
	@Override
	public int compare(TransactionBean o1, TransactionBean o2) {

		if(
			o1.getClientId().equalsIgnoreCase(o2.getClientId()) && 
			 o1.getSecurityId().equalsIgnoreCase(o2.getSecurityId()) &&
			 o1.getTransactionDate().equals(o2.getTransactionDate())){
			
			if(o1.getTransactionType().equalsIgnoreCase(BUY) && o2.getTransactionType().equalsIgnoreCase(SELL)||o2.getTransactionType().equalsIgnoreCase(SELL) && o1.getTransactionType().equalsIgnoreCase(BUY)){
				
				o1.setIsIntraday(true);
				o2.setIsIntraday(true);
				
			
		}
		return 0;
	
	}
		return -1;

}
}