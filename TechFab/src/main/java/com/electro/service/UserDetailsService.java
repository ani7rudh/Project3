package com.electro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.electro.daoimpl.UserDetailsDAOImpl;
import com.electro.model.UserDetails;

@Service
@Transactional

public class UserDetailsService {
	
	@Autowired
    UserDetailsDAOImpl userDetailsDAOImpl;
	
	public void addUserDetails(UserDetails userDetails)
	{
		userDetailsDAOImpl.addUserDetails(userDetails);
	}


}
