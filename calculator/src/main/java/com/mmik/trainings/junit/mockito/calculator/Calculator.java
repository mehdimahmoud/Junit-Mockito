package com.mmik.trainings.junit.mockito.calculator;

/**
 * Hello world!
 *
 */
public class Calculator 
{
	
	public int add (int num1, int num2) throws Exception{
		return num1 + num2;
	}
	
    public static void main( String[] args ) throws Exception
    {    	
        Calculator calculator = new Calculator();
        int num1 = 2;
        int num2 = 5;
        int result = calculator.add(num1,num2);
        
        System.out.println("addition ("+num1+", "+num2+") = "+result);
    }
}
