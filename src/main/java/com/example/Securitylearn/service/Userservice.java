package com.example.Securitylearn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.Securitylearn.model.Users;
import com.example.Securitylearn.repo.SpringRepo;

@Service
public class Userservice {

	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Autowired
	private SpringRepo repo;
	
	public void adduser(Users users) {
		users.setPassword(encoder.encode(users.getPassword()));
		repo.save(users);
		
	}

}
