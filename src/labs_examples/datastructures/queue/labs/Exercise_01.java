package labs_examples.datastructures.queue.labs;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 *      Demonstrate your mastery of Java's (sun's) built-in Queue class (as seen in the import statement
 *      above) by completing the following:
 *
 *      1) instantiate a new Queue
 *      2) demonstrate the use of EVERY method in the Queue class - there are 7
 */
public class Exercise_01{
	public static void main(String[] args) {
		
		Queue<Integer> q = new PriorityQueue<>();
		
		q.add(7);
		q.add(6);
		q.add(5);
		q.add(4);
		q.add(3);
		q.add(2);
		q.add(1);
		q.offer(77);
		System.out.println(q.remove());
		System.out.println(q.poll());
		System.out.println(q.element());
		System.out.println(q.peek());
		System.out.println(q.size());
		
	}
}