package com.banking.auth.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class CustomerTransaction {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String accountNumber;
	private String userAccountNumber;
	private long amount;
	private String createdAt;
	private String updatedAt;
	private String Status;
	
	public CustomerTransaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public CustomerTransaction(long id, String accountNumber, String userAccountNumber, long amount, String createdAt,
			String updatedAt, String credited_by, String debited_by) {
		super();
		this.id = id;
		this.accountNumber = accountNumber;
		this.userAccountNumber = userAccountNumber;
		this.amount = amount;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.Status = Status;

	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getUserAccountNumber() {
		return userAccountNumber;
	}
	public void setUserAccountNumber(String userAccountNumber) {
		this.userAccountNumber = userAccountNumber;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	

	public String getStatus() {
		return Status;
	}

	public void setStatus(String Status) {
		this.Status = Status;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "CustomerTransaction [id=" + id + ", accountNumber=" + accountNumber + ", userAccountNumber="
				+ userAccountNumber + ", amount=" + amount + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt
				+ ", Status=" + Status + ", getId()=" + getId() + ", getAccountNumber()=" + getAccountNumber()
				+ ", getUserAccountNumber()=" + getUserAccountNumber() + ", getAmount()=" + getAmount()
				+ ", getCreatedAt()=" + getCreatedAt() + ", getStatus()=" + getStatus() + ", getUpdatedAt()="
				+ getUpdatedAt() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	
	

}
