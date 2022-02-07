package com.banking.auth.customerresponse;

import java.util.Date;

import com.banking.auth.entities.AccountDetails;

public class CustomerResponseForBalance {
	private Date timestamp;
	private String message;
	private String status;
	private AccountDetails accountdetails;
	public CustomerResponseForBalance() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CustomerResponseForBalance(Date timestamp, String message, String status, AccountDetails accountdetails) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.status = status;
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
	public AccountDetails getAccountdetails() {
		return accountdetails;
	}
	public void setAccountdetails(AccountDetails accountdetails) {
		this.accountdetails = accountdetails;
	}
	@Override
	public String toString() {
		return "CustomerResponseForBalance [timestamp=" + timestamp + ", message=" + message + ", status=" + status
				+ ", accountdetails=" + accountdetails + ", getTimestamp()=" + getTimestamp() + ", getMessage()="
				+ getMessage() + ", getStatus()=" + getStatus() + ", getAccountdetails()=" + getAccountdetails()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	

}
