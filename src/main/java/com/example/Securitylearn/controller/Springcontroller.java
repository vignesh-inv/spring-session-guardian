package com.example.Securitylearn.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Securitylearn.model.Springmodel;

import jakarta.servlet.http.HttpServletRequest;



@RestController
public class Springcontroller {

	
	@GetMapping("/public/home")
	public String home() {
		return "home";
	}

	@GetMapping("/hello")
	public String hello(HttpServletRequest req) {
		return "Hello "+req.getSession().getId();
	}
	
//	@GetMapping("/stud")
//	public List<Springmodel> getstud(){
//		return obj;
//	}
//
//
//	@PostMapping("/stud")
//	public void addstud(@RequestBody Springmodel springmodel) {
//		obj.add(springmodel);
//	}
}
