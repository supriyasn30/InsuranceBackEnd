package com.lti.appl.insurance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.appl.insurance.dto.RegisterStatus;
import com.lti.appl.insurance.dto.Status.StatusType;
import com.lti.appl.insurance.entity.Address;
import com.lti.appl.insurance.entity.User;
import com.lti.appl.insurance.exception.UserServiceException;
import com.lti.appl.insurance.service.UserService;


@RestController("")
@CrossOrigin("http://localhost:4200")
public class RegisterController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	public @ResponseBody RegisterStatus register(@RequestBody User user) {
		try {
			Address address = user.getAddress();
			System.out.println(address.getAddressLine());
		    user = userService.register(user);
			System.out.println(user.getEmail());
			RegisterStatus status = new RegisterStatus();
			status.setStatus(StatusType.SUCCESS);
			status.setMessage("Registration Successfull");

			status.setUser(user);
			return status;
		}
		catch(UserServiceException e) {
			e.printStackTrace();
			RegisterStatus status = new RegisterStatus();
			status.setStatus(StatusType.FAILED);
			status.setMessage("Registration failed");
			return status;
		}
	}
	
}