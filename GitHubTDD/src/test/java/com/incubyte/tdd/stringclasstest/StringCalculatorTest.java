package com.incubyte.tdd.stringclasstest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.incubyte.tdd.stringclass.StringCalculator;

class StringCalculatorTest {

	@Test
	void sumWithEmptyNumbers() {
		assertEquals(0, StringCalculator.Add(""));
	}

	@Test
	void sumWithOneNumbers() {
		assertEquals(1, StringCalculator.Add("1"));
	}

	@Test
	void sumWithTwoNumbers() {
		assertEquals(3, StringCalculator.Add("1,2"));
	}

}
