package com.banking.auth.serviceimpl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.banking.auth.entities.Customers;
import com.banking.auth.repositories.CustomerRepository;
import com.banking.auth.service.CustomerService;
import com.banking.auth.utils.AccountNumberGenerator;
@Service
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	AccountNumberGenerator accountnumber;
	@Autowired
	PasswordEncoder passwordEncoder;
	@Override
	public Customers createUser(Customers customer) {
		// TODO Auto-generated method stub
		customer.setAccountNumber(""+accountnumber.AccNumber());
		customer.setTransactionPin(""+accountnumber.GenerateTransactionPin());
		customer.setStatus("1");
		customer.setCreatedAt(""+new Date());
		customer.setUpdatedAt(""+new Date());
		//String encodedPassword=passwordEncoder.encode(customer.getPassword());
		customer.setPassword(passwordEncoder.encode(customer.getPassword()));
		return customerRepository.save(customer);
		
	}

	@Override
	public Customers fetchCustomerByEmail(String email) {
		// TODO Auto-generated method stub
		return customerRepository.fetchCustomerByEmail(email);
	}

	@Override
	public Customers fetchCustomerByAccountNo(String accountNumber) {
		// TODO Auto-generated method stub
		return customerRepository.fetchCustomerByAccountNo(accountNumber);
	}

	@Override
	public Customers updateCustomer(Customers cust) {
		// TODO Auto-generated method stub	
		return customerRepository.save(cust);
	}

	@Override
	public Customers sendOtp(Customers record) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public int ResetPassword(String new_password,String customer_email) {
		// TODO Auto-generated method stub
		return customerRepository.savepassword(new_password,customer_email);
		
	}
	
	

}
