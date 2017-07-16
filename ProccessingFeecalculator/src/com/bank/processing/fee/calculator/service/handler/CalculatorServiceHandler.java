package com.bank.processing.fee.calculator.service.handler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.bank.processing.fee.calculator.bean.TransactionBean;
import com.bank.processing.fee.calculator.service.CalculatorService;
import com.bank.processing.fee.calculator.service.ICalculatorServiceHandler;
import com.bank.processing.fee.calculator.serviceimpl.CalculatorServiceImpl;

public class CalculatorServiceHandler implements ICalculatorServiceHandler {
	CalculatorService calculatorService = new CalculatorServiceImpl();
	private final SimpleDateFormat dateFormat = new SimpleDateFormat(
			"MM/dd/yyyy");

	@Override
	public List<TransactionBean> generateReport() {

		List<TransactionBean> transactionBeans=calculatorService
				.calculateFee(getTransactionBeanFromFileSystem("Transaction.txt"));
		
		// TODO Auto-generated method stub
		return writeReport(transactionBeans);
	}

	private List<TransactionBean> writeReport(List<TransactionBean> transactionBeans) {
		Collections.sort(transactionBeans,new ReportComparator());
	System.out.println("Report of transaction: " +transactionBeans);
	return transactionBeans;
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
