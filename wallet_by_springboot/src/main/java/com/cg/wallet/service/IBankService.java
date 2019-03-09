package com.cg.wallet.service;

import java.util.List;

import com.cg.wallet.beans.Customer;
import com.cg.wallet.beans.PrintTransactions;


public interface IBankService {
	public Customer createAccount(Customer c);

	public double showBalance(String mobileno);

	public Customer fundTransfer(String sourceMobileNo, String targetMobileNo, double amount);

	public Customer depositAmount(String mobileNo, double amount);

	public Customer withdrawAmount(String mobileNo, double amount);

	public boolean validateUserName(String name);

	public boolean validatePhoneNumber(String mobNo);

	public boolean validateTargetMobNo(String targetMobNo);

	public boolean validateAmount(double amt);

	public boolean validateAll(Customer c);
/*
	public List<PrintTransactions> getTransactions(String mobileNo);
*/
}
