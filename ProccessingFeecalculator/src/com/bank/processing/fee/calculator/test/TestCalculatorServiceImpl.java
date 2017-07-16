package com.bank.processing.fee.calculator.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.bank.processing.fee.calculator.bean.TransactionBean;
import com.bank.processing.fee.calculator.serviceimpl.CalculatorServiceImpl;

public class TestCalculatorServiceImpl {
	CalculatorServiceImpl calculatorServiceImpl = new CalculatorServiceImpl();
	private final SimpleDateFormat dateFormat = new SimpleDateFormat(
			"MM/dd/yyyy");
	@Test
public void 	testTovalidateReportGeneration(){
		
		
		Assert.assertNotNull(calculatorServiceImpl.calculateFee(getTransactionBeanFromFileSystem("C:/Users/Harish/Sapient_ProccessingFeecalculator/Transaction.txt")));
	}
	private List<TransactionBean> getTransactionBeanFromFileSystem(
			String filePath) {
		List<TransactionBean> transactionBeans = new ArrayList<>();
		try {
			FileReader fileReader = new FileReader(filePath);
			BufferedReader buffer = new BufferedReader(fileReader);
			String line = null;
			while (null != (line = buffer.readLine())) {
				transactionBeans.add(populateTransactionBean(line));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return transactionBeans;
	}

	private TransactionBean populateTransactionBean(String line)
			throws ParseException {
		TransactionBean transactionBean = new TransactionBean();
		String[] arrayLine = line.split(",");
		for (int i = 0; i < arrayLine.length; i++) {
			if (i == 0) {
				transactionBean.setTransactionId(arrayLine[i]);
				continue;
			} else if (i == 1) {
				transactionBean.setClientId(arrayLine[i]);
				continue;
			} else if (i == 2) {
				transactionBean.setSecurityId(arrayLine[i]);
				continue;
			} else if (i == 3) {
				transactionBean.setTransactionType(arrayLine[i]);
				continue;
			} else if (i == 4) {
				transactionBean.setTransactionDate(dateFormat
						.parse(arrayLine[i]));
				continue;
			} else if (i == 5) {
				transactionBean.setMarketValue(arrayLine[i]);
				continue;
			} else {
				transactionBean.setPriorityFlag(Boolean.valueOf(arrayLine[i]));
				continue;
			}

		}
		return transactionBean;
	}
}
