package com.wallet.exception;

public class NameException extends Exception{
	public NameException() {
		// TODO Auto-generated constructor stub
		super("*****Invalid Name declaration*****"
				+ "First letter should be capital remaining should be small letter... :)");
	}
}
