package labs_examples.objects_classes_methods.labs.oop.D_my_oop;

import java.util.ArrayList;

public class City implements Location{

	String description;
	String name;
	
	//2D lists
	ArrayList<ArrayList<String>> cityDetails = new ArrayList<ArrayList<String>>(); 
	ArrayList<ArrayList<Integer>> cityDetailsPrices = new ArrayList<ArrayList<Integer>>();
		
	ArrayList<String> hotelNames = new ArrayList<String>(); 
	ArrayList<Integer> hotelCost = new ArrayList<Integer>();
	
	ArrayList<String> restaurantNames = new ArrayList<String>();
	ArrayList<Integer> restaurantCost = new ArrayList<Integer>();

	ArrayList<String> activities = new ArrayList<String>();
	ArrayList<Integer> avtivityCost = new ArrayList<Integer>();

	ArrayList<String> TravelToCity = new ArrayList<String>();
	ArrayList<Integer> travelCost = new ArrayList<Integer>();

	ArrayList<String> localTransportation = new ArrayList<String>();
	ArrayList<Integer> localTransportCost = new ArrayList<Integer>();
	
	public City(String name) {
		this.name=name;
				
		this.cityDetails.add(hotelNames);	
		this.cityDetails.add(restaurantNames);
		this.cityDetails.add(activities);
		this.cityDetails.add(TravelToCity);
		this.cityDetails.add(localTransportation);
		
		this.cityDetailsPrices.add(hotelCost);
		this.cityDetailsPrices.add(restaurantCost);
		this.cityDetailsPrices.add(avtivityCost);
		this.cityDetailsPrices.add(travelCost);
		this.cityDetailsPrices.add(localTransportCost);
	}

	@Override
	public void LocationDetailsToString() {
	}
}