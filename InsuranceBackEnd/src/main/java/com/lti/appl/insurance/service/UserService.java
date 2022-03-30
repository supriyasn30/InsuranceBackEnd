package com.lti.appl.insurance.service;

import java.util.List;

import com.lti.appl.insurance.dto.RenewDetails;
import com.lti.appl.insurance.dto.UserInsuranceStatus;
import com.lti.appl.insurance.dto.ValidateClaim;
import com.lti.appl.insurance.entity.InsuranceClaim;
import com.lti.appl.insurance.entity.MotorInsurance;
import com.lti.appl.insurance.entity.Payment;
import com.lti.appl.insurance.entity.User;
import com.lti.appl.insurance.entity.VehicleModels;

public interface UserService {

	public User register(User user);

	public User login(String email, String password);
	
	public InsuranceClaim claim(int policyNumber, String email, //String password, 
			String claimReason, double claimAmount);
	
    public List<VehicleModels> fetchVehicles();
	
    public MotorInsurance getRenewDetails(RenewDetails renewDetails);

    public Payment storeInsuranceDetails(MotorInsurance motorInsurance);
    
    public int savePaymentdetails(Payment payment);

	public int resetPassword(User user);
    
    public List<MotorInsurance> getUserInsuranceDetails(int userId);
    
    public List<InsuranceClaim> getPolicyClaimDetails(int policyNumber);

    public List<InsuranceClaim> getAllClaims();
    
    public void validateClaimUpdate(ValidateClaim validateClaim);
    
    public void denyClaimUpdate(ValidateClaim validateClaim);
    
    public void updateUserDetails(User user);
    
    public UserInsuranceStatus getVehiclesByUserId(int userId);

    public User getUserDetails(int userId);

}
