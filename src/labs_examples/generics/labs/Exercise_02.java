package labs_examples.generics.labs;

/**
 * Generics Exercise 2:   
 *
 *      Create a class with a generic method that takes in an ArrayList of any Numeric type and returns the sum of all
 *      Numbers in the ArrayList. Demonstrate how to call this method from the main() method.
 */
import java.util.ArrayList;

public class Exercise_02{
	public static void main(String[] args) {
		
		ArrayList<Integer> arrInt = new ArrayList<>();
		arrInt.add(3);
		arrInt.add(6);
		arrInt.add(9);
		System.out.println(sumArrayList(arrInt));

		ArrayList<Double> arrByte = new ArrayList<>();
		arrByte.add(122.122);
		arrByte.add(300.2121);
		arrByte.add(12.12);
		sumArrayList(arrByte);
		System.out.println(sumArrayList(arrByte));
		
		ArrayList<Float> arrFloat = new ArrayList<>();
		arrFloat.add(98.76f);
		arrFloat.add(1.99867f);
		arrFloat.add(234.333f);
		sumArrayList(arrFloat);
		System.out.println(sumArrayList(arrFloat));
		
	}
	
	
	
	
	public static <E extends Number> Double sumArrayList(ArrayList<E> aL) {
		
		Double sum = 0.0;
		
		for(int i = 0;i<aL.size();i++) {
			
			sum += aL.get(i).doubleValue();
		}
		
		return sum;
		
	}
}







