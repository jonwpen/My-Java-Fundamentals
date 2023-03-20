package labs_examples.exception_handling.labs;

import java.util.Scanner;

/**
 * Exception Handling Exercise 7:
 *
 *      1) Create a custom exception.
 *      2) Demonstrate a method throwing your custom exception.
 */
class Exercise_7
//If you enter a color coordinate outside of the RGB range, a custom exception is thrown.
{
	public static void main(String[] args) {
		
		try {
			int[] s = selectAColor();
			
			for(int i = 0; i < s.length; i++) {
				System.out.println(s[i]+" ");
			}
		} catch (nonRgbException e) {
			System.out.println("error: "+e);
		}
	}
	public static int[] selectAColor() throws nonRgbException{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a red coordinate");
		int a = sc.nextInt();
		System.out.println("Enter a green coordinate");
		int b = sc.nextInt();
		System.out.println("Enter a blue coordinate");
		int c = sc.nextInt();
		int[] color = {a,b,c};
		
		if(a>255 || a<0 || b>255 || b<0 || c>255 || c<0) {
			throw new nonRgbException("Invalid entry for RGB coordinate");
		}
		else {
			return color;
		}
	}
}
class nonRgbException extends Exception{
	nonRgbException(String message){
		super(message);
	}
}
