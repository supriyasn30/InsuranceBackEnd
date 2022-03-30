package com.lti.appl.insurance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.appl.insurance.dto.RegisterStatus;
import com.lti.appl.insurance.dto.Status.StatusType;
import com.lti.appl.insurance.entity.User;
import com.lti.appl.insurance.exception.UserServiceException;
import com.lti.appl.insurance.service.UserService;


@RestController("")
@CrossOrigin("http://localhost:4200")
public class UpdateDetailsController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/update")
	public @ResponseBody RegisterStatus update(@RequestBody User user) {
		try {
		    userService.updateUserDetails(user);
			RegisterStatus status = new RegisterStatus();
			status.setStatus(StatusType.SUCCESS);
			status.setMessage("Update Successfull");
			status.setUser(user);
			return status;
		}
		catch(UserServiceException e) {
			e.printStackTrace();
			RegisterStatus status = new RegisterStatus();
			status.setStatus(StatusType.FAILED);
			status.setMessage("Update failed");
			return status;
		}
	}
	
}