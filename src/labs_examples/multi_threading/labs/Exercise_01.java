package labs_examples.multi_threading.labs;

/**
 * Multithreading Exercise 1:
 *
 *      1: Create an application that starts a Thread by implementing the Runnable interface
 *      2: Demonstrate at least two distinct ways of initiating a Thread using the Runnable you just created
 *
 */
public class Exercise_01{
	public static void main(String[] args) {
		
		ThreadRunner tR = new ThreadRunner("ThreadRunner");
		
		ThreadRunner2049 tR2 = new ThreadRunner2049();
		Thread thread2 = new Thread(tR2, "ThreadRunner2049");
		thread2.start();
		
		thread2.setPriority(Thread.MAX_PRIORITY);
		tR.thread.setPriority(Thread.MIN_PRIORITY);
		System.out.println("Main thread is done executing");
	}
}
class ThreadRunner implements Runnable{

	Thread thread;
	
	public ThreadRunner(String name) {
		thread = new Thread(this, name);
		thread.start();
	}
	@Override
	public void run() {
		System.out.println("Aaaaand start "+thread.getName()+"...");
		
		for(int i=0;i<5;i++) {
			try {
				Thread.sleep(500);
				System.out.println(i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
class ThreadRunner2049 implements Runnable{

	@Override
	public void run() {
		System.out.println("Aaaaand start "+Thread.currentThread().getName()+"...");
		
		for(int i=0;i<5;i++) {
			try {
				Thread.sleep(500);
				System.out.println(i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}