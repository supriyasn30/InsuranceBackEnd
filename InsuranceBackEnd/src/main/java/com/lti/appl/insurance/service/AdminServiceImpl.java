package com.lti.appl.insurance.service;

import org.springframework.stereotype.Service;

import com.lti.appl.insurance.exception.UserServiceException;


@Service
public class AdminServiceImpl implements AdminService {

	@Override
	public int adminlogin(String email, String password) {
		if(email.equals("madhura@admin.com") && password.equals("admin123")){
				return 1;
		}
		else if	(email.equals("soumya@admin.com") && password.equals("admin123")) {
				return 2;
		}
		else if	(email.equals("archan@admin.com") && password.equals("admin123")) {
				return 3;
		}
		else if (email.equals("sibansh@admin.com") && password.equals("admin123")) {
				return 4;
		}
		else if	(email.equals("rohit@admin.com") && password.equals("admin123")) {
				return 5;
		}
		else {
			throw new UserServiceException("Admin not found");
		}
			
		
	}

}
