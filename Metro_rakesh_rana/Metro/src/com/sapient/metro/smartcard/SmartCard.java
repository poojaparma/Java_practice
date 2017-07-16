package com.sapient.metro.smartcard;


public class SmartCard {
private int cardNumber;
private double balance;
private double security;
private SmartcardRecord record;
public int getCardNumber() {
	return cardNumber;
}
public void setCardNumber(int cardNumber) {
	this.cardNumber = cardNumber;
}
public double getBalance() {
	return balance;
}
public void setBalance(double balance) {
	this.balance = balance;
}
public double getSecurity() {
	return security;
}
public void setSecurity(double security) {
	this.security = security;
}
public SmartcardRecord getRecord() {
	return record;
}
public void setRecord(SmartcardRecord record) {
	this.record = record;
}

}
