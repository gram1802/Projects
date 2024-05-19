package com.project.ecommercewebsite.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;

import com.project.ecommercewebsite.service.UserInfoUserDetailsService;

@Configuration
public class SecurityConfig {
	
	@Bean
	SecurityFilterChain secuirtyFilterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf.disable());
		return http.build();
		
	}
	/*
	@Bean
	UserDetailsService userDetailService() {
		return (UserDetailsService) new UserInfoUserDetailsService();
	}
	*/
}
