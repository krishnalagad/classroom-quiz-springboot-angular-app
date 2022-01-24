package com.classstudies.classquiz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.classstudies.classquiz.model.User;
import com.classstudies.classquiz.repositiry.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = this.userRepository.getUserByUsername(username);
		if(user == null) {
			System.out.println("User not found...");
			throw new UsernameNotFoundException("No user found...");
		}
		return user;
	}

}
