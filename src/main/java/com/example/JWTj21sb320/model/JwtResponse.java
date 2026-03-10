package com.example.JWTj21sb320.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class JwtResponse {

	private String token;
	private String token_type;
	private String error;

	public JwtResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JwtResponse(String token, String token_type, String error) {
		super();
		this.token = token;
		this.token_type = token_type;
		this.error = error;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getToken_type() {
		return token_type;
	}

	public void setToken_type(String token_type) {
		this.token_type = token_type;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	@Override
	public String toString() {
		return "JwtResponse [token=" + token + ", token_type=" + token_type + ", error=" + error + "]";
	}

}
