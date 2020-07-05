package com.incubyte.tdd.stringclasstest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.incubyte.tdd.stringclass.StringCalculator;

class StringCalculatorTest {

	private static int addInvokedCountTest = 0;

	@BeforeEach
	private void invokingAdd() {
		addInvokedCountTest++;
	}

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

	@Test
	void sumWithMultipleNegativeNumbers() {
		try {
			StringCalculator.Add("//:\n1:-2:3:4:5:-6:7:-8");
			fail("Exception Expected");
		} catch (Exception e) {
			assertEquals("negatives not allowed:[-2, -6, -8]", e.getMessage());
		}
	}

	@Test
	void invocationCountOfAddTest() {
		addInvokedCountTest--;
		assertEquals(addInvokedCountTest, StringCalculator.GetCalledCount());
	}

	@Test
	void sumWithNumberBiggerThanThousand() {
		assertEquals(2000, StringCalculator.Add("1000,1001,999,1"));
	}

	@Test
	void sumWithAnyLengthOfDelimiters() {
		assertEquals(6, StringCalculator.Add("//[***]\n1***2***3"));
	}
	
	@Test
	void sumWithMultipleDelimitersDelimiters() {
		assertEquals(6, StringCalculator.Add("//[*][%]\n1*2%3"));
	}
}
