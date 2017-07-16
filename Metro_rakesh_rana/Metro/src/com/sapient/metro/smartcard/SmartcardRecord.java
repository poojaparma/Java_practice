package com.sapient.metro.smartcard;

import com.spaient.metro.smartcard.report.STATION;


public class SmartcardRecord {
private STATION  sourcestation;
private STATION  destName;
private double fare;
public STATION getSourcestation() {
	return sourcestation;
}
public void setSourcestation(STATION sourcestation) {
	this.sourcestation = sourcestation;
}
public STATION getDestName() {
	return destName;
}
public void setDestName(STATION destName) {
	this.destName = destName;
}
public double getFare() {
	return fare;
}
public void setFare(double fare) {
	this.fare = fare;
}

}
