package com.ticket.service;

import org.springframework.security.core.userdetails.UserDetails;

import com.ticket.entity.User;

public interface JwtService {

	public String generateToken(User user);
	
	public String extractUsername(String token);
	
	public Boolean validateToken(String token,UserDetails userDetails);
}
