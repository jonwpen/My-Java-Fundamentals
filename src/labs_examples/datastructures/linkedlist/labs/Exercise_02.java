package labs_examples.datastructures.linkedlist.labs;

import java.util.ArrayList; 
import java.util.List;

/**
 *      LinkedLists - Exercise_02
 *
 *      Write your own custom LinkedList class. Although it can mimic the CustomLinkedList
 *      class we used here, it must be entirely unique. 
 *      
 *      Please also add at least two additional helper methods that you think could be useful. Refer to Java's built-in
 *      LinkedList class for inspiration. 
 *      
 *      Your new LinkedList class should ONLY allow users
 *      to add and remove elements from the front of the list AND the end of the list.
 *      
 *      Also, instead of using the index in the get() and remove() methods, these methods should
 *      get() and remove() based by the Node's value, not it's index.
 */
public class Exercise_02{
	
	public static void main(String[] args) {
		//All custom LinkedList methods have been tested using Integers, Strings, and Car objects.
		Ex02CustomLinkedList<Car> list = new Ex02CustomLinkedList<>();
		
		Car car1 = new Car(2019, "Hyundai", "Elantra");
		Car car2 = new Car(2010, "Hyundai", "Santa Fe");
		Car car3 = new Car(2024, "Hyundai", "N Vision 74");
		Car car4 = new Car(2014, "Porsche", "919 Hybrid");
		Car car5 = new Car(2011, "Audi", "R18");
		Car car6 = new Car(2016, "Toyota", "TS050");
		Car car7 = new Car(1969, "Ford", "GT40");
		
		list.addEnd(car1);
		list.addEnd(car2);
		list.addEnd(car3);
		list.addEnd(car4);
		list.addEnd(car5);
		list.addEnd(car4);
		list.addEnd(car6);
		list.addFront(car7);
		list.addEnd(car4);
		System.out.println(list.toString());
		
		list.removeFront(car7);
		list.removeEnd(car6);
		System.out.println(list.toString());
		System.out.println(list.getSize());
		System.out.println(list.get(car5));
		System.out.println("\n"+list.toString());
		System.out.println(list.getSize());
		System.out.println("occurrences "+list.countOccurrences(car4));
		System.out.println(list.toString());
		
		List<Node<Car>> carArray = list.toArray();
		for(int i = 0;i<carArray.size();i++) {
			System.out.println(carArray.get(i).data);  
		}
	}
}

class Node<T> {
	    T data;
	    Node<T> next;

	    public Node(T data) {
	        this.data = data;
	        this.next = null;
	    }
	    public Node(T data, Node<T> next) {
	        this.data = data;
	        this.next = next;
	    }
	}

class Ex02CustomLinkedList<T> {
	
	private Node<T> head;
	private int size;
	
	public Ex02CustomLinkedList() {
		head = null;
		size = 0;
	}
	public void addFront(T data) {
		if(head == null) {
			head = new Node<T> (data);
		}
		else {
			Node<T> node = new Node<T>(data);
			node.next = head;
			head = node;
		}
		size++;
	}
	public void addEnd(T data) {
		if(head == null) {
			head = new Node<T> (data);
		}
		else {
			Node<T> iterator = head;
			while(iterator.next != null) {
				iterator = iterator.next;
			}
			 iterator.next = new Node<T>(data);
		}
		size++;
	}
	//Remove front element based on value, not index
	public void removeFront(T data) {
		if(head == null) {
			return;
		}
		if(head.data.equals(data)){
			head = head.next;
			size--;
		}
		else {
			System.out.println("Cannot remove element. Element "+data+" does not exist at the front.");
		}
	}
	//Remove end element and based on value, not index
	public void removeEnd(T data) {
		if(head == null) {
			return;
		}
		else {
			Node<T> iterator = head;
			Node<T> previous = null;
			while(iterator.next != null) {
				previous = iterator;
				iterator = iterator.next;
			}
			if(iterator.next == null && iterator.data != data) {
				System.out.println("Cannot remove element. Element "+data+" does not exist at the end.");
			}
			else if(iterator.next == null && iterator.data == data) {
				previous.next = null;
				size--;
			}
		}
	}
	//get element based on Node's value, not index
	public T get(T data) {
	    if (head == null) {
	        return null;
	    }
	    Node<T> iterator = head;
	    while (iterator != null) {
	        if (iterator.data.equals(data)) {
	            return iterator.data;
	        }
	        iterator = iterator.next;
	    }
	    System.out.println("Element does not exist.");
	    return null;
	}
	public int getSize() {
		return size;
	}
	@Override
	public String toString() {
		String list = "";
		Node<T> iterator = head;
		while(iterator != null) {
			list += iterator.data + "\n";
			iterator = iterator.next;
		}
		return list;
	}
	//Additional helper method 1
	public int countOccurrences(T data) {
		int num = 0;
		if(head == null) {
			return num;
		}
		Node<T> iterator = head;
		while(iterator.next != null) {
			iterator = iterator.next;
			if(iterator.data.equals(data)) {
				num++;
			}
		}
		return num;
	}
	//Additional helper method 2
	public List<Node<T>> toArray() {
		List<Node<T>> nodeList = new ArrayList<>();
		Node<T> iterator = head;
		while(iterator != null) {
			nodeList.add(iterator);
			iterator = iterator.next;
		}
		return nodeList;
	}
}

class Car{
	int year;
	String make;
	String model;
	
	public Car(int y, String make, String model) {
		this.year = y;
		this.make = make;
		this.model = model;
	}
	@Override
	public String toString() {
		return "Car [year=" + year + ", make=" + make + ", model=" + model + "]";
	}
}