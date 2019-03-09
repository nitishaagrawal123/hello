package com.cg.wallet.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Customer {
	@Id
	private String mobileNumber;
	
	private String customerName;
	
	private double amount;


	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public void fundTransfer(double amount) {
		this.amount = this.amount - amount;
	}

	@Override
	public String toString() {
		return "CustomerName: " + customerName + ", MobileNumber: " + mobileNumber + ", Amount: " + amount;
	}

}
