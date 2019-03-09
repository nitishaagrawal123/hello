package com.wallet.dao;

import java.util.List;
import java.util.Set;

import com.wallet.dto.Customersss;
import com.wallet.dto.PrintTransactions;
import com.wallet.exception.BankException;
import com.wallet.exception.InvalidPhoneNumber;

public interface BankDAO {
	
	public Customersss createAccount(Customersss c) throws BankException;
	public Customersss getAccount(String mobileno);
	public boolean setAccount(String mobileNo, double amount);
	public List<PrintTransactions> getTransactions(String mobileNo) throws BankException, InvalidPhoneNumber;
	public void loadTransaction(PrintTransactions pt);

}
