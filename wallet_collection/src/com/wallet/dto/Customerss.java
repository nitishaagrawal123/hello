package com.wallet.dto;


public class Customerss {
	
	private String customerName;
	private String mobileNumber;
	private double amount;
		
	public Customerss(String name, String mobNo, double amt) {
		// TODO Auto-generated constructor stub
		this.customerName = name;
		this.mobileNumber = mobNo;
		this.amount = amt;
	}
	public Customerss() {
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
		return "CustomerName: " + customerName + ", MobileNumber: "+ mobileNumber + ", Amount: " + amount;
	}
	
	
	
}
