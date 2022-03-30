package com.lti.appl.insurance.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lti.appl.insurance.entity.User;



@Repository
public interface AdminViewDetailsDao extends JpaRepository<User, Integer> {

}