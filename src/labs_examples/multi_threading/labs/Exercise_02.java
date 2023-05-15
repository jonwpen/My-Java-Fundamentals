package labs_examples.multi_threading.labs;

/**
 * Multithreading Exercise 2:
 *
 *      Create an application that creates a Thread using the Thread class
 */
public class Exercise_02 {
	public static void main(String[] args) {
		
		ChildOfThread cOT = new ChildOfThread("ThisThreadRightHere");
	}
}
class ChildOfThread extends Thread{
	
	ChildOfThread(String name){
		super(name);
		start();
	}
	@Override
	public void run() {
		System.out.println("Starting "+this.getName()+" thread...");
		
		for(int i=0;i<7;i++) {
			try {
				System.out.println(i*5);
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}