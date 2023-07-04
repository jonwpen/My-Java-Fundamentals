package labs_examples.datastructures.hashmap.labs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;
import java.util.Map.Entry;

/**
 *      HashMaps Exercise_02
 *
 *      Create a new class that does the following:
 *
 *      1) create a LinkedList
 *      2) create a Stack
 *      3) create a Queue
 *      4) create a HashMap
 *
 *      Then, add millisecond timers before and after each data structure above and print out
 *      how long it takes for each to complete EACH the following tasks, and the total time for
 *      each data structure:
 *
 *      1) add 100 elements
 *      2) update 100 elements
 *      3) search for 100 elements
 *      4) delete 100 elements
 */
public class Exercise_03{
	public static void main(String[] args) {
		
		LinkedList<String> linkedList = new LinkedList<>();
		String string = "s";
		
		//add
		long start = System.currentTimeMillis();
		for(int i = 1; i<=100; i++) {
			string += "s";
			linkedList.add("String"+string);
		}
		long stop = System.currentTimeMillis();
		long elapsedTime1 = stop - start;
		System.out.println(elapsedTime1);
		
		//update
		string = "s";
		start = System.currentTimeMillis();
		for(int i = 0; i<linkedList.size(); i++) {
			string += "s";
			linkedList.set(i, "update"+string);
		}
		stop = System.currentTimeMillis();
		long elapsedTime2 = stop - start;
		System.out.println(elapsedTime2);
		
		//search
		start = System.currentTimeMillis();
		for(int i = 0; i<linkedList.size(); i++) {
			linkedList.contains(linkedList.get(i));
		}
		stop = System.currentTimeMillis();
		long elapsedTime3 = stop - start;
		System.out.println(elapsedTime3);
		
		//delete
		start = System.currentTimeMillis();
		for(int i = 0; i<linkedList.size(); i++) {
			linkedList.remove(i);
		}
		stop = System.currentTimeMillis();
		long elapsedTime4 = stop - start;
		System.out.println(elapsedTime4);
		long total1 = elapsedTime1+elapsedTime2+elapsedTime3+elapsedTime4;
		System.out.println("Total LinkedList time: "+total1);
		
		//------------------------------------
		
		Stack<String> stack = new Stack<>();
		
		//add
		string = "s";
		start = System.currentTimeMillis();
		for(int i = 1; i <= 100; i++) {
			string += "s";
			stack.push("String"+string);
		}
		stop = System.currentTimeMillis();
		long elapsedTime5 = stop - start;
		System.out.println(elapsedTime5);
		
		//update
		string = "t";
		start = System.currentTimeMillis();
		for(int i = 0; i <stack.size(); i++) {
			string += "t";
			stack.set(i, "String"+string);
		}
		stop = System.currentTimeMillis();
		long elapsedTime6 = stop - start;
		System.out.println(elapsedTime6);
		
		//search
		start = System.currentTimeMillis();
		for(int i = 0; i <stack.size(); i++) {
			stack.contains(stack.get(i));
		}
		stop = System.currentTimeMillis();
		long elapsedTime7 = stop - start;
		System.out.println(elapsedTime7);
		
		//delete
		string = "t";
		start = System.currentTimeMillis();
		for(int i = 0; i <stack.size(); i++) {
			string += "t";
			stack.pop();
		}
		stop = System.currentTimeMillis();
		long elapsedTime8 = stop - start;
		System.out.println(elapsedTime8);
		
		long total2 = elapsedTime5+elapsedTime6+elapsedTime7+elapsedTime8;
		System.out.println("Total Stack time: "+total2);
		
		//------------------------------------
		
		PriorityQueue<String> queue = new PriorityQueue<>();
		
		//add
		string = "s";
		start = System.currentTimeMillis();
		for(int i = 1; i <= 100; i++) {
			string += "s";
			queue.offer("String"+string);
		}
		stop = System.currentTimeMillis();
		long elapsedTime9 = stop - start;
		System.out.println(elapsedTime9);
		
		//update
		string = "t";
		start = System.currentTimeMillis();
		for(int i = 0; i <stack.size(); i++) {
			string += "t";
			queue.poll();
			queue.offer("String"+string);
		}
		stop = System.currentTimeMillis();
		long elapsedTime10 = stop - start;
		System.out.println(elapsedTime10);
		
		//search
		start = System.currentTimeMillis();
		for(int i = 0; i <queue.size(); i++) {
			queue.contains(queue.peek());
		}
		stop = System.currentTimeMillis();
		long elapsedTime11 = stop - start;
		System.out.println(elapsedTime11);
		
		//delete
		start = System.currentTimeMillis();
		for(int i = 0; i <stack.size(); i++) {
			queue.poll();
		}
		stop = System.currentTimeMillis();
		long elapsedTime12 = stop - start;
		System.out.println(elapsedTime12);
		
		long total3 = elapsedTime9+elapsedTime10+elapsedTime11+elapsedTime12;
		System.out.println("Total Queue time: "+total3);
		
		//------------------------------------
		
		HashMap<String,Integer> hashMap = new HashMap<>();
		
		//add
		string = "s";
		start = System.currentTimeMillis();
		for(int i = 1; i <= 100; i++) {
			string += "s";
			hashMap.put(string, i);
		}
		stop = System.currentTimeMillis();
		long elapsedTime13 = stop - start;
		System.out.println(elapsedTime13);
		
		//update
		string = "t";
		start = System.currentTimeMillis();
		for(int i = 0; i <hashMap.size(); i++) {
			string += "t";
			hashMap.replace(string, i+1);
		}
		stop = System.currentTimeMillis();
		long elapsedTime14 = stop - start;
		System.out.println(elapsedTime14);
		
		//search
		start = System.currentTimeMillis();
		for(int i = 0; i <hashMap.size(); i++) {
			hashMap.get(i);
		}
		stop = System.currentTimeMillis();
		long elapsedTime15 = stop - start;
		System.out.println(elapsedTime15);
		
		//delete
		start = System.currentTimeMillis();
		Set<?> entries = hashMap.entrySet();
		java.util.Iterator<?> iterator = entries.iterator();
        while(iterator.hasNext()) {
        	Map.Entry<?,?> data = (Entry<?,?>) iterator.next();
            iterator.remove();
        }
		stop = System.currentTimeMillis();
		long elapsedTime16 = stop - start;
		System.out.println(elapsedTime16);
		
		long total4 = elapsedTime13+elapsedTime14+elapsedTime15+elapsedTime16;
		System.out.println("Total HashMap time: "+total4);
		
	}
}