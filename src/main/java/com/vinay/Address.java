package com.vinay;

import lombok.Data;

@Data
public class Address {
	private int id;
	private AddressType type;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String state;
	private String postalcode;
	private String country;
	private String countryCode;
	
	public AddressType getAddressType(String type) {
		switch(type) {
		case "Physical Address": return AddressType.PHYSICAL_ADDRESS;
		case "Postal Address" : return AddressType.POSTAL_ADDRESS;
		case "Business Address": return AddressType.BUSINESS_ADDRESS;
		}
		return null;
	}
}

enum AddressType {
	PHYSICAL_ADDRESS, POSTAL_ADDRESS, BUSINESS_ADDRESS
}