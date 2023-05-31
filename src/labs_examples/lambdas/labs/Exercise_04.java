package labs_examples.lambdas.labs;

import java.io.File;
import java.io.IOException; 
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Lambdas Exercise 4:
 *
 *      Stream API Labs
 *
 *      1) Demonstrate the use of the range function to print out the numbers 1 through 15 (inclusive)
 *      2) Demonstrate the use of the sum function to determine the range of a set of numbers.
 *      3) Demonstrate the use of the map() function to alter each int in a List of Integers, then use the sum function
 *          to get the sum of the modified list
 *      4) Demonstrate the filter function by filtering out all Integers that are less than 10 - then use the average
 *          function to average the remaining numbers, assign this result to an int variable.
 *      5) Demonstrate the reduce() function to determine the sum of a list of Integers
 *      6) Demonstrate how to Stream a text file and print out each line
 *      7) Demonstrate how to Stream the stream_text_lab.csv file in this package. Split the lines into String arrays,
 *          then print out the element at the 1 index for each array.
 *      8) Demonstrate how to Stream the stream_text_lab.csv file in this package. Split the lines into String arrays,
 *          then print out the sum of all elements at index 2.
 *      9) Demonstrate the anyMatch() function.
 *      10) Demonstrate the allMatch() function.
 *      11) Demonstrate the collect() terminal operation to store resulting values into a List
 *      
 */

class Exercise_04 {
	
    public static void main(String[] args) {
    	
    	//1)
    	IntStream.rangeClosed(1, 15)
    			.forEach(x -> System.out.print(x+" "));
    	
        //2)
    	System.out.println("\n"+IntStream.range(1, 5)
    			.sum());
    	
    	//3)
    	ArrayList<Integer> arrInt = new ArrayList<>();
    	arrInt.add(1);
    	arrInt.add(2);
    	arrInt.add(3);
    	arrInt.add(4);
    	arrInt.add(5);
    	arrInt.add(30);
    	arrInt.add(40);
    	arrInt.add(50);
    	arrInt.add(60);
    	arrInt.add(70);
    	System.out.println(arrInt.stream()
    			.mapToInt(x -> x-(x/2))
    			.sum());
    	
    	//4)
    	System.out.println(arrInt.stream()
    			.filter(x -> x>=10)
    			.mapToInt(x -> x)
    			.average());
    	
    	//5)
    	System.out.println(arrInt.stream()
    			.mapToInt(x -> x)
    			.reduce(0, (int a, int b) -> a+b));
    	
    	//6)
    	String textPath = "labs_examples/lambdas/labs/stream_text_lab.csv";
    	File f = new File("stream_text_lab.csv");
    	System.out.println(f.getAbsolutePath());
    	Stream<String> textFile;
		try {
			textFile = Files.lines(Paths.get(textPath));
	    	textFile.forEach(System.out::println);
	    	textFile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
    	//7)
		try {
			textFile = Files.lines(Paths.get(textPath));
	    	textFile.map(x -> x.split(",")).forEach(x -> System.out.println(x[1]));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//8)
		try {
			textFile = Files.lines(Paths.get(textPath));
			
			DoubleStream sum = textFile
					.map(x -> x.split(","))
					.mapToDouble(x -> Double.parseDouble(x[2]));
			System.out.println(sum
					.reduce(0.0, (double a, double b) -> a + b));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//9)
		Stream<Integer> strInt = Stream.of(21,32,43,54,65,76,87,98);
		boolean b = strInt.anyMatch(x -> x==54);
		System.out.println(b);
		
		//10)
		Stream<Integer> strInt2 = Stream.of(21,32,43,54,65,76,87,98);
		boolean b2 = strInt2.allMatch(x -> x<90);
		System.out.println(b2);
		
		//11)
		//Use Arrays.asList to initialize an ArrayList directly without having to add each index.
		List<String> people = Arrays.asList(
			    "Henry Cavill",
			    "Amy Adams",
			    "Michael Shannon",
			    "Diane Lane",
			    "Russell Crowe",
			    "Kevin Costner"
			);
			List<String> filteredPeople = people.stream()
			    .filter(x -> x.contains("Amy"))
			    .collect(Collectors.toList());

			filteredPeople.forEach(x -> System.out.println(x));
    }
}




























