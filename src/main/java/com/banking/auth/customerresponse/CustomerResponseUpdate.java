package com.banking.auth.customerresponse;

import java.util.Date;

public class CustomerResponseUpdate {
	private Date timestamp;
	private String message;
	private String status;
	public CustomerResponseUpdate() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CustomerResponseUpdate(Date timestamp, String message, String status) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.status = status;
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
	@Override
	public String toString() {
		return "CustomerResponseUpdate [timestamp=" + timestamp + ", message=" + message + ", status=" + status
				+ ", getTimestamp()=" + getTimestamp() + ", getMessage()=" + getMessage() + ", getStatus()="
				+ getStatus() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	

}
