package labs_examples.multi_threading.labs;

/**
 * Multithreading Exercise 6:
 *
 *      Write a program that will print 1-100 sequentially from at least two distinct threads. For instance, thread1 will
 *      print "1", then thread2 will print "2", then thread1 will print "3", then thread2 will print "4" and so on.
 */

public class Exercise_06{
	public static void main(String[] args) {
		
		final Object lockObj2 = new Object();
		
			Counter c1 = new Counter("Thread 1",lockObj2);
			Counter c2 = new Counter("Thread 2",lockObj2);
		
			c1.start();
			c2.start();
	}
}
class Counter extends Thread{
	String name;
	//Using static modifier so every Counter object will share the same variable
	static int num = 1;
	final Object lockObj;
	Thread thread;
	
	Counter(String n, Object lockObj){
		this.name = n;
		this.lockObj = lockObj;

	}
	@Override
	public void run(){
		while(num <= 100) {
			synchronized(lockObj) {
				if((num%2==0 && name.equals("Thread 1")) || (num%2==1 && name.equals("Thread 2"))) {
					System.out.println(name + " - " + num);
					num++;
					lockObj.notifyAll();
			}
				else {
					try {
						lockObj.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}