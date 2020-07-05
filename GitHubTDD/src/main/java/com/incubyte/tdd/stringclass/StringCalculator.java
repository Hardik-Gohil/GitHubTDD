package com.incubyte.tdd.stringclass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.util.StringUtils;

public class StringCalculator {
	
	private static int addInvokedCount = 0;
	
	public static int GetCalledCount() {
		return addInvokedCount;
	}
	
	public static int Add(String numbers) {
		addInvokedCount++;
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
		List<Integer> intNumbers = Arrays.stream(numbers.split(delimiter)).map(Integer::valueOf).collect(Collectors.toCollection(ArrayList::new));
		List<Integer> negativeNumbers = intNumbers.stream().filter(num -> num < 0).collect(Collectors.toCollection(ArrayList::new));
		if (negativeNumbers.size() > 0) {
			throw new RuntimeException("negatives not allowed:" + negativeNumbers.toString());
		}
		return intNumbers.stream().mapToInt(Integer::intValue).filter(num -> num <= 1000).sum();
	}
}
