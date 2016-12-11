package com.mmik.trainings.junit.mockito.calculator;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class CalculatorTest 
{
    private Calculator cal;

    /**
     * @throws Exception 
     */
    @Test
    public void add_should_return_intValue() throws Exception
    {
    	cal = new Calculator();
    	int result = cal.add(2, -4);
        assertEquals(-2, result);
    }
    
}
