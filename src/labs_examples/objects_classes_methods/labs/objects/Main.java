package labs_examples.objects_classes_methods.labs.objects;

public class Main {

	public static void main(String[] args) {
		FlightDeck deck = new FlightDeck(2,3);
		Wings wings = new Wings(211.0, 4);
		Seats seats = new Seats(524);
		Crew crew = new Crew(12);
		
		Airplane plane = new Airplane(deck, wings, seats, crew);
		
		//setters
		plane.wings.setSpan(211.0);
		plane.setManufacturer("Boeing");
		plane.setModel("747");
		plane.setFuelCapacity(63500.0);
		plane.setCurrentFuelLevel(30000.0);
		
		System.out.println("I pilot a "+plane.getManufacturer()+" "+plane.getModel()+". It has a wingspan of "+plane.wings.getSpan()+" ft.");
		System.out.println("The wings hold "+plane.wings.getEngines()+" engines.");
		System.out.println("It has a fuel capacity of "+plane.getFuelCapacity()+" gallons. The current fuel level is "+plane.getCurrentFuelLevel()
		+"\nThere are "+plane.flightDeck.getPilots()+" pilots and "+plane.flightDeck.getSeats()+" seats on the flight deck."+"\nThere are "+plane.crew.getFlightAttendants()+
		" flight attendants on board and there are "+plane.seat.getTotalSeats()+" seats for passengers.");

	}

}
class Airplane{
	private String manufacturer;
	private String model;
	private double fuelCapacity;
	private double currentFuelLevel;
	FlightDeck flightDeck;
	Wings wings;
	Seats seat;
	Crew crew;
	
	Airplane(FlightDeck flightDeck, Wings wings, Seats seat, Crew crew){
		this.flightDeck = flightDeck;
		this.wings = wings;
		this.seat = seat;
		this.crew = crew;
		
		
	}
	

	public String getManufacturer() {
		return manufacturer;
	}


	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}


	public String getModel() {
		return model;
	}


	public void setModel(String model) {
		this.model = model;
	}


	public double getFuelCapacity() {
		return fuelCapacity;
	}


	public void setFuelCapacity(double fuelCapacity) {
		this.fuelCapacity = fuelCapacity;
	}


	public double getCurrentFuelLevel() {
		return currentFuelLevel;
	}


	public void setCurrentFuelLevel(double currentFuelLevel) {
		this.currentFuelLevel = currentFuelLevel;
	}


	@Override
	public String toString() {
		return "Airplane [manufacturer=" + manufacturer + ", model=" + model + ", fuelCapacity=" + fuelCapacity
				+ ", currentFuelLevel=" + currentFuelLevel + ", flightDeck=" + flightDeck + ", wings=" + wings
				+ ", seat=" + seat + ", crew=" + crew + "]";
	}
	
}
class FlightDeck{
	private int pilots;
	private int seats;
	
	FlightDeck(int pilots, int seats){
		this.pilots = pilots;
		this.seats = seats;
		
		
	}

	@Override
	public String toString() {
		return "FlightDeck [pilots=" + pilots + ", seats=" + seats + "]";
	}

	public int getPilots() {
		return pilots;
	}

	public void setPilots(int pilots) {
		this.pilots = pilots;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}
	
	
	
}
class Wings{
	private double span;
	private int engines;
	
	Wings(double span, int engines){
		this.span = span;
		this.engines = engines;
		
		
	}
	

	public double getSpan() {
		return span;
	}


	public void setSpan(double span) {
		this.span = span;
	}


	public int getEngines() {
		return engines;
	}


	public void setEngines(int engines) {
		this.engines = engines;
	}


	@Override
	public String toString() {
		return "Wings [span=" + span + ", engines=" + engines + "]";
	}
	
}
class Seats{
	private int totalSeats;
	
	Seats(int totalSeats){
		this.totalSeats = totalSeats;
		
	}
	

	public int getTotalSeats() {
		return totalSeats;
	}


	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}


	@Override
	public String toString() {
		return "Seats [totalSeats=" + totalSeats + "]";
	}
	
}
class Crew{
	private int flightAttendants;
	
	
	Crew(int flightAttendants){
		this.flightAttendants = flightAttendants;
		
		
	}
	


	public int getFlightAttendants() {
		return flightAttendants;
	}



	public void setFlightAttendants(int flightAttendants) {
		this.flightAttendants = flightAttendants;
	}



	@Override
	public String toString() {
		return "Crew [flightAttendants=" + flightAttendants + "]";
	}
	
}