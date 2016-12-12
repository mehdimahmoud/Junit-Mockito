package com.mmik.trainings.junit.mockito.calculator;

/**
 * Calculator
 *
 */
public class CalculatorImpl implements Calculator
{
	@Override
	public int add (int num1, int num2){
		int sum = num1 + num2;
		return sum;
	}

	
    public static void main( String[] args ) throws Exception
    {    	
        Calculator calculator = new CalculatorImpl();
        int num1 = 2;
        int num2 = 5;
        int result;
        result = calculator.add(num1,num2);
        
        System.out.println("addition ("+num1+", "+num2+") = "+result);
    }
}
