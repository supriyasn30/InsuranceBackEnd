package com.lti.appl.insurance.dto;

import com.lti.appl.insurance.entity.Vehicle;

public class VehicleStatus extends Status{
	
	private Vehicle vehicle;

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

}