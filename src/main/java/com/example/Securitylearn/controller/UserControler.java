package com.example.Securitylearn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Securitylearn.model.Users;
import com.example.Securitylearn.service.Userservice;

@RestController
public class UserControler {

	
	@Autowired
	Userservice userservice;
	
	@PostMapping("/admin/add-user")
	public void adduser(@RequestBody Users users) {
		userservice.adduser(users);
	}

}
