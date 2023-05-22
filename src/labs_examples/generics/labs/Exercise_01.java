package labs_examples.generics.labs;

/**
 * Generics Exercise 1:
 *
 *      1.) Write a generic class with at least two instance variables, a constructor, and getter and setter methods.
 *      2.) Create a few objects of your generic class with different data types to demonstrate it's
 *          dynamic usage.
 */

public class Exercise_01{
	
	public static void main(String[] args) {
		
		ExOneGeneric<Integer> eog1 = new ExOneGeneric<>(3,6);
		ExOneGeneric<Double> eog2 = new ExOneGeneric<>(3.3,6.6);
		ExOneGeneric<String> eog3 = new ExOneGeneric<>("3","6");
		
		System.out.println(eog1.x + eog1.y);
		System.out.println(eog2.x * eog2.y);
		
		eog3.setX("Java is fun. Coffee is good. ");
		eog3.setY("My foot is asleep. My phone is dead. ");
		System.out.println(eog3.x+eog3.y);
	}
}
class ExOneGeneric <T>{
	
	T x;
	T y;
	
	ExOneGeneric(T x, T y){
		this.x=x;
		this.y=y;
	}

	public T getX() {
		return x;
	}

	public void setX(T x) {
		this.x = x;
	}

	public T getY() {
		return y;
	}

	public void setY(T y) {
		this.y = y;
	}
	
	
}