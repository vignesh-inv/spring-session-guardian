package com.example.Securitylearn.model;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class Userprincipal implements UserDetails {     //cureent validation class name is userprincipal

	private Users user;
	
	public Userprincipal(Users user) {
		this.user=user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return Collections.singleton(new  SimpleGrantedAuthority("ROLE_"+user.getRole())); 
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getPassword();  //db
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getUsername();  //db
	}   

}
