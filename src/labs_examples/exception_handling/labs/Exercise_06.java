package labs_examples.exception_handling.labs;

/**
 * Exception Handling Exercise 6:
 *
 *      Demonstrate throwing an exception in one method and catching it in another method.
 *
 */

class Exercise_06{
	
	public static void main(String[] args) {
		
		try {
			System.out.println(divide(3,0));
		}catch(ArithmeticException e) {
			System.out.println("...caught");
		}
	}
		public static int divide(int a,int b) throws ArithmeticException{
			try {
			return a/b;
		}catch(ArithmeticException e) {
			System.out.println("catching an re-throwing exception to calling method");
			throw e;
		}
	}
}