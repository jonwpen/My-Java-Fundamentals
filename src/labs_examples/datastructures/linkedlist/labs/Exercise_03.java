package labs_examples.datastructures.linkedlist.labs;

/**
 *      LinkedLists - Exercise_02
 *
 *      Please create your own custom doubly-LinkedList from start to finish :) You got this!
 */
public class Exercise_03{
	public static void main(String[] args) {
		
		DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
		list.add(3);
		list.add(6);
		list.add(9);
		System.out.println(list.toString());
		System.out.println(list.reverseToString());
		
		list.insertAfterIndex(7, 1);
		System.out.println(list.toString());
		list.insertAfterIndex(5, 0);
		System.out.println(list.toString());
		System.out.println(list.size());
		list.insertAfterIndex(5, 7);
		System.out.println(list.size());
		
		list.removeAtIndex(1);
		System.out.println(list.toString());
		System.out.println(list.reverseToString());
		list.add(1);
		System.out.println(list.toString());
	}
}

class Node2<T>{
	
	T data;
	Node2<T> previous;
	Node2<T> next;
	
	public Node2(T data) {
		this.data = data;
		this.previous = null;
		this.next = null;
	}
    public Node2(T data, Node2<T> previous, Node2<T> next) {
        this.data = data;
        this.next = next;
    }
}

class DoublyLinkedList<T>{
	
	private int size;
	private Node2<T> head;
	private Node2<T> tail;
	
	public DoublyLinkedList() {
		head = null;
		tail = null;
		size = 0;
	}
	//create a head, then continuously add a tail
	public void add(T data) {
		if(head == null) {
			head = new Node2<T> (data);
		}
		else {
			Node2<T> iterator = head;
			while(iterator.next != null) {
				iterator = iterator.next;
			}
			tail = new Node2<T> (data);
			tail.previous = iterator;
			iterator.next = tail;
		}
		size++;
	}
	//insert after a given index
	public void insertAfterIndex(T data, int x) {
		int counter = 0;
		
		if(x == 0 && head != null) {
			Node2<T> node = new Node2<T> (data);
			node.next = head.next;
			head.next.previous = node;
			head.next = node;
			node.previous = head;
		}
		if(head == null) {
			head = new Node2<T> (data);
		}
		if(x < 0 || x > size) {
			System.out.println("Cannot insert. Index does not exist.");
			size--;
		}
		else {
			Node2<T> iterator = head;
			while(iterator.next != null && x != counter) {
				iterator = iterator.next;
				counter++;
				if(iterator.next == null) {
					Node2<T> node = new Node2<T> (data);
					iterator.next = node;
					node.previous = iterator;
				}
				else if(counter == x) {
					Node2<T> node = new Node2<T> (data);
					iterator.next.previous = node;
					node.next = iterator.next;
					iterator.next = node;
					node.previous = iterator;
				}
			}
		}
		size++;
	}
	//remove index from front, middle, or end
	public void removeAtIndex(int x) {
		
		int counter = 0;
		if(x == 0) {
			head = head.next;
		}
		if(x == 1) {
			head.next.next.previous = head;
			head.next = head.next.next;
		}
		if(x < 0 || x > size -1) {
			System.out.println("Index does not exist.");
			size++;
		}
		else {
			Node2<T> iterator = head;
			while(iterator.next != null && x != counter) {
				iterator = iterator.next;
				counter++;
				if(counter == size -1){
					iterator.previous.next = null;
				}
				else if(counter == x - 1) {
					iterator.next = iterator.next.next;
					iterator.next.previous = iterator;
				}
			}
		}
		size--;
	}
	@Override //Use StringBuilder to improve efficiency
	public String toString() {
	    StringBuilder sb = new StringBuilder();
	    Node2<T> iterator = head;
	    while (iterator != null) {
	        sb.append(iterator.data).append(" ");
	        iterator = iterator.next;
	    }
	    return sb.toString();
	}
	//print list in reverse
	public String reverseToString() {
	    StringBuilder sb = new StringBuilder();
	    Node2<T> iterator = tail;
	    while (iterator != null) {
	        sb.append(iterator.data).append(" ");
	        iterator = iterator.previous;
	    }
	    return sb.toString();
	}
	public int size() {
		return size;
	}
}
