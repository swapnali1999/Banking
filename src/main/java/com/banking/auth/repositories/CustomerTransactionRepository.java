package com.banking.auth.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banking.auth.entities.AccountDetails;
import com.banking.auth.entities.CustomerTransaction;
@Repository
public interface CustomerTransactionRepository extends JpaRepository <CustomerTransaction,Long> {
	
	
	 

}
