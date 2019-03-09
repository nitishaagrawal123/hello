package com.wallet.dao;

import java.util.Set;

import com.wallet.dto.Customerss;

public interface BankDAO {
	
	public Customerss createAccount(Customerss c);
	public Customerss getAccount(String mobileno);
	public boolean setAccount(String mobileNo, double amount);
	public Set<String> getKeys();

}
