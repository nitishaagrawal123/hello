package com.wallet.service;

import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.wallet.dao.BankDAO;
import com.wallet.dao.BankDAOImpl;
import com.wallet.dto.Customerss;
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
	public boolean validateAll(Customerss c) throws BankException, NameException, InvalidAmount, InvalidPhoneNumber {

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
	public Customerss createAccount(Customerss c) {
		// TODO Auto-generated method stub
		return dao.createAccount(c);
	}

	@Override
	public double showBalance(String mobileno) throws BankException,
			BankException {
		// TODO Auto-generated method stub
		Customerss bal = dao.getAccount(mobileno);
		if (bal == null)
			throw new BankException("Mobile number doesn't exist");
		return bal.getAmount();
	}

	@Override
	public Customerss fundTransfer(String sourceMobileNo, String targetMobileNo,
			double amount) throws BankException {
		// TODO Auto-generated method stub
		Customerss sbal = dao.getAccount(sourceMobileNo);
		Customerss tbal = dao.getAccount(targetMobileNo);
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
		System.out.println(dao.getAccount(sourceMobileNo));
		return dao.getAccount(sourceMobileNo);
	}

	@Override
	public Customerss depositAmount(String mobileNo, double amount)
			throws InvalidPhoneNumber, InvalidAmount, BankException {
		// TODO Auto-generated method stub
		Customerss cDep1 = dao.getAccount(mobileNo);
		if (cDep1 == null)
			throw new BankException("Mobile number doesn't exist");
		boolean c = dao.setAccount(mobileNo, cDep1.getAmount() + amount);
		System.out.println(c);
		Customerss cDep = dao.getAccount(mobileNo);
		if (!c)
			throw new BankException("Unable to deposit");
		else
			return cDep;
	}

	@Override
	public Customerss withdrawAmount(String mobileNo, double amount)
			throws BankException {
		// TODO Auto-generated method stub
		boolean c = false;
		Customerss cDep1 = dao.getAccount(mobileNo);
		if (cDep1 == null)
			throw new BankException("Mobile number doesn't exist");
		if ((cDep1.getAmount() - amount) >= 0)
			c = dao.setAccount(mobileNo, cDep1.getAmount() - amount);
		Customerss cDep = dao.getAccount(mobileNo);
		if (!c)
			throw new BankException("Unable to withdraw");
		else
			return cDep;
	}

	// @Override
	// public boolean validateKey(String mobNo) throws BankException {
	// // TODO Auto-generated method stub
	// boolean b = false;
	// for (String key : dao.getKeys()) {
	// // System.out.println(key);
	// if (key.equals(mobNo)){
	// // System.out.println(key);
	// b = true;
	// }
	// }if(!b) throw new BankException("Mobile number doesn't exist");
	// return b;
	// }

}
