package com.cg.wallet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.wallet.beans.Customer;
import com.cg.wallet.beans.PrintTransactions;
import com.cg.wallet.service.IBankService;

@RestController
public class WalletController {

	@Autowired
	IBankService service;

	@RequestMapping(value="/createAccount",produces = "application/json",method=RequestMethod.POST)
	public Customer createAccount(@RequestBody Customer customer) {
		Customer customer1 = service.createAccount(customer);
		return customer1;

	}

	@RequestMapping(value = "/showBalance/{mobileNumber}", consumes = "application/json", produces = "application/json", method = RequestMethod.GET)
	public double showBalance(@PathVariable String mobileNumber) {
		double customer1 = service.showBalance(mobileNumber);
		return customer1;
	}

	@RequestMapping(value = "/depositAmount/{mobileNumber}/{amount}", consumes = "application/json", produces = "application/json", method = RequestMethod.GET)
	public Customer depositAmount(@PathVariable String mobileNumber, @PathVariable double amount) {
		Customer customer1 = service.depositAmount(mobileNumber, amount);
		return customer1;
	}

	@RequestMapping(value = "/withdrawAmount/{mobileNumber}/{amount}", consumes = "application/json", produces = "application/json", method = RequestMethod.GET)
	public Customer withdrawAmount(@PathVariable String mobileNumber,@PathVariable double amount) {
		Customer customer1 = service.withdrawAmount(mobileNumber, amount);
		return customer1;
	}

	@RequestMapping(value = "/fundTransfer/{sourceMobileNo}/{targetMobileNo}/{amount}", consumes = "application/json", produces = "application/json", method = RequestMethod.GET)
	public Customer fundTransfer(@PathVariable String sourceMobileNo,@PathVariable String targetMobileNo,@PathVariable double amount) {
		Customer customer1 = service.fundTransfer(sourceMobileNo, targetMobileNo, amount);
		return customer1;

	}
	/*
	@RequestMapping(value = "/printTransactions", produces = "application/json")
	public List<PrintTransactions> getTransactions(@PathVariable String mobileNo) {
		List<PrintTransactions> list = service.getTransactions(mobileNo);
		return list;
	}
	*/
	
}
