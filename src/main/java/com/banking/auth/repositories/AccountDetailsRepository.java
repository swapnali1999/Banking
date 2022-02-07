package com.banking.auth.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.banking.auth.entities.AccountDetails;


@Repository
public interface AccountDetailsRepository extends JpaRepository<AccountDetails, Long> {
	@Query("Select a from AccountDetails a where a.accountNumber=?1")
	AccountDetails fetchCustomerByAccNo(String accountNumber);
	
	@Modifying
	@Transactional
    @Query("UPDATE AccountDetails a SET a.accountBalance=?1,a.updateAt=?2 WHERE a.accountNumber=?3 ")
	int updateAccountBalance(long accountBalance, String date, String accountNumber);
	

}
