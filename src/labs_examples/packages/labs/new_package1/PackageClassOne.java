package labs_examples.packages.labs.new_package1;

import labs_examples.packages.labs.new_package2.PackageClassTwo;

public class PackageClassOne {
	
	
	public static void main(String[] args) {
		
		PackageClassTwo pc2 = new PackageClassTwo();
		
		//public method is visible to PackageClassOne class.
		pc2.printSomething();
		//protected method is not visible to this package.
		//pc2.printSomethingElse();
	
	}
	public int addTwo(int a,int b) {
		int c = a+b;
		return c;
		
	}
	protected int multiplyTwo(int a,int b) {
		int c = a+b;
		return c;
		
	}


}
