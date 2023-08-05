package com.vinay;

import java.util.List;

public class MainTest {

	public static void main(String[] args) {
		// Highest Common Factor
		// Used Euclidean Algorithm for finding the HCF
		// https://en.wikipedia.org/wiki/Euclidean_algorithm
		
		System.out.println(HighestCommonFactor.hcf(4, 6));   // Answer 2
		System.out.println(HighestCommonFactor.hcf(5, 7));   // Answer 1
		
		
		System.out.println("---------------------------------------------------------");
		// Json Reader
		// used Jackson json reader library
		// https://github.com/FasterXML/jackson
		
		JsonReader reader = new JsonReader();
		List<Address> addresses = reader.readJsonFile();
		JsonReaderUtils.prettyPrintAll(addresses);

		System.out.println("---------------------------------------------------------");
		JsonReaderUtils.prettyPrintType(addresses, AddressType.PHYSICAL_ADDRESS);
	}

}
