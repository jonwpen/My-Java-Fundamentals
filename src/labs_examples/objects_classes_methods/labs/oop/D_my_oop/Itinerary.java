package labs_examples.objects_classes_methods.labs.oop.D_my_oop;

import java.util.ArrayList; 

public class Itinerary {

	String tripName;
	private int planeTicket = 1000;
	ArrayList<String> itinerary = new ArrayList<String>();
	ArrayList<Integer> itineraryCost = new ArrayList<Integer>();
	
public Itinerary() {
		
	}
	//addItem method.
public void addItem(City a, char[] b) {
	if(itinerary.isEmpty()) {
			itinerary.add("Roundtrip flight");
			itineraryCost.add(planeTicket);
		}
			int x = b[1]-'0'; //subtract char 0 to get the numeric value instead of ASCII value
			char[] c = {'a','b','c','d','e'};
			for(int i=0;i<c.length;i++) {
			if(b[0]==c[i]) {
			itinerary.add(a.cityDetails.get(i).get(x-1)); 		
			itineraryCost.add(a.cityDetailsPrices.get(i).get(x-1));
			}
		}
	}
	
public void printInvoice(Traveler a) {
	System.out.println("_________________________________________________________");
	System.out.format("%58s",   tripName+"\n");
	System.out.println("\nBilled to: "+a.name+"\n");
	System.out.format("%-10s %22s %23s", "Description","Quantity","Amount\n");
	System.out.println("_________________________________________________________");
	for(int i=0;i<itinerary.size();i++) {
		System.out.format("%-31s %1s %23s",itinerary.get(i),"x"+a.budget.getGroupSize(),"$"+itineraryCost.get(i)*a.budget.getGroupSize()+"\n");
		System.out.println("_________________________________________________________");
	}
	System.out.format("%-10s %47s", "Total","$"+a.budget.calculateTotal(a)+"\n");
	System.out.println();
	}

public void printCurrentItinerary() {
	System.out.println("\nYour current itinerary:");
		for(int i=0;i<itinerary.size();i++) {
		System.out.format("%-31s %26s", itinerary.get(i)+" -", "$"+itineraryCost.get(i)+"\n");
		}
	}
}