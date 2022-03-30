package com.lti.appl.insurance.service;

import com.lti.appl.insurance.entity.Otp;

public interface OtpService {
	public int generateOtp(String login_id);
	public boolean validateOtp(Otp otp);

}
