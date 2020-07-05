package com.incubyte.tdd.stringclasstest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

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

	@Test
	void sumWithUnknownAmountOfNumbers() {
		assertEquals(28, StringCalculator.Add("1,2,3,4,5,6,7"));
	}

	@Test
	void sumWithNewLinesAndCommasAsDelimiters() {
		assertEquals(6, StringCalculator.Add("1\n2,3"));
	}

	@Test
	void sumWithCustomDelimiters() {
		assertEquals(3, StringCalculator.Add("//;\n1;2"));
	}

	@Test
	void sumWithSecialCharCustomDelimiters() {
		assertEquals(6, StringCalculator.Add("// \n1 2 3"));
	}

	@Test
	void sumWithNegativeNumbers() {
		try {
			StringCalculator.Add("-1,2");
			fail("Exception Expected");
		} catch (Exception e) {
			assertEquals("negatives not allowed:[-1]", e.getMessage());
		}
	}
}
