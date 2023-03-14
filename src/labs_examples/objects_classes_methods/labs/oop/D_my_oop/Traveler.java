package labs_examples.objects_classes_methods.labs.oop.D_my_oop;

public class Traveler extends Person{

	Itinerary itinerary;
	Budget budget;
	
	public Traveler(String name, Itinerary itinerary, Budget budget) {
		
		super(name);
		
		this.itinerary=itinerary;
		this.budget=budget;
		
	}
}



