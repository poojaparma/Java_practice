package com.bank.processing.fee.calculator.service.handler;

import java.util.Comparator;

import com.bank.processing.fee.calculator.bean.TransactionBean;

public class ReportComparator implements Comparator<TransactionBean> {
//clinet id,transcation type,transaction date,flag
	@Override
	public int compare(TransactionBean o1, TransactionBean o2) {
if(o1.getClientId().equalsIgnoreCase(o2.getClientId())){
	if(o1.getTransactionType().equalsIgnoreCase(o2.getTransactionType())){
		if(o1.getTransactionDate().toString().equalsIgnoreCase(o2.getTransactionDate().toString())){
			if(o1.getPriorityFlag()==o2.getPriorityFlag()){
				
			}else{
				return 0;
			}
		}else{
			return -1;
		}
	}else{
		return -1;
	}
}else{
	return -1;
}
	

	return -1;
	

}
}