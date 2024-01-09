package com.banking.auth.service;

import com.banking.auth.entities.Customers;

public interface CustomerService {

	Customers createUser(Customers customer);

	Customers fetchCustomerByEmail(String email);

	Customers fetchCustomerByAccountNo(String accountNumber);

	Customers updateCustomer(Customers cust);

	Customers sendOtp(Customers record);

	int ResetPassword(String new_password,String customer_email);
	System.out.println("");
	
		
	

}
