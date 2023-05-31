package labs_examples.lambdas.labs;

import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.DoubleFunction;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;
import java.util.function.IntSupplier;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToDoubleBiFunction;

/**
 * Lambdas Exercise 2:
 *
 *      1) Demonstrate the use of 10 pre-built Functional Interfaces from the java.util.functions package. That's right,
 *      10 of them! You can do it! You'll know so much about them when you're done!
 *
 */
public class Exercise_02{
	public static void main(String[] args) {
		//1)
		BiConsumer<Integer,Integer> biCon = (a,b) -> {System.out.println((a*a)+(b*b));};
			biCon.accept(3, 3);
		//2) Function<T,R> is mainly used for mapping an object to another type. Takes in a type and the type it will be converted to. 2 args.
		Function<MyFood,String> func = c -> {return "My favorite food is "+c.getFav();};
			System.out.println(func.apply(new MyFood("sushi")));
		//3)
		IntPredicate intPred = d -> d == 7;
			System.out.println(intPred.test(7));
		//4)
		ToDoubleBiFunction<Double, Double> calculateMedian = (e,f) -> {
			double g = (e + f)/2;
			return g;};
		System.out.println(calculateMedian.applyAsDouble(35.5, 55.5));
		//5)
		IntFunction<Integer> factorialFunc = h -> {
			int x = 0;
			int y = 1;
			for(int i = 0;i < h;i ++) {
				x++;
				y*=x;
			}
			return y;
		};
		System.out.println(factorialFunc.apply(6));
		//6)
		Predicate<String> hasDuplicateLetters = s -> {
				  
			boolean duplicate = false;
				  
			for(int i=0;i<s.length();i++) {
				for(int j=0;j<s.length();j++) {
					if(s.charAt(j)==s.charAt(i) && j !=i) {
						duplicate = true;
					}
				}
			}
			return duplicate;
		};
		System.out.println(hasDuplicateLetters.test("cookies"));
		//7)
		String errand = "Buy dog food";
		Supplier<String> urgentString = () -> errand.toUpperCase()+"!";
		System.out.println(urgentString.get());
		//8)
		IntSupplier intRando = () -> new Random().nextInt(100);
		System.out.println(intRando.getAsInt());
		//9)
		IntConsumer primeCheck = t -> {
			boolean isP = true;
			for(int i=2;i<10;i++) {
				if(t%i==0 && t != i) {
					isP = false;
				}
			}
			if(isP) {
				System.out.println(t+" is prime");
			}
			else {
				System.out.println(t+" is not prime");
			}
		};
		primeCheck.accept(7);
		//10)
		DoubleFunction<Double> mapping = u -> {
			double x = Math.sqrt(u);
			return x;
			};
		System.out.println(mapping.apply(150));
	}
}
//Object for Functional Interfaces #2)
class MyFood{
	String favorite;;
	MyFood(String s){
		this.favorite=s;
	}
	public String getFav() {
		return favorite;
		
	}
}