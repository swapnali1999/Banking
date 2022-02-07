package com.banking.auth.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banking.auth.customerrequest.CustomerRequestForMoneyTransfer;
import com.banking.auth.customerrequest.RequestForPassword;
import com.banking.auth.customerresponse.CustomerResponseForBalance;
import com.banking.auth.customerresponse.CustomerResponseUpdate;
import com.banking.auth.customerresponse.CustomerResponseforCustomerRegister;
import com.banking.auth.entities.AccountDetails;
import com.banking.auth.entities.CustomerTransaction;
import com.banking.auth.entities.Customers;
import com.banking.auth.service.AccountDetailsService;
import com.banking.auth.service.CustomerService;
import com.banking.auth.service.CustomerTransactionService;
import com.banking.auth.serviceimpl.MailServiceImpl;
import com.banking.auth.utils.AccountNumberGenerator;
import com.banking.auth.utils.Validations;

@RestController

@RequestMapping("/customer/auth")
public class CustomerAuthenticationController {
	

	@Autowired
	CustomerService customerService;
	@Autowired
	 CustomerTransactionService customerTransactionService;
	
	@Autowired
	Validations validation;
	@Autowired
	MailServiceImpl mailServiceImpl;
	
	@Autowired
	AccountNumberGenerator accountnumber;

	
	
	
	@Autowired
	AccountDetailsService accountDetailsService;
	@Autowired
	PasswordEncoder encoder;

	@PostMapping("/registerCustomer")
	
	public ResponseEntity<Object> registerCustomer(@RequestBody Customers customer){
		Customers emailfetched=customerService.fetchCustomerByEmail(customer.getEmail());
		if(emailfetched==null) {
	    Customers data=customerService.createUser(customer);
	    AccountDetails accountDetails=new AccountDetails();
	    accountDetails.setAccountNumber(data.getAccountNumber());
	    accountDetails.setCreatedAt(data.getCreatedAt());
	    accountDetails.setUpdateAt(data.getUpdatedAt());
	    accountDetails.setCustomerId(data);
	    accountDetails.setStatus(data.getStatus());
	    accountDetails.setBranchName("pune");
	    accountDetails.setAccountBalance(0);
	    accountDetails.setIfsc("parkar2022");
	    AccountDetails details=accountDetailsService.saveAccountDetails(accountDetails);
	    
	    
		CustomerResponseforCustomerRegister responsestructure= new CustomerResponseforCustomerRegister(new Date(),"User Created Successfully","200",data,details);
		
		return new ResponseEntity<Object>(responsestructure,HttpStatus.OK);
	}else
	{
		return new ResponseEntity<Object>("Email already exists",HttpStatus.OK);
	}
	}

