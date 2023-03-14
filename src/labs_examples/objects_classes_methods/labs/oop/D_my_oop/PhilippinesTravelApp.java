package labs_examples.objects_classes_methods.labs.oop.D_my_oop;


import java.util.Scanner;

//For this exercise, I've created a trip planner for traveling to the Philippines.
//The user can learn about tourist destinations, add activities to an itinerary, and generate an invoice.
public class PhilippinesTravelApp {
	
	public static void main(String[] args) {
		
		planYourTrip();
		System.out.println("Enjoy your trip!");
	}
	public static void planYourTrip() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter your name:");
		String travelerName = sc.nextLine();
		Itinerary it = new Itinerary();
		Budget budget = new Budget();
		PhilippinesCities  pC = new PhilippinesCities();
		Traveler t = new Traveler(travelerName, it, budget);
		boolean keepAddingActivities = true;
		boolean keepPlanning = true;
		
		System.out.println("Enter the total number of people going on this trip:");
		t.budget.setGroupSize(sc.nextInt());
		
		System.out.println("Enter a name for this trip (Visiting Family, Business Trip, etc...):");
		sc.nextLine();
		it.tripName = sc.nextLine();
	
		System.out.println("Let's plan your vacation. Select a city to explore:");
		
		//Main loop where user makes selections for trip.
		while(keepPlanning) {
			pC.cityNamesToString();
			int x=sc.nextInt();
			City cityPlaceholder; 
			
			if(x==8) { //<--If user says"done planning", exit the planYourTrip method.
				it.printInvoice(t);
			return;
			}
			else
				//Temp city equals the currently selected city.
				cityPlaceholder = pC.arr[x-1];
				sc.nextLine(); 
				while(keepAddingActivities) {
				//Print city details of the city the user selected.
				pC.LocationDetailsToString(pC.arr[x-1]);
			
				String y = sc.nextLine(); 
				if(y.equals("f")) {
					break;
				}
				else {
					char[] z = y.toCharArray();
					it.addItem(cityPlaceholder, z);
					it.printCurrentItinerary();
				}
			
				System.out.println("\nAdd another selection?\n(y)\n(n)");
				if(sc.nextLine().equals("y")) {
				continue;
				}
				else {
				keepAddingActivities = false;
				break;
				}
			}
			//repeat the process.
			System.out.println("Do you want to add another destination to this trip?\n(y)\n(n)");
			if(sc.nextLine().equals("y")) {
				keepAddingActivities=true;
				continue;
				}
				else {
				keepPlanning = false;
				break;
				}
		}		
		it.printInvoice(t);
	}
}