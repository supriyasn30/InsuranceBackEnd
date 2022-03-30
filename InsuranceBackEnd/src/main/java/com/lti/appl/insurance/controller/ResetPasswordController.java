package com.lti.appl.insurance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.appl.insurance.dto.ResetPassword;
import com.lti.appl.insurance.dto.Status.StatusType;
import com.lti.appl.insurance.entity.User;
import com.lti.appl.insurance.exception.UserServiceException;
import com.lti.appl.insurance.service.UserService;


@RestController("")
@CrossOrigin("http://localhost:4200")
public class ResetPasswordController {

	@Autowired
	private UserService userService;
	
	
	@PostMapping("/resetpassword")
	public @ResponseBody ResetPassword resetPassword(@RequestBody User user) {
		System.out.println(user.getEmail());
		try {
			int id = userService.resetPassword(user);
			System.out.println(id);
			ResetPassword status = new ResetPassword();
			status.setStatus(StatusType.SUCCESS);
			status.setMessage("Password reset was successful!");
			return status;
		}
		catch(UserServiceException e) {
			e.printStackTrace();
			ResetPassword status = new ResetPassword();
			status.setStatus(StatusType.FAILED);
			status.setMessage("Reset Password failed!");
			return status;
			
		}
	}
	
//	@PatchMapping("/resetpassword/{userId}")
//	public ResponseEntity<Void> resetPassword(@PathVariable int userId, @RequestBody User user)
//	//public String restUserPassword(@RequestBody User user)
//	{
//		resetPassword(userId, user);
//		//resetPasswordDao.save(user);
//		return ResponseEntity.ok().build();
//	}
}