package com.vinay;

import java.util.List;

public class JsonReaderUtils {

	public static void prettyPrintType(List<Address> addresses, AddressType type) {
		addresses.stream().filter(add -> add.getType().equals(type))
				.forEach(add -> System.out.println(prettyPrintAddress(add)));
	}

	public static void prettyPrintAll(List<Address> addresses) {
		addresses.forEach(add -> System.out.println(prettyPrintAddress(add)));
	}

	public static Address convertRootToAddress(Root root) {
		Address add = new Address();
		add.setCity(root.getCityOrTown());

		if (root.getCountry() != null) {
			add.setCountryCode(root.getCountry().getCode());
			add.setCountry(root.getCountry().getName());
		}

		add.setPostalcode(root.getPostalCode());

		if (root.getAddressLineDetail() != null) {
			AddressLineDetail addDetail = root.getAddressLineDetail();
			add.setAddressLine1(addDetail.getLine1());
			add.setAddressLine2(addDetail.getLine2());
		}

		if (root.getProvinceOrState() != null)
			add.setState(root.getProvinceOrState().getName());

		add.setType(add.getAddressType(root.getType().name));

		return add;
	}

	public static String prettyPrintAddress(Address add) {
		StringBuilder format = new StringBuilder();

		if (add.getAddressLine1() != null) {
			format.append(add.getAddressLine1() + "-");
		}

		if (add.getAddressLine2() != null) {
			format.append(add.getAddressLine2() + "-");
		}

		format.append(add.getCity() + "-");

		if (add.getState() != null)
			format.append(add.getState() + "-");

		format.append(add.getPostalcode() + "-");

		format.append(add.getCountryCode() + "-");
		format.append(add.getCountry());

		return format.toString();
	}

	public static boolean validateAddress(Address add) {
		boolean checkPostalCode = add.getPostalcode().chars().allMatch(Character::isDigit);
		boolean checkCity = add.getCity() != null;

		boolean checkAddLines = (add.getAddressLine1() != null || add.getAddressLine2() != null)
				&& (add.getAddressLine1().matches("^(?!\\s*$).+") || add.getAddressLine2().matches("^(?!\\s*$).+"));

		boolean isCountryZA = add.getCountryCode().equals("ZA") ? add.getState() != null : true;
		return checkPostalCode && checkCity && checkAddLines && isCountryZA;
	}

}