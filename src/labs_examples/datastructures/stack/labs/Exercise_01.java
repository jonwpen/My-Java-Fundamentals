package labs_examples.datastructures.stack.labs;

import java.util.Stack;

/**
 *      Demonstrate your mastery of Java's built-in Stack class by completing the following:
 *
 *      1) instantiate a new Stack
 *      2) demonstrate the use of EVERY method in the Stack class - there are 5
 */
public class Exercise_01{
	public static void main(String[] args) {
		
		Stack<Integer> intStack = new Stack<>();
		
		intStack.push(3);
		intStack.push(6);
		intStack.push(9);
		intStack.push(12);
		intStack.push(15);
		intStack.push(18);
		intStack.push(21);
		
		int x = intStack.pop();
		System.out.println(x);
		System.out.println("Top element: "+intStack.peek());
		System.out.println("Size: "+intStack.size());
		System.out.println("Is empty: "+intStack.empty());
		System.out.println(intStack.search(3));
		
		System.out.println("Sum of stack elements: "+stackSum(intStack));
	}
	public static int stackSum(Stack<Integer> y) {
		
		int x = 0;
		while((!y.empty())) {
			x += y.pop();
		}
		return x;
	}
}