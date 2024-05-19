package com.project.ecommercewebsite.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.project.ecommercewebsite.repository.userInfoRepository;
import com.project.ecommercewebsite.users.userInfo;

@Component
public class UserInfoUserDetailsService implements UserDetailsService  {

	@Autowired
	private userInfoRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		//Optional<userInfo> userInfo = repo.findByName(username);
		return null;
	}
	
	
}
