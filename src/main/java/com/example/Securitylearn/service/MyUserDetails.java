package com.example.Securitylearn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.Securitylearn.model.Userprincipal;
import com.example.Securitylearn.model.Users;
import com.example.Securitylearn.repo.SpringRepo;

@Service
public class MyUserDetails implements UserDetailsService {

	@Autowired
	SpringRepo repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Users user =repo.findByUsername(username);
		if(user==null) {
			throw new UsernameNotFoundException("user not found");
		}
		return  new Userprincipal(user);
	}

}
