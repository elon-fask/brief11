package com.springboot.brief11.payload.request;


import javax.validation.constraints.NotBlank;

public class LoginRequest {
	@NotBlank
  private String firstName;
	
	@NotBlank
	private String lastName;

	@NotBlank
	private String password;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}