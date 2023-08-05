package com.vinay;

import java.util.Date;

import lombok.Data;

@Data
public class Root {
	public String id;
	public Type type;
	public AddressLineDetail addressLineDetail;
	public ProvinceOrState provinceOrState;
	public String cityOrTown;
	public Country country;
	public String postalCode;
	public Date lastUpdated;
	public String suburbOrDistrict;
}	

@Data
class Type {
	public String code;
	public String name;
}

@Data
class AddressLineDetail {
	public String line1;
	public String line2;
}

@Data
class Country {
	public String code;
	public String name;
}

@Data
class ProvinceOrState {
	public String code;
	public String name;
}
