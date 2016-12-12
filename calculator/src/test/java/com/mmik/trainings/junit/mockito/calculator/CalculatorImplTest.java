package com.mmik.trainings.junit.mockito.calculator;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

// 3. Add a parameterized runner : 
@RunWith(Parameterized.class)
public class CalculatorImplTest {
	private Calculator cal;

	// 1. Declare field and the constructor :
	private int num1, num2, expectedResult;

	public CalculatorImplTest(int num1, int num2, int result) {
		this.num1 = num1;
		this.num2 = num2;
		this.expectedResult = result;
	}

	// 2. Parameterize the test : Create static datas method and add Parameters annotation
	@Parameters
	public static Collection<Integer[]> datas() {
		Integer[][] a = new Integer[][] { 
			{ -1, 2, 1 }, 
			{ 5, 4, 9 }, 
			{ 12, 5, 17 } };
		return Arrays.asList(a);
	}

	/**
	 * @throws Exception
	 */
	@Test
	public void add_should_return_intValue() throws Exception {
		cal = new CalculatorImpl();
		int result = cal.add(num1, num2);
		assertEquals(expectedResult, result);
	}

}
