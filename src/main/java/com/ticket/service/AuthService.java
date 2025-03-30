package com.ticket.service;

import com.ticket.dto.LoginRequest;
import com.ticket.dto.LoginResponse;
import com.ticket.dto.UserRequest;

public interface AuthService {

	public Boolean register(UserRequest userDto, String url) throws Exception;

	public LoginResponse login(LoginRequest loginRequest);
	
}
