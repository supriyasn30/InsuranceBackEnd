package com.lti.appl.insurance.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.appl.insurance.dto.InsuranceStatus;
import com.lti.appl.insurance.dto.RenewDetails;
import com.lti.appl.insurance.dto.Status.StatusType;
import com.lti.appl.insurance.entity.MotorInsurance;
import com.lti.appl.insurance.entity.Vehicle;
import com.lti.appl.insurance.exception.UserServiceException;
import com.lti.appl.insurance.service.UserService;


@RestController("")
@CrossOrigin("http://localhost:4200")
public class RenewController {

	@Autowired
	private UserService userService;

	@PostMapping("/renew")
	public @ResponseBody InsuranceStatus renew(@RequestBody RenewDetails renewDetails) {
		try {
			MotorInsurance motorInsurance = userService.getRenewDetails(renewDetails);
             Vehicle vehicle = motorInsurance.getVehicle();
             List<MotorInsurance> insurances = vehicle.getInsurances();
             for(MotorInsurance insurance : insurances ) {
            	 if(insurance.getPlanExpiryDate().compareTo(LocalDate.now()) > 0) {
            		 InsuranceStatus status = new InsuranceStatus();
     				status.setStatus(StatusType.FAILED);
     				status.setMessage("Insurance is not expired");
     				status.setMotorInsurance(motorInsurance);

     				return status;
            	 }
             }
				motorInsurance.getUser().getAddress().setUser(null);
				InsuranceStatus status = new InsuranceStatus();
				status.setMotorInsurance(motorInsurance);
				status.setStatus(StatusType.SUCCESS);
				status.setMessage("User Found");

				return status;
		} catch (UserServiceException e) {
			InsuranceStatus status = new InsuranceStatus();
			status.setStatus(StatusType.FAILED);
			status.setMessage(e.getMessage());

			return status;
		}
	}
}
