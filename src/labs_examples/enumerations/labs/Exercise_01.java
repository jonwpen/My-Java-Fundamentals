package labs_examples.enumerations.labs;

import java.util.Scanner;

/**
 * Enumerations Exercise 1:
 *
 *      1) Create an enumeration. Use a controller class to demonstrate the use of the enum from a seperate class.
 *      2) Create a parameterized enumeration that passes one or more values to it's constructor. Demonstrate the use
 *      of this enum from a seperate class.
 */

class Exercise_01{
	public static void main(String[] args) {
		
		//1) Using an enum to label directional buttons for a 2D browser game.
		Direction myDir;
		Scanner sc = new Scanner(System.in);
		System.out.println("Select a direction to move your 2D game character:\n(w)\n(a)\n(s)\n(d)");
		
		switch(sc.nextLine()) {
			case "w" :
				myDir = Direction.UP;
				System.out.println("You move "+myDir);
				break;
			case "a" :
				myDir = Direction.LEFT;
				System.out.println("You move "+myDir);
				break;
			case "s" :
				myDir = Direction.DOWN;
				System.out.println("You move "+myDir);
				break;
			case "d" :
				myDir = Direction.RIGHT;
				System.out.println("You move "+myDir);
				break;
		}
		sc.close();
		//2) Use a parameterized enum to represent a set of Lego bricks.
		Legos[] legoSet = {Legos.BRICK_1X16,Legos.BRICK_1X16,Legos.BRICK_1X16,Legos.PLATE_6X10,Legos.PLATE_6X10,Legos.BRICK_2X4,Legos.SLOPEBRICK_1X2};
		Legos[] legoSet2 = {Legos.BRICK_1X16,Legos.BRICK_1X16,Legos.BRICK_1X16,Legos.PLATE_6X10,Legos.TIRE,Legos.TIRE,Legos.TIRE,Legos.TIRE,};
		
		System.out.println("\nThe total area of your lego set is "+areaOfLegoSet(legoSet)+".\n");
		
		hasWheels(legoSet);
		System.out.println();
		hasWheels(legoSet2);
	
	}
	//method to check to see if a lego set has four tires.
	public static void hasWheels(Legos[] l) {
		int z = 0;
		for(int i = 0;i<l.length;i++) {
			if(l[i].equals(Legos.TIRE)) {
				z++;
			}
		}
		if(z==4) {
			System.out.println("You have enough pieces to build a car.");
		}
		else {
			System.out.println("You do not have enough pieces to build a car.");
		}
	}
	
	//method to get total area of a lego set
	public static int areaOfLegoSet(Legos[] l) {
		int x = 0;
		for(int i = 0;i<l.length;i++) {
			x += l[i].getLength()*l[i].getWidth();
		}
		return x;
	}
}

//enum 1)
enum Direction{
	UP,DOWN,LEFT,RIGHT;
	
//enum 2)
}
enum Legos{
	BRICK_1X16(1,16), BRICK_2X4(2,4), BRICK_2X2(2,2), BRICK_1X1(1,1), 
	PLATE_2X4(2,4), PLATE_6X10(6,10), SLOPEBRICK_1X2(1,2), TILE_1X1(1,1),TIRE(2, 1);
	
	private final int length;
	private final int width;
	
	Legos(int l, int w){
		this.length = l;
		this.width = w;
	}
	public int getLength() {
		return length;
	}
	public int getWidth() {
		return width;
	}
}


