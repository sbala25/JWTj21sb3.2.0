package com.example.JWTj21sb320.controller;

import com.example.JWTj21sb320.model.ApiError;
import jakarta.servlet.http.HttpServletRequest;
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

import java.time.LocalDateTime;

@RestController
public class AuthenticateController {

	@Autowired
	private JwtUserService service;

	@Autowired
	private JwtService jwtService;

	@PostMapping("/authenticate")
	public ResponseEntity<?> login(@RequestBody JwtUsers user, HttpServletRequest request){
		Boolean isVarify = service.verify(user);
		JwtResponse jwtResponse = new JwtResponse();

		if (isVarify) {
			String accessToken = jwtService.generateToken(user.getUsername());
			jwtResponse.setToken(accessToken);
			jwtResponse.setToken_type("Bearer");
			return new ResponseEntity<>(jwtResponse, HttpStatus.OK);
		}

		ApiError error = new ApiError(
				HttpStatus.UNAUTHORIZED.value(),
				HttpStatus.UNAUTHORIZED.getReasonPhrase(),
				"You are not authorized to access this resource",
				request.getRequestURI(),
				LocalDateTime.now()
		);

		return new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);

	}

}
