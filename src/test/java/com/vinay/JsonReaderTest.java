package com.vinay;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class JsonReaderTest {
	
	public JsonReader reader;

	@Before
	public void setUp() throws Exception {
		this.reader = new JsonReader();
	}

	@Test
	public void checkAddressCount() {
		assertEquals(this.reader.readJsonFile().size(), 3);
	}
	@Test
	public void checkValidateAddressLines() {
		Address add = new Address();
		add.setAddressLine1(null);
		add.setAddressLine2(null);
		add.setCity("Mumbai");
		add.setCountry("India");
		add.setCountryCode("IN");
		add.setPostalcode("A1234");
		
		assertEquals(JsonReaderUtils.validateAddress(add), false);
	}
	
	@Test
	public void checkValidateZip() {
		Address add = new Address();
		add.setAddressLine1(null);
		add.setAddressLine2(null);
		add.setCity("Mumbai");
		add.setCountry("India");
		add.setCountryCode("IN");
		add.setPostalcode("A1234");
		assertEquals(JsonReaderUtils.validateAddress(add), false);

	}
}
