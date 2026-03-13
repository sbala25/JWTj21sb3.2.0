package com.example.JWTj21sb320.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.JWTj21sb320.model.JwtResponse;
import com.example.JWTj21sb320.model.JwtUsers;
import com.example.JWTj21sb320.service.JwtService;
import com.example.JWTj21sb320.service.JwtUserService;

@RestController
public class AuthenticateController {

	@Autowired
	private JwtUserService service;

	@Autowired
	private JwtService jwtService;

	@PostMapping("/authenticate")
	public ResponseEntity<JwtResponse> login(@RequestBody JwtUsers user) throws Exception{
		Boolean isVarify = service.verify(user);
		JwtResponse jwtResponse = new JwtResponse();

		if (isVarify) {
			String accessToken = jwtService.generateToken(user.getUsername());
			jwtResponse.setToken(accessToken);
			jwtResponse.setToken_type("Bearer");
			return new ResponseEntity<>(jwtResponse, HttpStatus.OK);
		}

		jwtResponse.setError("You are not authenticated to access this resource");
		return new ResponseEntity<>(jwtResponse, HttpStatus.UNAUTHORIZED);

	}

}
