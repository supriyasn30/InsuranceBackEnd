package com.lti.appl.insurance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.appl.insurance.dto.Status.StatusType;
import com.lti.appl.insurance.dto.VehicleStatus;
import com.lti.appl.insurance.entity.Vehicle;
import com.lti.appl.insurance.exception.VehicleServiceException;
import com.lti.appl.insurance.service.VehicleService;


@RestController("")
@CrossOrigin("http://localhost:4200")
public class VehicleController {
	
	@Autowired
	private VehicleService vehicleService;
	
	@PostMapping("/register-vehicle")
	public @ResponseBody VehicleStatus register(@RequestBody Vehicle vehicle) {
		try {
			 //System.out.println(vehicle.getUser().getUserId());
			//System.out.println(vehicle.getRegNo()+" "+vehicle.getManufacturer()+" "+vehicle.getEngineNumber());
			vehicle = vehicleService.register(vehicle);
			//System.out.println("called!");
			vehicle.setInsurances(null);
			//vehicle.getUser().setInsurances(null);
			VehicleStatus status = new VehicleStatus();
			status.setStatus(StatusType.SUCCESS);
			status.setMessage("Registration Successfull");
			status.setVehicle(vehicle);
			return status;
		}
		catch(VehicleServiceException e) {
			System.out.println("exception");
			e.printStackTrace();
			VehicleStatus status = new VehicleStatus();
			status.setStatus(StatusType.FAILED);
			status.setMessage("Registration failed");
			return status;
		}
	}

}