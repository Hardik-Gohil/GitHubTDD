package com.incubyte.tdd.stringclass;

import java.util.Arrays;

import org.springframework.util.StringUtils;

public class StringCalculator {

	public static int Add(String numbers) {
		if (!StringUtils.hasLength(numbers)) {
			return 0;
		} else if (numbers.length() == 1) {
			return Integer.parseInt(numbers);
		}
		return Arrays.stream(numbers.split(",|\n")).mapToInt(Integer::valueOf).sum();
	}
}
