package com.vinay;

public class HighestCommonFactor {

	public static int hcf(int x, int y) {
		if (y == 0)
			return x;
		return hcf(y, x % y);
	}
}
