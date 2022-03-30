package com.lti.appl.insurance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.appl.insurance.dto.Status.StatusType;
import com.lti.appl.insurance.dto.UserInsuranceStatus;
import com.lti.appl.insurance.entity.InsuranceClaim;
import com.lti.appl.insurance.entity.MotorInsurance;
import com.lti.appl.insurance.exception.UserServiceException;
import com.lti.appl.insurance.service.UserService;



@RestController("")
@CrossOrigin("http://localhost:4200")
public class LoginProfileController {

	@Autowired
	private UserService userService;

	@GetMapping("/insurancedetails")
	public @ResponseBody List<MotorInsurance> insuranceDetails(@RequestParam int userId) {
		try {
			System.out.println("hello"+userId);
			List<MotorInsurance> list = userService.getUserInsuranceDetails(userId);
			
			return list;
		} catch (UserServiceException e) {
			e.printStackTrace();
			return null;
		}
	}

	@GetMapping("/claimdetails")
	public @ResponseBody List<InsuranceClaim> claimDetails(@RequestParam int policyNumber) {
		try {
			List<InsuranceClaim> list = userService.getPolicyClaimDetails(policyNumber);
			return list;
		} catch (UserServiceException e) {
			e.printStackTrace();
			return null;
		}
	}

	@GetMapping("/vehicledetails")
	public @ResponseBody UserInsuranceStatus vehicleDetails(@RequestParam int userId) {
		try {
			UserInsuranceStatus status = userService.getVehiclesByUserId(userId);
			if(status.getVehicle() == null && status.getMotorInsurance() == null) {
				status.setStatus(StatusType.SUCCESS);
				status.setMessage("No pending in registration process");
				
				return status;
			}else if(status.getPayment() == null) {
				status.setStatus(StatusType.SUCCESS);
				status.setMessage("only vehicle registraion is done");
				
				return status;
			}else if(status.getVehicle() == null){
				status.setStatus(StatusType.SUCCESS);
				status.setMessage("payment is pending");
				
				return status;
			}else {
				status.setStatus(StatusType.SUCCESS);
				status.setMessage("pending in more than one vehicle registraion");
				
				return status;
			}
		}catch(UserServiceException e) {
			UserInsuranceStatus status = new UserInsuranceStatus();
			status.setStatus(StatusType.FAILED);
			status.setMessage(e.getMessage());
			
			return status;
		}
	}
}
