package com.budget.controller;

import java.io.Serializable;
import java.util.Vector;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

//@XmlRootElement(name = "alarm")
@JsonIgnoreProperties(ignoreUnknown = true)
public class HomeBudget  {
	/**
	 * 
	 */
	private String dateI = null;
	private String dailyExpenditure = null;
	private String medicalExpenses = null;
	private String kidExpenses = null;
	private String travellingExpenses = null;
	private String vehicleExpenses = null;
	private String billPayments = null;
	private String rentEmi = null;
	private String cosmeticsItems = null;
	private String officeExpenses = null;
	public String getDateI() {
		return dateI;
	}

	public void setDateI(String dateI) {
		this.dateI = dateI;
	}

	public String getDailyExpenditure() {
		return dailyExpenditure;
	}

	public void setDailyExpenditure(String dailyExpenditure) {
		this.dailyExpenditure = dailyExpenditure;
	}

	public String getMedicalExpenses() {
		return medicalExpenses;
	}

	public void setMedicalExpenses(String medicalExpenses) {
		this.medicalExpenses = medicalExpenses;
	}

	public String getKidExpenses() {
		return kidExpenses;
	}

	public void setKidExpenses(String kidExpenses) {
		this.kidExpenses = kidExpenses;
	}

	public String getTravellingExpenses() {
		return travellingExpenses;
	}

	public void setTravellingExpenses(String travellingExpenses) {
		this.travellingExpenses = travellingExpenses;
	}

	public String getVehicleExpenses() {
		return vehicleExpenses;
	}

	public void setVehicleExpenses(String vehicleExpenses) {
		this.vehicleExpenses = vehicleExpenses;
	}

	public String getBillPayments() {
		return billPayments;
	}

	public void setBillPayments(String billPayments) {
		this.billPayments = billPayments;
	}

	public String getRentEmi() {
		return rentEmi;
	}

	public void setRentEmi(String rentEmi) {
		this.rentEmi = rentEmi;
	}

	public String getCosmeticsItems() {
		return cosmeticsItems;
	}

	public void setCosmeticsItems(String cosmeticsItems) {
		this.cosmeticsItems = cosmeticsItems;
	}

	public String getOfficeExpenses() {
		return officeExpenses;
	}

	public void setOfficeExpenses(String officeExpenses) {
		this.officeExpenses = officeExpenses;
	}

	public String toString() {
		return "Date: "+dateI +" Medical: " +medicalExpenses + " Kid: "+ kidExpenses +  " billPayments: "+ billPayments
				+  " travellingExpenses: "+ travellingExpenses + " vehicleExpenses: "+ vehicleExpenses + " rentEmi: "+ rentEmi
				+ " cosmeticsItems: "+ cosmeticsItems + " officeExpenses: "+ officeExpenses + " dailyExpenditure: "+ dailyExpenditure;
	}

	
	/*
	 * public String getPort() { return port; } public void setPort(String port)
	 * { this.port = port; } public String getST() { return ST; } public void
	 * setST(String sT) { ST = sT; } public String getWavelength() { return
	 * wavelength; } public void setWavelength(String wavelength) {
	 * this.wavelength = wavelength; } private String shelf=null; private String
	 * node =null; private String date=null ; private String pathWidth=null;
	 * private String Description =null; private String condition=null ; private
	 * String Severity=null; private String SA =null; private String slot=null ;
	 * private String direction=null;
	 * 
	 * public String getDirection() { return direction; } public void
	 * setDirection(String direction) { this.direction = direction; } public
	 * String getNew() { return isnew; } public void setIsnew(String isnew) {
	 * this.isnew = isnew; } public String getLocation() { return location; }
	 * public void setLocation(String location) { this.location = location; }
	 * public String getEqType() { return eqType; } public void setEqType(String
	 * string) { this.eqType = string; } public String getObject() { return
	 * object; } public void setObject(String object) { this.object = object; }
	 * public String getShelf() { return shelf; } public void setShelf(String
	 * shelf) { this.shelf = shelf; } public String getNode() { return node; }
	 * public void setNode(String node) { this.node = node; } public String
	 * getDate() { return date; } public void setDate(String date) { this.date =
	 * date; } public String getPathWidth() { return pathWidth; } public void
	 * setPathWidth(String pathWidth) { this.pathWidth = pathWidth; } public
	 * String getDescription() { return Description; } public void
	 * setDescription(String description) { Description = description; } public
	 * String getCondition() { return condition; } public void
	 * setCondition(String condition) { this.condition = condition; } public
	 * String getSeverity() { return Severity; } public void setSeverity(String
	 * severity) { Severity = severity; } public String getSA() { return SA; }
	 * public void setSA(String sA) { SA = sA; } public String getSlot() {
	 * return slot; } public void setSlot(String slot) { this.slot = slot; }
	 */
}
