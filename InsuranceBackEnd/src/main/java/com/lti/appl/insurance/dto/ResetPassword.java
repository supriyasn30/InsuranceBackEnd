package com.lti.appl.insurance.dto;

public class ResetPassword extends Status {

	private String email;
	
	private String password;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "ResetPassword [email=" + email + "; password=" + password + "]";
	}
	
	
}
