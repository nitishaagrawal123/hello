package com.wallet.service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.wallet.dao.BankDAO;
import com.wallet.dao.BankDAOImpl;
import com.wallet.dto.Customersss;
import com.wallet.dto.PrintTransactions;
import com.wallet.exception.BankException;
import com.wallet.exception.InvalidAmount;
import com.wallet.exception.InvalidPhoneNumber;
import com.wallet.exception.NameException;

public class BankServiceImpl implements BankService {

	BankDAO dao;

	public BankServiceImpl() {
		dao = new BankDAOImpl();
	}

	@Override
	public boolean validateAll(Customersss c) throws BankException, NameException, InvalidAmount, InvalidPhoneNumber {

		boolean b = false;
		
		if (validateUserName(c.getCustomerName()) == true
				&& validatePhoneNumber(c.getMobileNumber()) == true
				&& validateAmount(c.getAmount()) == true)
			b = true;
		if (!b)
			throw new BankException("Invalid details");
		return b;
	}

	@Override
	public boolean validateUserName(String name) throws NameException {

		Pattern p = Pattern.compile("[A-Z]{1}[a-z]{2,30}");
		Matcher mat = p.matcher(name);
		boolean b = mat.matches();

		if (!b)
			throw new NameException();

		return b;
	}

	@Override
	public boolean validatePhoneNumber(String mobileNo) throws InvalidPhoneNumber {

		Pattern pat = Pattern.compile("[6-9]{1}[0-9]{9}");
		Matcher mat = pat.matcher(mobileNo);
		boolean b = mat.matches();

		if (!b)
			throw new InvalidPhoneNumber();

		return b;
	}

	@Override
	public boolean validateAmount(double amt) throws InvalidAmount {

		Pattern pat = Pattern.compile("[1-9]{1}[0-9.]{0,9}");
		Matcher mat = pat.matcher(String.valueOf(amt));
		boolean b = mat.matches();

		if (!b)
			throw new InvalidAmount();

		return b;
	}

	@Override
	public boolean validateTargetMobNo(String targetMobNo) throws InvalidPhoneNumber {

		Pattern pat = Pattern.compile("[6-9]{1}[0-9]{9}");
		Matcher mat = pat.matcher(targetMobNo);
		boolean b = mat.matches();

		if (!b)
			throw new InvalidPhoneNumber();

		return b;
	}

	@Override
	public Customersss createAccount(Customersss c) throws BankException {
		// TODO Auto-generated method stub
		Customersss create = dao.createAccount(c);
		
		if(create == null)
			throw new BankException("Mobile number doesn't exist");
		return create;
	}

	@Override
	public double showBalance(String mobileno) throws BankException,
			BankException {
		// TODO Auto-generated method stub
		String tranType = "Check balance";
		Customersss bal = dao.getAccount(mobileno);
		if (bal == null)
			throw new BankException("Mobile number doesn't exist");
		dao.loadTransaction(new PrintTransactions(mobileno, tranType, bal.getAmount()));
		return bal.getAmount();
	}

	@Override
	public Customersss fundTransfer(String sourceMobileNo, String targetMobileNo,
			double amount) throws BankException {
		// TODO Auto-generated method stub
		String tranType = "Transfer";
		Customersss sbal = dao.getAccount(sourceMobileNo);
		Customersss tbal = dao.getAccount(targetMobileNo);
		if (sbal == null)
			throw new BankException("Mobile number doesn't exist");
		if (tbal == null)
			throw new BankException("Mobile number doesn't exist");
		double tmp = (sbal.getAmount() - amount);
		if (tmp >= 0) {
			dao.setAccount(targetMobileNo, tbal.getAmount() + amount);
			dao.setAccount(sourceMobileNo, sbal.getAmount() - amount);
		} else {
			throw new BankException(
					"Minimum balance of Rupees greater than zero should be available...");
		}
//		System.out.println(dao.getAccount(sourceMobileNo));
		dao.loadTransaction(new PrintTransactions(sourceMobileNo, tranType, -amount));
		dao.loadTransaction(new PrintTransactions(targetMobileNo, tranType, amount));
		return dao.getAccount(sourceMobileNo);
	}

	@Override
	public Customersss depositAmount(String mobileNo, double amount)
			throws InvalidPhoneNumber, InvalidAmount, BankException {
		// TODO Auto-generated method stub
		String tranType = "Deposit";
		Customersss cDep1 = dao.getAccount(mobileNo);
		if (cDep1 == null)
			throw new BankException("Mobile number doesn't exist");
		boolean c = dao.setAccount(mobileNo, cDep1.getAmount() + amount);
//		System.out.println(c);
		Customersss cDep = dao.getAccount(mobileNo);
		dao.loadTransaction(new PrintTransactions(mobileNo, tranType, amount));
		if (!c)
			throw new BankException("Unable to deposit");
		else
			return cDep;
	}

	@Override
	public Customersss withdrawAmount(String mobileNo, double amount)
			throws BankException {
		// TODO Auto-generated method stub
		String tranType = "Withdraw";
		boolean c = false;
		Customersss cDep1 = dao.getAccount(mobileNo);
		if (cDep1 == null)
			throw new BankException("Mobile number doesn't exist");
		if ((cDep1.getAmount() - amount) >= 0)
			c = dao.setAccount(mobileNo, cDep1.getAmount() - amount);
		Customersss cDep = dao.getAccount(mobileNo);
		dao.loadTransaction(new PrintTransactions(mobileNo, tranType, amount));
		if (!c)
			throw new BankException("Unable to withdraw");
		else
			return cDep;
	}

	@Override
	public List<PrintTransactions> getTransactions(String mobileNo)
			throws BankException, InvalidPhoneNumber {
		// TODO Auto-generated method stub
		
		if(dao.getAccount(mobileNo) == null)
			throw new BankException("Mobile number doesn't exist");
		
		List<PrintTransactions> list = null;
		
		list = dao.getTransactions(mobileNo);
		
		return list;
	}

}
