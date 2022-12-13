package labs_examples.objects_classes_methods.labs.methods;

/**
 * Created by ryandesmond - https://codingnomads.co
 */
public class Exercise_01 {

    public static void main(String[] args) {

        // please create the methods as instructed below then
        // call each of those methods from here, within the main()
    	int a = 3;
    	int b = 6;
    	int years = 9;
    	
    	a = multiply(a,b);
    	b = divide(a,b);
    	
    	
    	System.out.println(a);
    	System.out.println(b);
    	jokeTeller();
    	System.out.println(years(years));
    }


    // 1) Create a static multiply() method below that takes two int arguments (int a, int b) and
    //    returns the result of a * b
    public static int multiply(int a, int b) {
    	return a*b;
    }


    // 2) Create a static divide() method below that takes two int arguments (int a, int b) and
    //    returns the result of a / b
    public static int divide(int a, int b) {
    	return a / b;
    }


    // 3) Create a static void method that will print of joke of your choice to the console
    public static void jokeTeller() {
    	System.out.println("I wouldn't call myself a fan of Steampunk. But I will say, it's the healthiest way to prepare punk");
    }


    // 4) Create a static method that takes in a number in years (int years) as an argument
    //    and returns the number of seconds that number in years represents
    public static long years(int years) {
    	long seconds = years * 365 * 24 * 60 * 60;
    	return seconds;
    }


    // 5) Create a varargs method that will return the length of the varargs array passed in
    public static void rargNums(int...x) {
    	for(int num: x) {
    		System.out.println(num);
    	}
    }






}
