package labs_examples.arrays.labs;

/**
 *  2D Array
 *
 *      Create and populate a 5x5 2D array with multiples of 3, starting with 3. Once populated, print out the results.
 *
 *      The output should look something like this:
 *
 *      3 6 9 12 15
 *      18 21 24 27 30
 *      ...
 *      ...
 *      ...
 *
 */

public class Exercise_03 {

    public static void main(String[] args) {
        
    	int[][] array = new int[5][5];

    	int x = 0;
    	

    	for(int i=0;i<array.length;i++) {
    		for(int j=0;j<array[i].length;j++) {
    			//arrayX[i][j]=xThree;
    			
    			x++;
    			array[i][j]=x*3;
    			
    		}
    	}
    	for(int i=0;i<array.length;i++) {
    		for(int j=0;j<array[i].length;j++) {
    			System.out.print(array[i][j]+" ");
    			
    			
    		}
    		System.out.println();
    	}
    	
    }
}
