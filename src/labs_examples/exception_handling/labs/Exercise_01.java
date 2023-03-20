package labs_examples.exception_handling.labs;

/**
 * Exception Handling Exercise 1:
 *
 *      1) Demonstrate a try/catch.
 *
 */
class Exercise_01{
	
	public static void main(String[] args) {
		
			method();
	}
	
	public static void method() {
		try {
		char[] chars = {'a','b','c','1','2','3'};
		char c = chars[1000];
		System.out.println(c);
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("index does not exist");
		}
	}
}
