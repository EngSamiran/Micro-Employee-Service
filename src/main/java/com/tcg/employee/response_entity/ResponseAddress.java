package com.tcg.employee.response_entity;

public class ResponseAddress {
	private long addressId;

	private String city;

	private String locality;

	private String landMark;

	private String pin;

	public ResponseAddress() {
		super();
	}

	public ResponseAddress(long addressId, String city, String locality, String landMark, String pin) {
		super();
		this.addressId = addressId;
		this.city = city;
		this.locality = locality;
		this.landMark = landMark;
		this.pin = pin;
	}

	public long getAddressId() {
		return addressId;
	}

	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public String getLandMark() {
		return landMark;
	}

	public void setLandMark(String landMark) {
		this.landMark = landMark;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

}
