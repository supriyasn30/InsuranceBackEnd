package com.lti.appl.insurance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.appl.insurance.dto.InsuranceStatus;
import com.lti.appl.insurance.dto.Status.StatusType;
import com.lti.appl.insurance.entity.MotorInsurance;
import com.lti.appl.insurance.entity.Payment;
import com.lti.appl.insurance.exception.UserServiceException;
import com.lti.appl.insurance.service.UserService;



@RestController("")
@CrossOrigin("http://localhost:4200")
public class InsurancePlanController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/choose-plan")
	public @ResponseBody InsuranceStatus choosePlan(@RequestBody MotorInsurance motorInsurance) {
		try {
			Payment payment = userService.storeInsuranceDetails(motorInsurance);
			InsuranceStatus status = new InsuranceStatus();
			
			status.setStatus(StatusType.SUCCESS);
			status.setMessage("success");
			status.setPayment(payment);
			
			return status;
		}catch(UserServiceException e) {
			
            InsuranceStatus status = new InsuranceStatus();
			
			status.setStatus(StatusType.FAILED);
			status.setMessage(e.getMessage());
            
			return status;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}