package com.calculator.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.calculator.Calculator;

class CalculatorTest {

	private Calculator cal;

	@BeforeEach
	void initEach() {
		cal = new Calculator();
	}

	@Nested
	class AddTest {
		@Test
		void testAddingTwoPositives() {
			assertEquals(2, cal.add(1, 1), "Add method should return the sum of two numbers");
		}

		@Test
		void testAddingTwoNegatives() {
			assertEquals(-2, cal.add(-1, -1), "Add method should return the sum of two numbers");
		}

		@Test
		void testAddingAPositiveAndANegative() {
			assertEquals(0, cal.add(-1, 1), "Add method should return the sum of two numbers");
		}
	}

	@Test
	void testMultiply() {
		assertAll(() -> assertEquals(0, cal.multiply(1, 0)), () -> assertEquals(1, cal.multiply(1, 1)),
				() -> assertEquals(6, cal.multiply(2, 3)));
	}

	@Test
	public void testDivide() {

		assertEquals(2, cal.divide(10, 5), "Divide Method should Divide two number");

	}

	@Test
	void testDivideByZero() {
		assertThrows(ArithmeticException.class, () -> cal.divide(1, 0),
				"Divide should throw ArithmeticException when denominator is zero");
	}

}