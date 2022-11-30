package labs_examples.arrays.labs;

import java.util.ArrayList;
import java.util.Collections;

/**
 *  ArrayLists
 *
 *      Please demonstrate how to create an ArrayList, populate an array list, access elements within an ArrayList.
 *      Also take a moment to explore the many methods that are available to you when you use an ArrayList. By simply
 *      typing the dot operator (".") after the ArrayList object that you create. You should see a menu pop up that
 *      shows a list of methods.
 *
 */
public class Exercise_07 {
	
	public static void main(String[] args) {
		
		ArrayList<String> colors = new ArrayList();
		
		colors.add("red");
		colors.add("green");
		colors.add("blue");
		colors.add("cyan");
		colors.add("magenta");
		colors.add("yellow");
		colors.add("black");
		
		
		
		if(!(colors.isEmpty())) {
			System.out.println("This list contains information");
			System.out.println();
		}
		else {
			System.out.println("This list is empty");
		}
		
		System.out.println(colors.get(3));
		System.out.println();
		
		Collections.shuffle(colors);
		for(String i: colors) {
			System.out.println(i);
		}
		
	}
}
