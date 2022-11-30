package labs_examples.arrays.labs;

/**
 *  Irregular Arrays
 *
 *      Create and populate a 2 dimensional irregular array of size and contents of your choosing. Using a nested
 *      "for-each" loop, iterate and print out each element of the array.
 *
 */

public class Exercise_04 {

	public static void main(String[] args) {
		
		int[][] irregArray = {{22,33,44},{11,12,13,14},{98,97,96,95,94,93,92}};
		
		for(int[] i: irregArray) {
			for(int j: i) {
				System.out.print(j+" > ");
			}
			System.out.println();
		}
		
		
	}
}
