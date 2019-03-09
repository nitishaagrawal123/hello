package com.wallet.service;

import java.util.List;

import com.wallet.dto.Customersss;
import com.wallet.dto.PrintTransactions;
import com.wallet.exception.BankException;
import com.wallet.exception.InvalidAmount;
import com.wallet.exception.InvalidPhoneNumber;
import com.wallet.exception.NameException;

public interface BankService {
	
	public Customersss createAccount(Customersss c) throws BankException;
	public double showBalance (String mobileno) throws InvalidPhoneNumber, BankException;
	public Customersss fundTransfer (String sourceMobileNo,String targetMobileNo, double amount) throws BankException;
	public Customersss depositAmount (String mobileNo, double amount ) throws InvalidPhoneNumber, InvalidAmount, BankException;
	public Customersss withdrawAmount(String mobileNo, double amount) throws BankException;
	public boolean validateUserName(String name) throws NameException;
	public boolean validatePhoneNumber(String mobNo) throws InvalidPhoneNumber;
	public boolean validateTargetMobNo(String targetMobNo) throws InvalidPhoneNumber;
	public boolean validateAmount(double amt) throws InvalidAmount;
	public boolean validateAll(Customersss c) throws BankException, NameException, InvalidAmount, InvalidPhoneNumber;
	public List<PrintTransactions> getTransactions(String mobileNo) throws BankException, InvalidPhoneNumber;
	
}
