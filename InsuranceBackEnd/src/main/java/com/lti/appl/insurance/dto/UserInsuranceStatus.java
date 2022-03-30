package com.lti.appl.insurance.dto;


import com.lti.appl.insurance.entity.MotorInsurance;
import com.lti.appl.insurance.entity.Payment;
import com.lti.appl.insurance.entity.Vehicle;



public class UserInsuranceStatus extends Status{

	private Vehicle vehicle;
	private MotorInsurance motorInsurance;
	private Payment payment;

	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	public MotorInsurance getMotorInsurance() {
		return motorInsurance;
	}
	public void setMotorInsurance(MotorInsurance motorInsurance) {
		this.motorInsurance = motorInsurance;
	}
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	
}