package labs_examples.exception_handling.labs;

import java.util.Arrays;

/**
 * Exception Handling Exercise 5:
 *
 *      Demonstrate how to throw an exception.
 *
 */
class Exercise_05{
	
	public static void main(String[] args) {
		
		try {
			System.out.println(divide(3,0));
		}catch(ArithmeticException e) {
			System.out.println("cannot divide by zero");
		}
	}
	public static int divide(int a,int b) throws ArithmeticException{
		return a/b;
	}
}