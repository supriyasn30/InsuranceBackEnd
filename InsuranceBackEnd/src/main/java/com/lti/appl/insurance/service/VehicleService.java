package com.lti.appl.insurance.service;

import java.util.List;

import com.lti.appl.insurance.entity.Estimate;
import com.lti.appl.insurance.entity.Vehicle;
import com.lti.appl.insurance.entity.VehicleModels;

public interface VehicleService {

	public List<Estimate> getPremiumPlans(Vehicle vehicle);

	public Vehicle register(Vehicle vehicle);
	
	public VehicleModels addNewVehicle(VehicleModels vehicleModel);

	public List<VehicleModels> listAvailableVehicle();
}
