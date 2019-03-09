package com.wallet.service;

import com.wallet.dto.Customerss;
import com.wallet.exception.BankException;
import com.wallet.exception.InvalidAmount;
import com.wallet.exception.InvalidPhoneNumber;
import com.wallet.exception.NameException;

public interface BankService {
	
	public Customerss createAccount(Customerss c) throws BankException;
	public double showBalance (String mobileno) throws InvalidPhoneNumber, BankException;
	public Customerss fundTransfer (String sourceMobileNo,String targetMobileNo, double amount) throws BankException;
	public Customerss depositAmount (String mobileNo, double amount ) throws InvalidPhoneNumber, InvalidAmount, BankException;
	public Customerss withdrawAmount(String mobileNo, double amount) throws BankException;
	public boolean validateUserName(String name) throws NameException;
	public boolean validatePhoneNumber(String mobNo) throws InvalidPhoneNumber;
	public boolean validateTargetMobNo(String targetMobNo) throws InvalidPhoneNumber;
	public boolean validateAmount(double amt) throws InvalidAmount;
	public boolean validateAll(Customerss c) throws BankException, NameException, InvalidAmount, InvalidPhoneNumber;
//	public boolean validateKey(String mobNo) throws BankException;
	
}
