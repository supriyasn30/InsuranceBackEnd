package com.lti.appl.insurance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.appl.insurance.dto.PaymentStatus;
import com.lti.appl.insurance.dto.Status.StatusType;
import com.lti.appl.insurance.entity.Payment;
import com.lti.appl.insurance.service.UserService;


@RestController("")
@CrossOrigin("http://localhost:4200")
public class PaymentController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/payment")
	public @ResponseBody PaymentStatus doPayment(@RequestBody Payment payment) {
		int id = userService.savePaymentdetails(payment);
		
		PaymentStatus status = new PaymentStatus();
		status.setPaymentId(id);
		status.setStatus(StatusType.SUCCESS);
		status.setMessage("Payment Successful");
		
		return status;
	}
}