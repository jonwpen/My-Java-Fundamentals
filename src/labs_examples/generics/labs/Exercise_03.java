package labs_examples.generics.labs;

import java.util.ArrayList; 
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Generics Exercise 3:
 *
 *      1) Write a generic method that accepts two generic arguments. This generic method should only accept
 *      arguments which are subclasses of Number. The generic method must return the sum (as a double) of whatever two
 *      numbers were passed in regardless of their type.
 *
 *      2) Write a generic method to count the number of elements in a "Collection" of Strings that are palindromes

 *      3) Write a generic method to exchange the positions of two different elements in an array.
 *
 *      4) Write a generic method to find the largest element within the range (begin, end) of a list.
 *
 */
public class Exercise_03{
	public static void main(String[] args) {
		
		//1)
		int num1 = 23;
		double num2 = 1.618;
		System.out.println("problem #1 sum: "+sumTwo(num1,num2));
		
		//2)
		ArrayList<String> aLS = new ArrayList<>();
		aLS.add("SpaceX");
		aLS.add("Starship");
		aLS.add("NASA");
		aLS.add("racecar");
		aLS.add("future");
		aLS.add("noon");
		aLS.add("Mars");
		aLS.add("Falcon");
		aLS.add("tenet");
		aLS.add("Arthur C. Clark");
		
		System.out.println("problem #2 total palindromes: "+palindromeCounter(aLS));
		
		//3)
        Integer[] intArr = {55, 44, 33, 22, 11,0};
        int index1 = 4;
        int index2 = 5;
        String[] s = {"She's","just","a","small","town","girl"};

        System.out.println("Problem #3 swapped elements: ");
        elementSwapper(s,index1,index2);
        elementSwapper(intArr,index1,index2);
		
		//4)
		ArrayList<Integer> arrInt = new ArrayList<>();
		int rangeA = 10;
		int rangeB = 5; 
		int arrIncrement = 2;
		for(int i = 0;i < 30;i ++) {
			arrIncrement += 2;
			arrInt.add(arrIncrement);
		}
		Collections.shuffle(arrInt);
		System.out.println("problem #4 largest in a range: ");
		for(int i=0;i<arrInt.size();i++) {
		 	System.out.print(arrInt.get(i)+" ");
		}
		System.out.println();
		System.out.println(maxValInRange(arrInt,rangeA,rangeB));
	}
	//1)
	public static <T extends Number> double sumTwo(T a, T b) {
		return a.doubleValue()+b.doubleValue();
	}
	//2)
    public static boolean palindromeCheck(String s) {
		boolean b = true;
    	int stringEnd = s.length()-1;
    	int stringSum = 0;
    	
    	for(int i = 0; i<s.length(); i++) {
    		if(s.charAt(i) == s.charAt(stringEnd)) {
    			stringSum++;
    		}
    		stringEnd--;
    	}
    	int sEnd = s.length();
    	if(stringSum == sEnd) {
    		//System.out.println("String is a palindrome"); //Test
    			return b;
    		}
    	else{
    		//System.out.println("String is not a palindrome"); //Test
    		b = false;
    	}
    	return b;
    }
    //higher order function - method that calls a method
    public static <T extends Collection<String>> int palindromeCounter(T t) {
    	int palinTotal = 0;
    	
    	for(String str : t) {
    		if(palindromeCheck(str)) {
    			palinTotal++;
    		}
    	}
		return palinTotal;
    }
    //3)
    public static  <T> void elementSwapper(T[] array, int a, int b) {
        // Swap the elements with a temp
        T temp = (T) array[a];
        array[a] = array[b];
        array[b] = temp;

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }
	//4)
	public static <T extends Comparable<T>> T maxValInRange(List<T> t, int a, int b) {
		//T will be a list, so it can use all the list methods
		int upperGiven;
		int lowerGiven;
		  
		if(a > b) {
			upperGiven = a;
			lowerGiven = b;
		}
		else {
			upperGiven = b;
			lowerGiven = a;
		}
		T maxVal = t.get(lowerGiven);
		for (int i = lowerGiven; i <= upperGiven; i++) {
		      if (t.get(i).compareTo(maxVal) >= 0 && i <= upperGiven) {
		          maxVal = t.get(i);
		      }
		  }
		//return type is generic
		return maxVal;
	}
}