package com.wallet.dao;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.wallet.dto.Customerss;
import com.wallet.exception.BankException;

public class BankDAOImpl implements BankDAO {

	Map<String, Customerss> map;

	public BankDAOImpl() {
		map = new HashMap<String, Customerss>();
		map.put("7306451044", new Customerss("Vamshi", "7306451044", 500));
		map.put("9963357591", new Customerss("Sindhu", "9963357591", 1000));
	}

	@Override
	public Customerss createAccount(Customerss c) {
		// TODO Auto-generated method stub
		map.put(c.getMobileNumber(), c);
		return c;
	}

	@Override
	public Customerss getAccount(String mobileno) {
		// TODO Auto-generated method stub
		Customerss cShow = map.get(mobileno);
		return cShow;
	}

	@Override
	public boolean setAccount(String mobileNo, double amount) {
		// TODO Auto-generated method stub
		Customerss cSet = map.get(mobileNo);
		cSet.setAmount(amount);
		System.out.println(cSet);
		map.put(mobileNo, cSet);
		return true;
	}

	@Override
	public Set<String> getKeys() {
		// TODO Auto-generated method stub
		return map.keySet();
	}

}
