package com.banking.auth.customerresponse;



import java.util.Date;

import com.banking.auth.entities.AccountDetails;
import com.banking.auth.entities.Customers;

public class CustomerResponseforCustomerRegister {
	
	private Date timestamp;
	private String message;
	private String status;
	private Customers customer;
	private AccountDetails accountdetails;
	public CustomerResponseforCustomerRegister() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public AccountDetails getAccountdetails() {
		return accountdetails;
	}

	public void setAccountdetails(AccountDetails accountdetails) {
		this.accountdetails = accountdetails;
	}

	public CustomerResponseforCustomerRegister(Date timestamp, String message, String status, Customers customer,
			AccountDetails accountdetails) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.status = status;
		this.customer = customer;
		this.accountdetails = accountdetails;
	}

	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Customers getCustomer() {
		return customer;
	}
	public void setCustomer(Customers customer) {
		this.customer = customer;
	}
	@Override
	public String toString() {
		return "CustomerResponseforCustomerRegister [timestamp=" + timestamp + ", message=" + message + ", status="
				+ status + ", customer=" + customer + ", getTimestamp()=" + getTimestamp() + ", getMessage()="
				+ getMessage() + ", getStatus()=" + getStatus() + ", getCustomer()=" + getCustomer() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
	

}
