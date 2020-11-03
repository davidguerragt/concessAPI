package com.concess.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.concess.api.service.UserDetailsSrv;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
		
	@Autowired
	private UserDetailsSrv userDetailsService;
	
	@Autowired
	private BCryptPasswordEncoder bcrypt;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}
		
	@Override
	protected void configure(AuthenticationManagerBuilder auth) 
			throws Exception 
	{
		super.configure(auth);
		auth.userDetailsService(userDetailsService).passwordEncoder(bcrypt);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		/*http
			.authorizeRequests()
			.antMatchers("/users").hasRole("ADMIN")
			.antMatchers("/customers").permitAll()
			.antMatchers("/vehicles").permitAll()
			.antMatchers("/concessionaries").permitAll()
			.antMatchers("/vendors").permitAll()
			.antMatchers("/vehiclesales").permitAll()
			//.antMatchers("/operations").hasRole("USER")
			//.antMatchers("/reports").hasAnyRole("USER","READER") 
			.antMatchers("/**").permitAll()
			.anyRequest()
			.authenticated()
			.and()
			.httpBasic();*/

	    	http.csrf().disable();
	}
	
	/*
	@Override
	public void configure(WebSecurity web) throws Exception {
		//web.ignoring().antMatchers("/api/users/**");
	}
	*/
	
}
