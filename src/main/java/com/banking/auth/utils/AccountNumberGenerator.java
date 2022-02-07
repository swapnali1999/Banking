package com.banking.auth.utils;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class AccountNumberGenerator {
	public long AccNumber()
	{
	
	 Random random=new Random();
     long accountNumber = (long)(100000000000L + random.nextFloat() * 90000000000L);
     return accountNumber; 
}
	public int GenerateTransactionPin()
	{
		Random random=new Random();
		int transactionPin= 1000+random.nextInt(9999);
		return transactionPin;
	}
}

