package labs_examples.lambdas.labs;

import java.util.Random;
import java.util.function.Consumer;
import java.util.function.DoubleSupplier;

/**
 * Lambdas Exercise 1:
 *
 *      1) Demonstrate creating a functional interface with an abstract method that takes no parameters and returns void
 *      2) Implement the previous functional interface with a lambda expression and use it. Also demonstrate creating
 *          an anonymous inner class from this interface.
 *
 *      3) Demonstrate creating a functional interface with an abstract method that takes 1 parameter and returns a
 *          value of the same type as the parameter
 *      4) Implement the previous functional interface with a lambda expression and use it. Also demonstrate creating
 *          an anonymous inner class from this interface.
 *
 *      5) Demonstrate creating a functional interface with an abstract method that takes 2 parameters and returns a
 *          value
 *      6) Implement the previous functional interface with a lambda expression and use it. Also demonstrate creating
 *          an anonymous inner class from this interface.
 *
 *      7) Demonstrate the use of at least two built-in functional interfaces from the java.util.function package.
 */
public class Exercise_01{
	
	public static void main(String[] args) {
		//2)
		InterfaceOne inOne = () -> System.out.println("Hello, John");
		inOne.helloPrinter();
		InterfaceOne inOne2 = new InterfaceOne() {
			@Override
			public void helloPrinter() {
				System.out.println("Hello, again");
			}
		};
		inOne2.helloPrinter();
		//4)
		InterfaceTwo inTwo = a -> a*5;
		System.out.println(inTwo.intMethod(7));
		InterfaceTwo inTwo2 = new InterfaceTwo() {
			@Override
			public int intMethod(int a) {
				return a*50;
			}
		};
		System.out.println(inTwo2.intMethod(7));
		//6)
		InterfaceThree inThree = (a, b) -> a+" "+b;
		System.out.println(inThree.concatMethod("My glasses are", "plastic"));
		InterfaceThree inThree2 = new InterfaceThree() {
			@Override
			public String concatMethod(String a, String b) {
				return "Anonymous inner class: "+a+" "+b;
			}
		};
		System.out.println(inThree2.concatMethod("Almost finished with course:", "Java Programming!"));
		//7)
		DoubleSupplier dubSup = () -> {return new Random().nextDouble(100);};
			System.out.println(dubSup.getAsDouble());
		Consumer<Integer> circleArea = i -> {System.out.println(3.14*(i*i));};
			circleArea.accept(7);
	}
}
//1)
@FunctionalInterface
interface InterfaceOne{
	public void helloPrinter();
}
//3)
@FunctionalInterface
interface InterfaceTwo{
	public int intMethod(int a);
}
//5)
@FunctionalInterface
interface InterfaceThree{
	public String concatMethod(String a, String b);
}


