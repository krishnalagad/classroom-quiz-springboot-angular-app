package com.classstudies.classquiz.model;

public class JwtResponce {
	
	String token;
	
	public JwtResponce() {
	}

	public JwtResponce(String token) {
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	

}
