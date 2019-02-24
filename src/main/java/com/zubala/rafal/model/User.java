package com.zubala.rafal.model;

import java.util.Optional;

public class User {
	private Address address;
	
	private String email;
	
	private String password;
	
    private String position;

	public User(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	public Optional<Address> getAddress() {
		return Optional.ofNullable(address);
	}

    public Optional<String> getPosition() {
        return Optional.ofNullable(position);
    }
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPosition(String position) {
		this.position = position;
	}
}
