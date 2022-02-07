package com.banking.auth.serviceimpl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.auth.entities.AccountDetails;
import com.banking.auth.repositories.AccountDetailsRepository;
import com.banking.auth.service.AccountDetailsService;
@Service
public class AccountDetailsServiceImpl implements AccountDetailsService {
    @Autowired
    AccountDetailsRepository accountDetailsRepository;
	@Override
	public AccountDetails saveAccountDetails(AccountDetails accountDetails) {
		// TODO Auto-generated method stub
		return accountDetailsRepository.save(accountDetails);
	}
	
	@Override
	public AccountDetails fetchCustomerByAccNo(String accountNumber) {
		// TODO Auto-generated method stub
		return accountDetailsRepository.fetchCustomerByAccNo(accountNumber);
	}

	@Override
	public int updateAccountBalance(long accountBalance, String date, String accountNumber) {
		// TODO Auto-generated method stub
		return accountDetailsRepository.updateAccountBalance(accountBalance,date,accountNumber);
	}
	

}
