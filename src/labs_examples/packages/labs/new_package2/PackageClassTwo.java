package labs_examples.packages.labs.new_package2;

import labs_examples.packages.labs.new_package1.PackageClassOne;

public class PackageClassTwo {

	int x = 3;
	int y = 4;
	
	public PackageClassTwo(){
		PackageClassOne pc1 = new PackageClassOne();
		
		//public method from PackageClassOne is visible to this package and can be called.
		pc1.addTwo(y, x);
		//protected method is not visible.
		//pc1.multiplyTwo(x, y);
		
	}
	public void printSomething(){
		System.out.println("Printing a public method");
	}
	protected void printSomethingElse(){
		System.out.println("Printing a protected method");
	}
}







