package com.example.Securitylearn;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Passwordhashing {

	public static void main(String[] args) {

		BCryptPasswordEncoder encode = new BCryptPasswordEncoder(12);

		String bt = "admin";
		String hassed = encode.encode(bt);
		System.out.println(hassed);
	}
}