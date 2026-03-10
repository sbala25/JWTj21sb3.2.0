package com.example.JWTj21sb320.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.JWTj21sb320.model.JwtUsers;


@Service
public class JwtUserService {
	@Value("${app.jwtUser}")
	private String jwtUser;

	@Value("${app.jwtPassword}")
	private String jwtPassword;


	public Boolean verify(JwtUsers user) {
		if (user != null && user.getUsername() != null && user.getUsername().equals(jwtUser)
				&& user.getUsername() != null && user.getPassword().equals(jwtPassword))
			return true;
		return false;
	}
	
}
