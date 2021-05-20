package com.cg.ofr.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity

public class FlatAddress {

	@Id
	@Column(name = "HOUSE_NO")
	private int houseNo;
	@Column(name = "STREET", length = 20)
	@NotNull(message = "Street is mandatory")
	private String street;
	@Column(name = "CITY", length = 20)
	@NotNull(message = "City is mandatory")
	private String city;
	@Column(name = "STATE", length = 20)
	@NotNull(message = "State is mandatory")
	private String state;
	@Column(name = "PIN")
	private long pin;
	@Column(name = "COUNTRY", length = 20)
	@NotNull(message = "Country is mandatory")
	private String country;
	
	public FlatAddress() {
		super();
	}

	public FlatAddress(int houseNo, String street, String city, String state, long pin, String country) {
		super();
		this.houseNo = houseNo;
		this.street = street;
		this.city = city;
		this.state = state;
		this.pin = pin;
		this.country = country;
	}
	

	
	public int getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(int houseNo) {
		this.houseNo = houseNo;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public long getPin() {
		return pin;
	}

	public void setPin(long pin) {
		this.pin = pin;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "FlatAddress [houseNo=" + houseNo + ", street=" + street + ", city=" + city + ", state=" + state
				+ ", pin=" + pin + ", country=" + country + "]";
	}
	
}
