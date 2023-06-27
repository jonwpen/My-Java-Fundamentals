package labs_examples.datastructures.stack.labs;

import java.util.Arrays;

/**
 *      Stacks - Exercise_02
 *
 *      Write a new custom (Generic) Stack class that uses a traditional Array as the underlying data structure
 *      rather than the LinkedList as in the example we have already seen.
 *
 *      Your custom Stack class must also do the following:
 *
 *      1) throw a custom exception when trying to pop an element from an empty Stack
 *      2) resize the Stack (the underlying array) to be twice the size when the Stack is more than 3/4 full
 *      3) resize the Stack (the underlying array) to be half the size when the Stack is more than 1/4 empty
 *      4) contain the methods peekFirst() and peekLast()
 *      5) contain a size() method
 *      6) contain a method to print out the data of all elements in the Stack
 *
 *      TIP: To initialize a new array of a Generic type you can use this:
 *           T[] data = (T[]) new Object[10];
 */
public class Exercise_02{
	public static void main(String[] args) {
		
		CustomStack<Integer> intStack = new CustomStack<>();

		try {
			intStack.pop();
		} catch (EmptyStackException e) {
			e.printStackTrace();
		}
		System.out.println(intStack.peekFirst());
		intStack.push(3);
		System.out.println(intStack.peekFirst());
		intStack.push(6);
		System.out.println(intStack.peekFirst());
		intStack.push(9);
		System.out.println(intStack.peekFirst());
	}
}
class CustomStack<T>{
	
	private T[] data;
	private int size;
	
	@SuppressWarnings("unchecked")
	CustomStack(){
		data = (T[]) new Object[10];
		size = 0;
	}
	
	public void push(T element) {
		if(data[0] == null) {
			data[0] = element;
			size++;
		}
		else {
			for(int i = 0; i < data.length; i++) {
				//add an element to the next null index starting from the front
				if(data[i] == null){
					data[i] = element;
					size++;
					break;
				}
			}
		}
		resize();
	}
	
	public T pop() throws EmptyStackException{
		T element = null;
		//if the first element is null, throw a custom exception
		if(data[0] == null) {
			throw new EmptyStackException(" ");
		}
			//remove the first not null index starting from the end
			for(int i = data.length-1;i > 0;i--) {
				if(data[i] != null) {
					element = data[i];
					data[i] = null;
					resize();
					break;
				}
			}
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
		//"First" being the bottom of the stack
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
		//"Last" being the bottom of the stack
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

class EmptyStackException extends Exception{
	@Override
	public String toString() {
		return "EmptyStackException: Cannot pop element from an empty stack.";
	}
	public EmptyStackException(String string) {
	}
	private static final long serialVersionUID = 1L;
}


