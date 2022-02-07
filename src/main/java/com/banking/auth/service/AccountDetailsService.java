package com.banking.auth.service;


import com.banking.auth.entities.AccountDetails;

public interface AccountDetailsService {

	AccountDetails saveAccountDetails(AccountDetails accountDetails);

	AccountDetails fetchCustomerByAccNo(String accountNumber);
	
    int updateAccountBalance(long accountBalance,String currentDate,String accountNumber);
}