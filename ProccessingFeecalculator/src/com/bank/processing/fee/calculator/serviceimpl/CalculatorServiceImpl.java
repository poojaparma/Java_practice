package com.bank.processing.fee.calculator.serviceimpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.bank.processing.fee.calculator.bean.TransactionBean;
import com.bank.processing.fee.calculator.service.CalculatorService;

public class CalculatorServiceImpl implements CalculatorService {
	private static final int INTER_DAY_FEE=10;
	private static final int HIGH_PRIORITY_FEE=500;
	private static final int NORMAL_PRIORITY_SELL_WITHDRAW=100;
	private static final int NORMAL_PRIORITY_BUY__DEPOSIT=50;
	private static final String SELL="SELL";
	private static final String BUY="BUY";
	private static final String DEPOSIT="DEPOSIT";
	private static final String WITHDRAW="_WITHDRAW";

	@Override
	public List<TransactionBean> calculateFee(
			List<TransactionBean> transactionBeans) {
		List<TransactionBean> transactionList = new ArrayList<TransactionBean>();
		Collections.sort(transactionBeans,new IntradayComparator());
		for (TransactionBean transactionBean : transactionBeans){
			// intraday or normal transaction

			transactionList.add(caclulateProcessingFee(transactionBean));
		}
		return transactionList;
	}
	
	private TransactionBean caclulateProcessingFee(TransactionBean transactionBean
			) {
		
				if(transactionBean.getIsIntraday()!=null&&transactionBean.getIsIntraday()){
					transactionBean.setProcessingfee(INTER_DAY_FEE);
				}else if(transactionBean.getPriorityFlag()){
					transactionBean.setProcessingfee(HIGH_PRIORITY_FEE);
				}else if (transactionBean.getPriorityFlag()){
					 if(WITHDRAW.equalsIgnoreCase(transactionBean.getTransactionType())||SELL.equalsIgnoreCase(transactionBean.getTransactionType())){
						transactionBean.setProcessingfee(NORMAL_PRIORITY_SELL_WITHDRAW);
					}else if(BUY.equalsIgnoreCase(transactionBean.getTransactionType())||DEPOSIT.equalsIgnoreCase(transactionBean.getTransactionType())){
						transactionBean.setProcessingfee(NORMAL_PRIORITY_BUY__DEPOSIT);
					}
				}
				return transactionBean;
	}
	
	
}
