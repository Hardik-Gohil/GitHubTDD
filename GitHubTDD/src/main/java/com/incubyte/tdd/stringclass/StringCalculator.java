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
		String delimiter = ",|\\n";
		if(numbers.startsWith("//")) {
			String[] delimiterAndNumber = numbers.split("\n");
			delimiter = delimiterAndNumber[0].replaceFirst("//", "");
			numbers = delimiterAndNumber[1];
 		} 
		return Arrays.stream(numbers.split(delimiter)).mapToInt(Integer::valueOf).sum();
	}
}
