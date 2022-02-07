package com.banking.auth.utils;

import org.springframework.stereotype.Service;

import com.banking.auth.customerrequest.CustomerRequestForMoneyTransfer;
import com.banking.auth.entities.AccountDetails;
import com.banking.auth.entities.Customers;
import com.banking.auth.exceptions.InvalidRequestException;

@Service
public class Validations {

	public void loginCustomer(Customers customer) {
		// TODO Auto-generated method stub
		if(customer.getEmail().equals("")) {
			throw new InvalidRequestException("email id should not be empty");
		}
		if(customer.getPassword().equals("")) {
			throw new InvalidRequestException("password should not be empty");
		}
		String emailRegex = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
				+ "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
		if(customer.getEmail().matches(emailRegex)==false)
		{
			throw new InvalidRequestException("Invalid email");
		}
		
			
		
		
	}

	public void addBalanceValidations(AccountDetails accountDetails) {
		// TODO Auto-generated method stub
		if(accountDetails.getAccountNumber().equals("")) {
			throw new InvalidRequestException("AccountNumber should not be empty");
		}
		if(accountDetails.getAccountBalance()<=0) {
			throw new InvalidRequestException("Enter valid amount");
		}
		
	}
	
	public void transactionValidations(CustomerRequestForMoneyTransfer requestForMoney) {
		// TODO Auto-generated method stub
		if(requestForMoney.getAccountNumber().equals("")) {
			throw new InvalidRequestException("AccountNumber should not be empty");
		}
		if(requestForMoney.getUserAccountNumber().equals("")) {
			throw new InvalidRequestException("User Account Number should not be empty");
		}
		if(requestForMoney.getAmount()<=0) {
			throw new InvalidRequestException("Enter valid amount to deposit");
		}
		if(requestForMoney.getTransactionPin().equals("")) {
			throw new InvalidRequestException("Enter transaction pin");
		}
	}

	
}
