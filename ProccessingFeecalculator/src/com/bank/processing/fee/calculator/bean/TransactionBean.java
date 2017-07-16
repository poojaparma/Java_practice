package com.bank.processing.fee.calculator.bean;

import java.util.Date;

public class TransactionBean  {

	private String transactionId;
	private String clientId;

	private String transactionType;
	private Date transactionDate;
	private Boolean priorityFlag;
	 private Boolean isIntraday;
	private Integer processingFee;
	private String securityId;
	private String marketValue;
	private int processingfee;

	public TransactionBean() {

	}

	
	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public Boolean getPriorityFlag() {
		return priorityFlag;
	}

	public void setPriorityFlag(Boolean priorityFlag) {
		this.priorityFlag = priorityFlag;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getSecurityId() {
		return securityId;
	}

	public void setSecurityId(String securityId) {
		this.securityId = securityId;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getMarketValue() {
		return marketValue;
	}

	public void setMarketValue(String marketValue) {
		this.marketValue = marketValue;
	}

	public Boolean getIsIntraday() {
		return isIntraday;
	}

	public void setIsIntraday(Boolean isIntraday) {
		this.isIntraday = isIntraday;
	}

	public int getProcessingfee() {
		return processingfee;
	}

	public void setProcessingfee(int processingfee) {
		this.processingfee = processingfee;
	}


	public Integer getProcessingFee() {
		return processingFee;
	}


	public void setProcessingFee(Integer processingFee) {
		this.processingFee = processingFee;
	}
	public String toString(){
		return this.clientId +this.transactionId +this.transactionType+this.transactionDate;
	}
}
