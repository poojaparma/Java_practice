package com.bank.processing.fee.calculator.service;

import java.util.List;

import com.bank.processing.fee.calculator.bean.TransactionBean;

public interface CalculatorService {

	List<TransactionBean>	calculateFee(List<TransactionBean> list);
}
