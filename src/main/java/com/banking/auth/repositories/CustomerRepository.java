package com.banking.auth.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.banking.auth.entities.Customers;
@Repository
public interface CustomerRepository extends JpaRepository<Customers,Long> {
	
	@Query("SELECT c FROM Customers c WHERE c.email = ?1")
	Customers fetchCustomerByEmail(String email);
    
	@Query("SELECT c FROM Customers c WHERE c.accountNumber=?1")
	Customers fetchCustomerByAccountNo(String accountNumber);

	@Modifying 

    @Transactional



    @Query("UPDATE Customers c SET c.password=?1 WHERE c.email=?2")



    int savepassword(String pasword, String email);

	
}
