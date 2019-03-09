package com.cg.wallet.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.cg.wallet.beans.Customer;
import com.cg.wallet.beans.PrintTransactions;


public interface IBankRepo {
	public Customer createAccount(Customer c);

	public Customer getAccount(String mobileno);
	
	

	public boolean setAccount(String mobileNo, double amount);

	public double showBalance(String mobileno);

	public Customer fundTransfer(String sourceMobileNo, String targetMobileNo, double amount);

	public Customer depositAmount(String mobileNo, double amount);

	public Customer withdrawAmount(String mobileNo, double amount);
/*
public List<PrintTransactions> getTransactions(String mobileNo);

	public void loadTransaction(PrintTransactions pt);
*/
}
