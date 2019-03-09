package com.wallet.ui;

import java.util.Scanner;

import com.wallet.dto.Customerss;
import com.wallet.exception.BankException;
import com.wallet.exception.InvalidAmount;
import com.wallet.exception.InvalidPhoneNumber;
import com.wallet.exception.NameException;
import com.wallet.service.BankService;
import com.wallet.service.BankServiceImpl;

public class MainMenu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		BankService service = new BankServiceImpl();

		int option;
		do {

			System.out.println("1. Create new customer account...");
			System.out.println("2. Show user's balance...");
			System.out.println("3. Fund Transfer...");
			System.out.println("4. Deposit amount into your account...");
			System.out.println("5. Withdraw amount from your account...");
			System.out.println("6. Exit...");
			option = sc.nextInt();

			switch (option) {
			case 1:

				System.out.println("Enter Customer Name: ");
				String name = sc.next();
				System.out.println("Enter Mobile Number: ");
				String mobNo = sc.next();
				System.out.println("Enter Initial Amount: ");
				double amt = sc.nextDouble();

				Customerss c = new Customerss(name, mobNo, amt);
				Customerss c1 = null;
				try {
					if(service.validateAll(c))
							c1 = service.createAccount(c);
					System.out.println("Successfully created new account for "
							+ c1.getCustomerName() + " with " + "Mobile Number "
							+ c1.getMobileNumber());
				} catch (BankException | NameException | InvalidAmount | InvalidPhoneNumber e) {
					// TODO Auto-generated catch block
					System.err.println(e);
				}
				break;

			case 2:

				System.out.println("Enter an existing mobile number: ");
				String mobNoShow = sc.next();

				double bal = 0;
				try {
					if(service.validatePhoneNumber(mobNoShow))
						bal = service.showBalance(mobNoShow);
					System.out.println("Available balance for the mobile number "
							+ mobNoShow + " is " + bal);
				} catch (InvalidPhoneNumber | BankException e) {
					// TODO Auto-generated catch block
					System.err.println(e);
				}

				break;

			case 3:

				Customerss funds = null;

				System.out.println("Enter your mobile number: ");
				String sourceMobileNo = sc.next();
				System.out.println("Enter recipient's mobile number: ");
				String targetMobileNo = sc.next();
				System.out.println("Enter the amount that to be transfered: ");
				double amount = sc.nextDouble();
				
				try {
					if(service.validatePhoneNumber(sourceMobileNo)
							&& service.validateTargetMobNo(targetMobileNo)
							&& service.validateAmount(amount))
						funds = service.fundTransfer(sourceMobileNo, targetMobileNo, amount);
					
					System.out.println("Successfully transfered Rs." + amount
							+ " to " + targetMobileNo + ".\n"
							+ "Available balance is Rs. " + funds.getAmount());
					
				} catch (InvalidPhoneNumber | InvalidAmount
						| BankException e) {
					// TODO Auto-generated catch block
					System.err.println(e);
				}

				break;

			case 4:

				System.out.println("Enter your mobile number: ");
				String mobNoDep = sc.next();
				System.out.println("Enter amount that to be deposited: ");
				double amtDep = sc.nextDouble();
				Customerss cDep = null;
				try {
					if(service.validatePhoneNumber(mobNoDep) && service.validateAmount(amtDep))
						cDep = service.depositAmount(mobNoDep, amtDep);
					System.out.println("Your current balance is Rs."
							+ cDep.getAmount());
				} catch (InvalidAmount | InvalidPhoneNumber
						| BankException e) {
					// TODO Auto-generated catch block
					System.err.println(e);
				}
				break;

			case 5:

				System.out.println("Enter your mobile number: ");
				String mobNoWiDraw = sc.next();
				System.out.println("Enter amount that to be withdrawn: ");
				double amtWiDraw = sc.nextDouble();

				Customerss cWD = null;
				try {
					if(service.validatePhoneNumber(mobNoWiDraw) && service.validateAmount(amtWiDraw))
						cWD = service.withdrawAmount(mobNoWiDraw, amtWiDraw);
					System.out.println("Your current balance is Rs. "
							+ cWD.getAmount());
				} catch (InvalidAmount | BankException | InvalidPhoneNumber e) {
					// TODO Auto-generated catch block
					System.err.println(e);
				}
				break;

			default:
			case 6:
				break;
			}

		} while (option != 6);

		sc.close();
	}

}
