package labs_examples.exception_handling.labs;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Exception Handling Exercise 2:
 *
 *      Demonstrate a try/catch with multiple catch statements.
 *
 */


class Exercise_02{
	
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		
		try {
		System.out.println("Please enter a number to divide");
		int x = sc.nextInt();
		System.out.println("Please enter a number to divide by");
		int y = sc.nextInt();		
		
			System.out.println(divide(x,y));
		}catch(ArithmeticException e) {
			System.out.println("cannot divide by zero");
		}catch(InputMismatchException f) {
			System.out.println("enter a number");
			sc.hasNext();
		}

	}
	public static int divide(int a,int b) {
		return a/b;
	}
}