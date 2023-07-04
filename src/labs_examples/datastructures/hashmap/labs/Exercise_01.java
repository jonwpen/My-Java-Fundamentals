package labs_examples.datastructures.hashmap.labs;

import java.util.HashMap;

/**
 *  HashMaps Exercise_01
 *
 *  Demonstrate your mastery of using Java's built-in HashMap class below.
 *
 *  Using a HashMap demonstrate the use of the following methods:
 *
 *  put()
 *  get()
 *  putAll()
 *  size()
 *  contains()
 *  keySet()
 *  entrySet()
 *  putIfAbsent()
 *  remove()
 *  replace()
 *  forEach()
 *  clear()
 *
 */
public class Exercise_01{
	public static void main(String[] args) {
		
		HashMap<String, String> filmDirectors = new HashMap<>();
		HashMap<String, String> filmDirectors2 = new HashMap<>();
		
		filmDirectors2.put("Let The Right One In", "Tomas Alfredson");
		filmDirectors2.put("The Girl With The Dragon Tattoo", "David Fincher");
		filmDirectors2.put("Tinker Tailor Soldier Spy", "Tomas Alfredson");
		
		filmDirectors.put("Dune", "Denis Villeneuve");
		filmDirectors.put("Dune Part 2", "Denis Villeneuve");
		filmDirectors.put("Incendies", "Denis Villeneuve");
		filmDirectors.put("Burn After Reading", "Coen Brothers");
		filmDirectors.put("The Man From U.N.C.L.E.", "Guy Ritchie");
		filmDirectors.put("Suspiria", "Luca Guadagnino");
		filmDirectors.put("Ex Machina", "Alan Smithee");
		
		System.out.println(filmDirectors.get("Dune"));
		System.out.println(filmDirectors.size());
		System.out.println(filmDirectors.keySet());
		System.out.println(filmDirectors.entrySet());
		filmDirectors.remove("Suspiria");
		filmDirectors.putAll(filmDirectors2);
		System.out.println(filmDirectors.keySet());
		System.out.println(filmDirectors.containsValue("David Fincher"));
		filmDirectors.putIfAbsent("Gangs of New York", "Martin Scorcese");
		filmDirectors.replace("Ex Machina", "Alex Garland");
		System.out.println("\n"+"Iterate over map with forEach() and lambdas:"+"\n");
		filmDirectors.forEach((k,v) -> System.out.println(k+" - "+v));
		
		filmDirectors.clear();
		System.out.println(filmDirectors.size());
		
	}
}