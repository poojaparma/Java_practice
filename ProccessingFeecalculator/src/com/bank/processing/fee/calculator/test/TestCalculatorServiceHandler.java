package com.bank.processing.fee.calculator.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.bank.processing.fee.calculator.service.handler.CalculatorServiceHandler;

public class TestCalculatorServiceHandler {
	
	CalculatorServiceHandler calculatorServiceHandler = new CalculatorServiceHandler();
	@Test
public void 	testTovalidateReportGeneration(){
		
		Assert.assertNotNull(calculatorServiceHandler.generateReport());
	}

	
}
