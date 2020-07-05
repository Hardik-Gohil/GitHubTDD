package com.incubyte.tdd.stringclass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
		String[] delimiterAndNumber = getDelimiterAndNumber(numbers);
		List<Integer> intNumbers = Arrays.stream(delimiterAndNumber[1].split(delimiterAndNumber[0]))
				.map(Integer::valueOf).collect(Collectors.toCollection(ArrayList::new));
		negativeNumbersCheck(intNumbers);
		return intNumbers.stream().mapToInt(Integer::intValue).filter(num -> num <= 1000).sum();
	}

	public static String[] getDelimiterAndNumber(String numbers) {
		String delimiter = ",|\\n";
		if (numbers.startsWith("//")) {
			String[] delimiterAndNumber = numbers.split("\n");
			if (numbers.startsWith("//[")) {
				Pattern p = Pattern.compile("\\[(.*?)\\]");
				Matcher m = p.matcher(delimiterAndNumber[0]);
				StringJoiner delimiterJoiner = new StringJoiner("|");
				while (m.find()) {
					delimiterJoiner.add("\\Q" + m.group(1) + "\\E");
				}
				delimiter = delimiterJoiner.toString();
			} else {
				delimiter = "\\Q" + delimiterAndNumber[0].replaceFirst("//", "") + "\\E";
			}
			numbers = delimiterAndNumber[1];
		}
		return new String[] { delimiter, numbers };
	}

	public static void negativeNumbersCheck(List<Integer> intNumbers) {
		List<Integer> negativeNumbers = intNumbers.stream().filter(num -> num < 0)
				.collect(Collectors.toCollection(ArrayList::new));
		if (negativeNumbers.size() > 0) {
			throw new RuntimeException("negatives not allowed:" + negativeNumbers.toString());
		}
	}
}
