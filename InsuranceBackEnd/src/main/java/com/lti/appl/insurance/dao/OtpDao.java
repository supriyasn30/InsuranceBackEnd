package com.lti.appl.insurance.dao;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import com.lti.appl.insurance.entity.Otp;



@Repository
public class OtpDao extends GenericDao{

	
	public Otp getOtpNumber(String emailId) throws NoResultException {
		System.out.println(emailId);
		return (Otp)entityManager.createQuery("select o from Otp o where o.emailId=:emailId")
				.setParameter("emailId", emailId).getSingleResult();
	}
	
	
	
	public boolean isOtpPresent(String emailId) {
		return (Long)entityManager.createQuery("select count(o.id) from Otp o where o.emailId=:emailId")
				.setParameter("emailId", emailId).getSingleResult()==1?true:false;
	}
	
}
