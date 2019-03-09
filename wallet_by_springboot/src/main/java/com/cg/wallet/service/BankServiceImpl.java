package com.cg.wallet.service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.wallet.beans.Customer;
import com.cg.wallet.beans.PrintTransactions;
import com.cg.wallet.repo.BankRepo;
import com.cg.wallet.repo.IBankRepo;
@Transactional
@Service("service")
public class BankServiceImpl implements IBankService {
	
	
	@Autowired
	IBankRepo dao;

	public IBankRepo getDao() {
		return dao;
	}

	public void setDao(IBankRepo dao) {
		this.dao = dao;
	}
/*
	public BankServiceImpl() {
		dao = new BankRepo();
	}
	*/

	@Override
	public boolean validateAll(Customer c){

		boolean b = false;
		
		if (validateUserName(c.getCustomerName()) == true
				&& validatePhoneNumber(c.getMobileNumber()) == true
				&& validateAmount(c.getAmount()) == true)
			b = true;

		return b;
	}

	@Override
	public boolean validateUserName(String name)  {

		Pattern p = Pattern.compile("[A-Z]{1}[a-z]{2,30}");
		Matcher mat = p.matcher(name);
		boolean b = mat.matches();

		return b;
	}

	@Override
	public boolean validatePhoneNumber(String mobileNo){

		Pattern pat = Pattern.compile("[6-9]{1}[0-9]{9}");
		Matcher mat = pat.matcher(mobileNo);
		boolean b = mat.matches();

		return b;
	}

	@Override
	public Customer createAccount(Customer c) {
		// TODO Auto-generated method stub
		return dao.createAccount(c);
	}

	@Override
	public double showBalance(String mobileno) {
	
		return dao.showBalance(mobileno);
	}
	
	

	@Override
	public Customer fundTransfer(String sourceMobileNo, String targetMobileNo, double amount) {
		// TODO Auto-generated method stub
		return dao.fundTransfer(sourceMobileNo,targetMobileNo,amount);
	}

	@Override
	public Customer depositAmount(String mobileNo, double amount) {
	
		return dao.depositAmount(mobileNo,amount);
	}

	@Override
	public Customer withdrawAmount(String mobileNo, double amount) {
		
		return dao.withdrawAmount(mobileNo,amount);
	}

	@Override
	public boolean validateTargetMobNo(String targetMobNo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean validateAmount(double amt) {
		// TODO Auto-generated method stub
		return false;
	}
/*
	@Override
	public List<PrintTransactions> getTransactions(String mobileNo) {
		// TODO Auto-generated method stub
		return dao.getTransactions(mobileNo);
	}
	*/
}
