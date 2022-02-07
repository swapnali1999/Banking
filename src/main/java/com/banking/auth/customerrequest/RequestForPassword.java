package com.banking.auth.customerrequest;

public class RequestForPassword {
	String email;
	String new_password;
	String confirm_password;
	public RequestForPassword() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RequestForPassword(String email, String new_password, String confirm_password) {
		super();
		this.email = email;
		this.new_password = new_password;
		this.confirm_password = confirm_password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNew_password() {
		return new_password;
	}
	public void setNew_password(String new_password) {
		this.new_password = new_password;
	}
	public String getConfirm_password() {
		return confirm_password;
	}
	public void setConfirm_password(String confirm_password) {
		this.confirm_password = confirm_password;
	}
	@Override
	public String toString() {
		return "RequestForPassword [email=" + email + ", new_password=" + new_password + ", confirm_password="
				+ confirm_password + ", getEmail()=" + getEmail() + ", getNew_password()=" + getNew_password()
				+ ", getConfirm_password()=" + getConfirm_password() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	

}
