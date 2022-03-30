package com.lti.appl.insurance.dto;

import com.lti.appl.insurance.entity.MotorInsurance;
import com.lti.appl.insurance.entity.Payment;

public class InsuranceStatus extends Status{

	private MotorInsurance motorInsurance;
	private Payment payment;

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public MotorInsurance getMotorInsurance() {
		return motorInsurance;
	}

	public void setMotorInsurance(MotorInsurance motorInsurance) {
		this.motorInsurance = motorInsurance;
	}

}