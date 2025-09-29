package com.example.Securitylearn.configuration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class Securityconfig {
	
	
	@Autowired
	UserDetailsService detailsService;

	@Bean
	public SecurityFilterChain chain(HttpSecurity http) throws Exception {
		return http.csrf(customizer->customizer.disable()) 						//to disable csrf
		.authorizeHttpRequests(request->request
				.requestMatchers("/admin/**").hasRole("ADMIN")
				.requestMatchers("/user/**").hasAnyRole("ADMIN","USER")
				.requestMatchers("/public/**").permitAll()
				.anyRequest().authenticated())   //to authenticate the all request
//		.http.formLogin(Customizer.withDefaults())								//to create a form
		.httpBasic(Customizer.withDefaults())									//to access the api clients
		.sessionManagement(session-> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))	//eveytime it get statless session different id and password
		.build();
		
		/* this part is used for to custom user login,disabel csrf,same site strict,everytime create different session id */
	}
	
	
	/*
//	@Bean
//	public UserDetailsService userdetail() {   //userdetailsservice interface to verify the for login
//		
//		List<UserDetails> users = new ArrayList<UserDetails>();
//		
//		UserDetails user1 =User
//				.withDefaultPasswordEncoder()
//				.username("vicky")
//				.password("1234")
//				.roles("USER")
//				.build();		//it return a user details object
//		
//		UserDetails user2 =User
//				.withDefaultPasswordEncoder()
//				.username("haz")
//				.password("1234")
//				.roles("USER")
//				.build();
//		
//		UserDetails user3 =User
//				.withDefaultPasswordEncoder()
//				.username("admin")
//				.password("1234")
//				.roles("USER")
//				.build();
//		
//		users.add(user1);
//		users.add(user2);
//		users.add(user3);
//		
//		return new InMemoryUserDetailsManager(users); 		
//		//This part is access multiple users.this two ways to achive using vararg,arraylist
//	}
 */
	
	
	@Bean
	
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provide = new DaoAuthenticationProvider(); //dao is data access layer for data base access
		provide.setPasswordEncoder(new BCryptPasswordEncoder(12));
		provide.setUserDetailsService(detailsService);
		return provide;
	}
	
	@Bean
	public BCryptPasswordEncoder password() {
		return new BCryptPasswordEncoder(12);
	}
}
