package com.banking.auth.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.auth.entities.CustomerTransaction;
import com.banking.auth.repositories.CustomerTransactionRepository;
import com.banking.auth.service.CustomerTransactionService;
@Service


public class CustomerTransactionServiceImpl implements CustomerTransactionService {
	@Autowired
	CustomerTransactionRepository customerTransactionRepository;
	@Override
	public CustomerTransaction addsenderlogs(CustomerTransaction senderTransaction) {
		// TODO Auto-generated method stub
		return customerTransactionRepository.save(senderTransaction);
	}
	@Override
	public CustomerTransaction addreceiverlogs(CustomerTransaction receiverTransaction) {
		// TODO Auto-generated method stub
		return customerTransactionRepository.save(receiverTransaction);
	}

}
