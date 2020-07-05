package com.incubyte.tdd.stringclass;

import org.springframework.util.StringUtils;

public class StringCalculator {

	public static int Add(String numbers) {
		if (!StringUtils.hasLength(numbers)) {
			return 0;
		} else if (numbers.length() == 1) {
			return Integer.parseInt(numbers);
		} else {
			String[] number = numbers.split(",");
			return Integer.parseInt(number[0]) + Integer.parseInt(number[1]);
		}
	}
}
