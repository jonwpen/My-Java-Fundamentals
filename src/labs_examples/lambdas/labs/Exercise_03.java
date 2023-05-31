package labs_examples.lambdas.labs;

import java.util.function.BiFunction;
import java.util.function.IntPredicate;
import java.util.function.IntUnaryOperator;

/**
 * Lambdas Exercise 3:
 *
 *      1) Demonstrate the use of a static method reference
 *      2) Demonstrate the use of an instance method reference
 *      3) Demonstrate the use of a constructor reference
 *
 */
public class Exercise_03{
	public static void main(String[] args) {
		//1)
		IntPredicate i = Exercise_03 :: intInRange;
		boolean x = i.test(30);
		System.out.println(x);
		//2)
		exampleThreeClass etc = new exampleThreeClass();
		IntUnaryOperator iuo = etc :: additionLoop;
		int j = iuo.applyAsInt(2);
		System.out.println(j);
		
        BiFunction<String,Double, Job> getJob = Job::new;
        Job job = getJob.apply("Backend Engineer", 80000.00);
        System.out.println(job.toString());
	}
	//1)
	public static boolean intInRange(int a) {
		if(a > 50 && a < 100) {
			return true;
		}
		else {
			return false;
		}
	}
}
//2)
class exampleThreeClass{
	public int additionLoop(int a) {
		for(int i=0;i<+10;i++) {
			a+=a;
		}
		return a;
	}
}
//3)
class Job {
    String title;
    double salary;

    public Job(String t, double s) {
        this.title = t;
        this.salary = s;
        
    }
	@Override
	public String toString() {
		return "Job [title=" + title + ", salary=" + salary + "]";
	}
}