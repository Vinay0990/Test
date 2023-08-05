package com.vinay;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class HighestCommonFactorTest {

	@Test
	public void SimpleTest1() {
		assertEquals(HighestCommonFactor.hcf(6,4), 4);
	}
	
	@Test
	public void SimpleTest2() {
		assertEquals(HighestCommonFactor.hcf(47,91), 1);
	}

}
