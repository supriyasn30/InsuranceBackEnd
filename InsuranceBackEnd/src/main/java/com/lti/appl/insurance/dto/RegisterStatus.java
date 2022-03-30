package com.lti.appl.insurance.dto;

import com.lti.appl.insurance.entity.User;

public class RegisterStatus extends Status {

	private User user;
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}