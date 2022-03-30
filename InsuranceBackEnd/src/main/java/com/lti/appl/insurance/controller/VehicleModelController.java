package com.lti.appl.insurance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.appl.insurance.entity.VehicleModels;
import com.lti.appl.insurance.service.UserService;



@RestController("")
@CrossOrigin("http://localhost:4200")
public class VehicleModelController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/fetchVehicleModel")
	public List<VehicleModels> fetchModels(){
		return userService.fetchVehicles();
	}
	
}
