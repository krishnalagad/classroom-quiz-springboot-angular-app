package com.classstudies.classquiz.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.classstudies.classquiz.config.JwtUtil;
import com.classstudies.classquiz.model.JwtRequest;
import com.classstudies.classquiz.model.JwtResponce;
import com.classstudies.classquiz.model.User;
import com.classstudies.classquiz.service.impl.UserDetailsServiceImpl;

@RestController
@CrossOrigin("*")
public class AuthenticateController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;
	
	@Autowired
	private JwtUtil jwtUtil;
	
//	generate token
	@PostMapping("/generate-token")
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception{
		
		try {
			
			authenticate(jwtRequest.getUsername(), jwtRequest.getPassword());
		} 
		catch (Exception e) {
			e.printStackTrace();
			throw new Exception("User not found");
		}
		
		UserDetails userDetails = this.userDetailsServiceImpl.loadUserByUsername(jwtRequest.getUsername());
		String token = jwtUtil.generateToken(userDetails);
		
		return ResponseEntity.ok(new JwtResponce(token));
		
	}
	
	private void authenticate(String username, String password) throws Exception {
		
		try {
			
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		}
		catch(DisabledException e) {
			throw new Exception("USER DISABLED : " + e.getMessage());
		}
		catch(BadCredentialsException e) {
			throw new Exception("Invalid Credentials : " + e.getMessage());
		}
	}
	
	@GetMapping("/current-user")
	public User getCurrentUser(Principal principal) {
		
//		User user = new User();
//		user.setEnabled(true);
		return (User) this.userDetailsServiceImpl.loadUserByUsername(principal.getName());
	}
}
