package com.ticket.service;

public interface HomeService {

	public Boolean verifyAccount(Integer userId,String verificationCode) throws Exception;
	
	
}
