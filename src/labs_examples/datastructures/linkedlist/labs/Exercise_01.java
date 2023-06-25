package labs_examples.datastructures.linkedlist.labs;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 *      LinkedLists - Exercise_01
 *
 *      Demonstrate your mastery of Java's built-in LinkedList class by demonstrating the following:
 *
 *      1) create a LinkedList (from Java's libraries)
 *      2) add()
 *      3) addAll()
 *      4) addFirst()
 *      5) addLast()
 *      6) getFirst()
 *      7) getLast()
 *      8) get()
 *      9) set()
 *      10) push()
 *      11) pop()
 *      12) remove()
 *      13) contains()
 *      14) listIterator()
 *      15) clear()
 */
public class Exercise_01{
	public static void main(String[] args) {
		//1
		LinkedList<String> anime = new LinkedList<>();
		//2
		anime.add("Penguin Highway");
		anime.add("Your Name");
		anime.add("Spirited Away");
		anime.add("Space Dandy");
		anime.add("Land of the Lustrous");
		anime.add("Ghost in the Shell");
		anime.add("Eureka Seven");
		anime.add("FLCL");
		
		LinkedList<String> newAnime = new LinkedList<>();
		newAnime.add("Vinland Saga");
		newAnime.add("Arise Ghost in the Shell");
		newAnime.add("Violet Evergarden");
		//3
		anime.addAll(newAnime);
		System.out.println(anime);
		//4
		anime.addFirst("Berserk");
		//5
		anime.addLast("Cowboy Bebop");
		System.out.println(anime);
		//6, 7
		System.out.println(anime.getFirst()+" "+anime.getLast());
		//8
		System.out.println(anime.get(2));
		//9
		anime.set(2, "MEMEME!");
		System.out.println(anime.get(2));
		//10
		anime.push("Death Note");
		//11
		System.out.println("Pop: "+anime.pop());
		//12
		anime.remove(2);
		//13
		if(anime.contains("FLCL")) {
			System.out.println("Fooly Cooly");
		}
		//14
		ListIterator<String> iterator = anime.listIterator();
		int x = 0;
		while(iterator.hasNext()) {
			x++;
			String s = iterator.next();
			System.out.println(x+" - "+s);
		}
		//15
		anime.clear();
		anime.add("List is empty");
		System.out.println("anime LinkedList: "+anime);
		
		
	}
}