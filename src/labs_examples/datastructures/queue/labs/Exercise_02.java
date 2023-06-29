package labs_examples.datastructures.queue.labs;

import java.util.Arrays;



/**
 *      Queues - Exercise_02
 *
 *      Write a new custom (Generic) Queue class that uses a traditional Array as the underlying data structure
 *      rather than the LinkedList as in the example we have already seen.
 *
 *      Your custom Queue class must also do the following:
 *
 *      1) throw a custom exception when trying to pop  an element from an empty Queue
 *      2) resize the Queue (the underlying array) to be twice the size when the Queue is more than 3/4 full
 *      3) resize the Queue (the underlying array) to be half the size when the Queue is more than 1/4 empty
 *      4) contain the methods peekFirst() and peekLast()
 *      5) contain a size() method
 *      6) contain a method to print out the data of all elements in the Queue
 *
 */
//This exercise matches the Stack exercise, but adding and removing now enforce FIFO architecture.
public class Exercise_02{
	public static void main(String[] args) {
		
		CustomQueue<Integer> intQueue = new CustomQueue<>();

		try {
			intQueue.remove();
		} catch (EmptyQueueException e) {
			e.printStackTrace();
		}
		System.out.println(intQueue.peekFirst());
		intQueue.add(3);
		intQueue.add(6);
		intQueue.add(9);
		intQueue.add(12);
		intQueue.add(15);
		intQueue.add(18);
		intQueue.add(21);
		intQueue.add(24);
		intQueue.add(27);
		intQueue.add(30);
		intQueue.add(33);
		intQueue.add(36);
		System.out.println(intQueue.toString());
		try {
			System.out.println(intQueue.remove());
		} catch (EmptyQueueException e) {
			e.printStackTrace();
		}
		System.out.println(intQueue.toString());
		try {
			System.out.println(intQueue.remove());
			System.out.println(intQueue.remove());
			System.out.println(intQueue.remove());
			System.out.println(intQueue.remove());
			System.out.println(intQueue.remove());
			System.out.println(intQueue.remove());
			System.out.println(intQueue.remove());
			System.out.println(intQueue.remove());
			System.out.println(intQueue.remove());
		} catch (EmptyQueueException e) {
			e.printStackTrace();
		}
		System.out.println(intQueue.toString());
	}
}
class CustomQueue<T>{
	
	private T[] data;
	private int size;
	
	@SuppressWarnings("unchecked")
	CustomQueue(){
		data = (T[]) new Object[10];
		size = 0;
	}
	
	public void add(T element) {
		if(data[0] == null) {
			data[0] = element;
			size++;
		}
		else {
			for(int i = 0; i < data.length; i++) {
				//add an element to the next null index starting from the front. Call resize()
				if(data[i] == null){
					data[i] = element;
					size++;
					break;
				}
			}
		}
		resize();
	}
	//Remove method enforces FIFO rule. Elements are added left to right. Elements are removed left to right.
	public T remove() throws EmptyQueueException{
		T element = data[0];
		//if the first element is null, throw a custom exception
		if(data[0] == null) {
			throw new EmptyQueueException(" ");
		}
		//remove the 0 index and shift elements to the left. Call resize()
		for(int i = 0;i < data.length-1;i++) {
			data[i] = data[i+1];
			}
		resize();
		size--;
		return element;
	}
	
	public int size() {
		return size;
	}
	@Override
	public String toString() {
		//iterate over the elements including null values
		StringBuilder sb = new StringBuilder();
		for(int i = 0;i<data.length;i++) {
			sb.append(data[i]).append(" ");
		}
		return sb.toString();
	}
	
	public String toStringNotNull() {
		//iterate only over elements that contain values
		StringBuilder sb = new StringBuilder();
		for(int i = 0;i<data.length;i++) {
			if(data[i] != null) {
				sb.append(data[i]).append(" ");
			}
		}
		return sb.toString();
	}
	public T peekFirst() {
		//"First" being the bottom of the Queue
		T x = null;
		for(int i = 0;i<data.length;i++){
			if(data[i] == null && size > 1) {
				x = data[i-1];
				break;
			}
			else {
				x = data[0];
			}
		}
		return x;
	}
	public T peekLast() {
		//"Last" being the bottom of the Queue
		return data[0];
	}
	public void resize() {
		//if more than 75% full, double size
		if(size >= (data.length / 4) * 3) {
			T[] newData = Arrays.copyOf(data,data.length * 2);
			data = newData;
		}
		//if less than 25% full AND overall length is greater than the initial size of 10, halve the size
		else if(size <= data.length / 4 && data.length > 10) {
			T[] newData = Arrays.copyOf(data,data.length / 2);
			data = newData;
		}
	}
}

class EmptyQueueException extends Exception{
	@Override
	public String toString() {
		return "EmptyQueueException: Cannot remove element from an empty queue.";
	}
	public EmptyQueueException(String string) {
	}
	private static final long serialVersionUID = 1L;
}
