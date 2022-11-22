package labs_examples.datatypes_operators.labs;

/**
 * Fundamentals Exercise 4: Volume and Surface Area
 *
 *      Write the necessary code to calculate the volume and surface area of a cylinder
 *      with a radius of 3.14 and a height of 5. Print out the result.
 *
 */

public class Exercise_06 {

    public static void main(String[] args) {

        // write code here

    	
    	double radius = 3.14;
    	int height = 5;
    	double volume = Math.PI*(radius*radius)*height;
    	
    	System.out.println("Volume: "+volume);
    	
    	double surfaceArea = (Math.PI*(radius*radius))+(Math.PI*(radius*radius))+(height*Math.PI*(radius*2));
    	
    	System.out.println("Surface area: "+surfaceArea);
    	
    	
    	
    }
}




//Volume of a cylinder:
//area = pi * rSquared
//volume = area * height

//Surface area of a cylinder:
//pi * rSquared + pi * rSquared + h * pi * diameter