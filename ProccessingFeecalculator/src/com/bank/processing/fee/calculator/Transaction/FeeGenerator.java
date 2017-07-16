package com.bank.processing.fee.calculator.Transaction;

import com.bank.processing.fee.calculator.service.ICalculatorServiceHandler;
import com.bank.processing.fee.calculator.service.handler.CalculatorServiceHandler;

public class FeeGenerator {
public static void main(String[] args) {
	ICalculatorServiceHandler calculatorServiceHandler = new CalculatorServiceHandler();
			calculatorServiceHandler.generateReport();

}


}
