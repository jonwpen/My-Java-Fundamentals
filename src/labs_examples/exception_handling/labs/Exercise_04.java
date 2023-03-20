package labs_examples.exception_handling.labs;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Exception Handling Exercise 4:
 *
 *      Demonstrate a nested try/catch.
 *
 */
class Exercise_04{
	
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		
		try {
			System.out.println("Please enter a number to divide");
			int x = sc.nextInt();
			System.out.println("Please enter a number to divide by");
			int y = sc.nextInt();		
	
			try {
				System.out.println(divide(x,y));	
			}catch(ArithmeticException e) {
				System.out.println("cannot divide by zero");		
			}
		}catch(Exception e) {
			System.out.println("error");
		}
	}
	public static int divide(int a,int b) {
		return a/b;
	}
}




