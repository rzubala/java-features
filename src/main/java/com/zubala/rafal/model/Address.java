package com.zubala.rafal.model;

import java.util.Optional;

public class Address {
	private Country country;

	public void setCountry(Country country) {
		this.country = country;
	}
	
    public Optional<Country> getCountry() {
        return Optional.ofNullable(country);
    }
}
