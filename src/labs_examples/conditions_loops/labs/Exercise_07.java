package labs_examples.conditions_loops.labs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Conditions and Loops Exercise 7: First vowel
 *
 *      Take in a word from the user and using a "while" loop, find the first vowel in the word.
 *      Once you find the vowel, print out the word and the first vowel.
 *
 *      Hints:
 *          - there are a few helpful methods in the String class called length(), charAt() and indexOf()
 *          - you'll likely want to use a String that contains all the vowels:
 *              - ie: String vowels = "aeiou";
 *
 */

public class Exercise_07 {
	public static void main (String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String vowels = "aeiou";
		
		System.out.println("Enter a word:");
		
		String word = sc.nextLine();
		
		int counter = 0;
		
		List<Character> collectedVowels = new ArrayList<Character>(); //To print only the first vowel found in a word, I will use this to print index 0.
		
		System.out.println(word);
		
		while(counter < word.length()) { 
			for(int i =0; i< vowels.length(); i++) {
				if(word.charAt(counter)==vowels.charAt(i)) {
					collectedVowels.add(vowels.charAt(i));
				}
			}
			counter++;
		}
		
		System.out.println(collectedVowels.get(0));
	}
}
