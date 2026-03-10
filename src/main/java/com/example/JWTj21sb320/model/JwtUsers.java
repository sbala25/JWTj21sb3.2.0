package com.example.JWTj21sb320.model;

public class JwtUsers {
	private String username;
    private String password;
	public JwtUsers(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "JwtUsers [username=" + username + ", password=" + password + "]";
	}
    
    
}