	@CrossOrigin
	 @PostMapping("/addBalance")
	 public ResponseEntity<Object> addBalance(@RequestBody AccountDetails accountDetails){
		 validation.addBalanceValidations(accountDetails);
		 AccountDetails fetchedAccountDetails=accountDetailsService.fetchCustomerByAccNo(accountDetails.getAccountNumber());
		 if(fetchedAccountDetails!=null) {
			 long accountBalance=fetchedAccountDetails.getAccountBalance()+accountDetails.getAccountBalance();
			 String currentDate=""+new Date();
			 accountDetailsService.updateAccountBalance(accountBalance,currentDate,accountDetails.getAccountNumber());
			 CustomerResponseForBalance responsestructure= new CustomerResponseForBalance(new Date(),"Account balance updated successfully","200",accountDetails);
			 return new ResponseEntity<Object>(responsestructure,HttpStatus.OK);
		 }else
			{ 
				return new ResponseEntity<Object>("Account not found",HttpStatus.OK);
			}
		 
	 }
	 
	 
	 @PostMapping("UpdateCustomer")
	 public ResponseEntity<Object>UpdateCustomer(@RequestBody Customers cust){
		 Customers customer_acc=customerService.fetchCustomerByAccountNo(cust.getAccountNumber());
		 if(customer_acc!=null) {
		 customer_acc.setFirstName(cust.getFirstName());
		 customer_acc.setMiddleName(cust.getMiddleName());
		 customer_acc.setLastName(cust.getLastName());
		 customer_acc.setAddress(cust.getAddress());
		 Customers updateCustomer=customerService.updateCustomer(customer_acc);
		 return new ResponseEntity<Object>("Account updated successfully",HttpStatus.OK);
		 
	 }else {
		 return new ResponseEntity<Object>("Account not found",HttpStatus.OK);
	 }
	 }


	 
	 @PostMapping("/transferMoney")
	 public ResponseEntity<Object>transferMoney(@RequestBody CustomerRequestForMoneyTransfer requestForMoney){
		 validation.transactionValidations(requestForMoney);
		 Customers customer_acc=customerService.fetchCustomerByAccountNo(requestForMoney.getAccountNumber());
		 Customers User_customer_acc=customerService.fetchCustomerByAccountNo(requestForMoney.getUserAccountNumber());
		 AccountDetails fetchedAccountDetails=accountDetailsService.fetchCustomerByAccNo(requestForMoney.getAccountNumber());
		 AccountDetails fetchedUserAccountDetails=accountDetailsService.fetchCustomerByAccNo(requestForMoney.getUserAccountNumber());
		 if(fetchedAccountDetails!=null && fetchedUserAccountDetails!=null) {
			 
		   if (fetchedAccountDetails.getAccountBalance()>=requestForMoney.getAmount())
			   
			   	   { 
			   if(fetchedAccountDetails.getBranchName().equals(requestForMoney.getBranchName())) {
				   if(fetchedAccountDetails.getIfsc().equals(requestForMoney.getIfsc())) {
					   if(customer_acc.getTransactionPin().equals(requestForMoney.getTransactionPin())){
	                     String sender=customer_acc.getFirstName(); 
	                     String receiver=User_customer_acc.getFirstName();
	                     
						  long Sender_bal= fetchedAccountDetails.getAccountBalance()-requestForMoney.getAmount();
						  String currentDate=""+new Date();
						 
						  accountDetailsService.updateAccountBalance(Sender_bal,currentDate,requestForMoney.getAccountNumber());
						 // String date=""+dateFormat.format(new Date());
						  
						  CustomerTransaction senderTransaction=new CustomerTransaction();
						  senderTransaction.setAccountNumber(customer_acc.getAccountNumber());
						  senderTransaction.setUserAccountNumber(User_customer_acc.getAccountNumber());
						  senderTransaction.setAmount(requestForMoney.getAmount());
						  
						  senderTransaction.setUpdatedAt(currentDate);
						  senderTransaction.setCreatedAt(currentDate);
						  senderTransaction.setStatus("Debited successfully");
						  customerTransactionService.addsenderlogs(senderTransaction);
						 
						  
						  
						  
						  
						  
						  long Receiver_bal= fetchedUserAccountDetails.getAccountBalance()+requestForMoney.getAmount();
						  accountDetailsService.updateAccountBalance(Receiver_bal,currentDate,requestForMoney.getUserAccountNumber());
						  
						  CustomerTransaction receiverTransaction=new CustomerTransaction();
						  receiverTransaction.setAccountNumber(User_customer_acc.getAccountNumber());
						  receiverTransaction.setUserAccountNumber(customer_acc.getAccountNumber());
						  receiverTransaction.setAmount(requestForMoney.getAmount());
						  
						  receiverTransaction.setUpdatedAt(currentDate);
						  receiverTransaction.setCreatedAt(currentDate);
						  receiverTransaction.setStatus("Credited successfully");
						  customerTransactionService.addreceiverlogs(receiverTransaction);
						  
						 
						 // AccountDetails details=accountDetailsService.saveAccountDetails(fetchedAccountDetails);
						CustomerResponseForBalance responsestructure= new CustomerResponseForBalance(new Date(),"Account balance updated successfully","200",fetchedAccountDetails);
 
						  return new ResponseEntity<Object>(responsestructure,HttpStatus.OK);
					         
					   }else {
						   return new ResponseEntity<Object>("Invalid Transaction pin",HttpStatus.OK);
					   }
					   
				   }else {
					   return new ResponseEntity<Object>("invalid ifsc",HttpStatus.OK);
					   
				   }
				   
			   }else
			   {
				   return new ResponseEntity<Object>("Invalid branch name",HttpStatus.OK);
			   }
			   	   }else {
			   		return new ResponseEntity<Object>("Insufficient balance",HttpStatus.OK);
			   	   }
		 }else {
			 return new ResponseEntity<Object>("amount not added",HttpStatus.OK);
		 }
	 }
	 
	 
	 
	 
	 
	 
	 @PostMapping("/forgetPassword")
	 public ResponseEntity<Object>forgetPassword(@RequestBody Customers OtpRequest){
		 
		 Customers record= customerService.fetchCustomerByEmail(OtpRequest.getEmail());
		 if(record != null ) {
			boolean ans=mailServiceImpl.sendMail(OtpRequest.getEmail(),accountnumber.GenerateTransactionPin());
			System.out.println("ans is "+ans);
			//log.info("Mail :"+ans);
			//log.info("OTP:"+accountnumber.GenerateTransactionPin());
			 return new ResponseEntity<Object>("Otp sent on Mail",HttpStatus.OK);
			//Customers custom= customerService.sendOtp(record.getEmail());
		 }else {
			 return new ResponseEntity<Object>("Record not found",HttpStatus.OK);
		 }
		 
		 
		 
		 
		 
	 }
	 
	 
	 @PostMapping("/ResetPassword")
	 public ResponseEntity<Object> ResetPassword(@RequestBody RequestForPassword  request){
		// String customer_email=request.getEmail();
		 //String new_password=request.getNew_password();
		
		 Customers emailfetched=customerService.fetchCustomerByEmail(request.getEmail());
		 if (emailfetched!=null) {
		      if(request.getNew_password().equals(request.getConfirm_password()))
		      {
			    if(encoder.matches(request.getNew_password(),emailfetched.getPassword())==true) {
			    	 return new ResponseEntity<Object>("old password",HttpStatus.OK);
			    	
			    }
			    else
			    {
			    	int n=customerService.ResetPassword(request.getNew_password(),request.getEmail());
			    }
				 
			 }else
			 {
				 return new ResponseEntity<Object>("Password doest match",HttpStatus.OK);
			 }
			 
		 }
		 else
		 {
			 return new ResponseEntity<Object>("Record not found",HttpStatus.OK);
		 }		 
		 
		 return new ResponseEntity<Object>("password reset successfully",HttpStatus.OK);
	 }
	 

	 
	 
	 @PostMapping("/loginCustomer")
		public ResponseEntity<Object> loginCustomer(@RequestBody Customers customer){
			validation.loginCustomer(customer);
			Customers emailfetched=customerService.fetchCustomerByEmail(customer.getEmail());
			if (emailfetched==null) {
				 return new ResponseEntity<Object>("Customer not registered ",HttpStatus.OK);
			}
			else{
			//if(encoder.matches(customer.getPassword(),emailfetched.getPassword())==true){
				if(customer.getPassword().equals(emailfetched.getPassword())){
			 return new ResponseEntity<Object>("login successfull",HttpStatus.OK);		
		      }else
		      {
		       return new ResponseEntity<Object>("password didnt match",HttpStatus.OK);
			}
		}
	 
	 }
	
	 
	
		 
}	 
		 
			         
			  
		
		 
		 
		 
	  
	 
	 
	 

	 
	 
		 
	 

	 
	/*@PostMapping("fetchByAccountNumber")
	public ResponseEntity<Object> DisplayAccountDetails(RequestBody AccountDetails accountNumber){
		AccountDetails details=accountDetailsService.fetchCustomerByAccNo(accountNo);
		
		
	}*/
	
	

	
	

		
		
	
	
	
	


