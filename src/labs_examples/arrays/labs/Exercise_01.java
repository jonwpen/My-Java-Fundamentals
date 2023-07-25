package labs_examples.arrays.labs;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Arrays calculator
 *
 *      Take in 10 numbers from the user. Place the numbers in an array. Using the loop of your choice,
 *      calculate the sum of all of the numbers in the array as well as the average.
 *
 *      Print the results to the console.
 *
 */

public class Exercise_01 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in); 	
		
		
		
		int[] userNums = new int[5];
		int sum = 0;
		
		System.out.println("Enter "+userNums.length +" numbers");
		
		for(int i = 0; i < userNums.length; i++) {
			userNums[i] = sc.nextInt();
		}
		
		for(int i = 0; i < userNums.length; i++) {
			sum+=userNums[i];
			
		}
		System.out.println(sum);
		
	
	
	
	
	
	
	
	}
}