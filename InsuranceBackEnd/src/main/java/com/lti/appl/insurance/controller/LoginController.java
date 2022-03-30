package com.lti.appl.insurance.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.appl.insurance.dto.Login;
import com.lti.appl.insurance.dto.LoginStatus;
import com.lti.appl.insurance.dto.Status.StatusType;
import com.lti.appl.insurance.entity.User;
import com.lti.appl.insurance.exception.UserServiceException;
import com.lti.appl.insurance.service.UserService;



@RestController("")
@CrossOrigin("http://localhost:4200")
public class LoginController {
	
	@Autowired
	private UserService userService;
	

	@PostMapping("/login")
	public LoginStatus login(@RequestBody Login login) {
		 try {
			 User user = userService.login(login.getEmail(), login.getPassword());
			 
			 LoginStatus status = new LoginStatus();
			 status.setStatus(StatusType.SUCCESS);
			 status.setMessage("Login Successful!!");
			 status.setUserId(user.getUserId());
			 status.setUserName(user.getUserName());
			 
			 return status;
		 }catch(UserServiceException e) {
			 LoginStatus status = new LoginStatus();
			 status.setStatus(StatusType.FAILED);
			 status.setMessage(e.getMessage());
			 
			 return status;

		 }
	}
	
	@GetMapping("/user-details")
	public @ResponseBody User insuranceDetails(@RequestParam int userId){
		try {
			User user = userService.getUserDetails(userId);
			user.getAddress().setUser(null);
			user.setInsurances(null);
			return user;
		}catch(UserServiceException e) {
			e.printStackTrace();
			return null;
		}
	}
}
