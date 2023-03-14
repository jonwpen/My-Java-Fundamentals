package labs_examples.objects_classes_methods.labs.oop.D_my_oop;

import java.util.ArrayList;
import java.util.Arrays;

public class PhilippinesCities{

	City ElNido = new City("El Nido");   
	City Cebu = new City("Cebu");
	City Banaue = new City("Banaue");
	City Manila = new City("Manila");
	City Siargao = new City("Siargao");
	City Davao = new City("Davao");
	City Coron = new City("Coron");
	City[] arr = {ElNido,Cebu,Banaue,Manila,Siargao,Davao,Coron};
	
	public PhilippinesCities() {
		
		ElNido.hotelNames.add("Lime Resort");
		ElNido.hotelNames.add("Cuna Hotel");
		ElNido.hotelNames.add("Lagun Hotel Hotel");
		ElNido.hotelCost.add(69);
		ElNido.hotelCost.add(64);
		ElNido.hotelCost.add(122);
		
		ElNido.restaurantNames.add("Bella Vita El Nido");
		ElNido.restaurantNames.add("Big Bad Thai");
		ElNido.restaurantNames.add("Nesting Table");
		ElNido.restaurantCost.add(20); 
		ElNido.restaurantCost.add(12);
		ElNido.restaurantCost.add(8);
		
		ElNido.activities.add("3 Day Shore Excursion");
		ElNido.activities.add("Island Hopping Tour");
		ElNido.activities.add("Underground River Tour");
		ElNido.avtivityCost.add(355);
		ElNido.avtivityCost.add(32);
		ElNido.avtivityCost.add(282);
		
		ElNido.TravelToCity.add("Fly to Puerto Princessa");
		ElNido.TravelToCity.add("Fly to El Nido");
		ElNido.travelCost.add(62);
		ElNido.travelCost.add(121);
		
		ElNido.localTransportation.add("Shuttle");
		ElNido.localTransportation.add("Kayak");
		ElNido.localTransportation.add("Tricycle");
		ElNido.localTransportCost.add(18);
		ElNido.localTransportCost.add(10);
		ElNido.localTransportCost.add(7);
		
		ElNido.description = "Located in the northern part of Palawan island, El Nido\n"
				           + "is a paradise for nature lovers and beach-goers alike.\n"
				           + "With its crystal-clear waters, towering limestone cliffs,\n"
				           + "and stunning coral reefs, El Nido is a must-visit\n"
				           + "destination for anyone traveling to the Philippines.\n"
				           + "Visitors can enjoy snorkeling, diving, island hopping,\n"
				           + "and relaxing on the beaches.";
		
		Cebu.hotelNames.add("Sheraton Resort");
		Cebu.hotelNames.add("Savoy Hotel");
		Cebu.hotelNames.add("Montebello Villa");
		Cebu.hotelCost.add(240);
		Cebu.hotelCost.add(164);
		Cebu.hotelCost.add(117);
		
		Cebu.restaurantNames.add("Yakski Barbecue");
		Cebu.restaurantNames.add("Pig & Palm");
		Cebu.restaurantNames.add("Shawarma Gourmet");
		Cebu.restaurantCost.add(10);
		Cebu.restaurantCost.add(14);
		Cebu.restaurantCost.add(20);
		
		Cebu.activities.add("Chocolate Hills Tour");
		Cebu.activities.add("Historical City Tour");
		Cebu.activities.add("Kawasan Canyoneering");
		Cebu.avtivityCost.add(198);
		Cebu.avtivityCost.add(133);
		Cebu.avtivityCost.add(185);
		
		Cebu.TravelToCity.add("Fly to Mactan");
		Cebu.travelCost.add(40);
		
		Cebu.localTransportation.add("Private Car");
		Cebu.localTransportation.add("Tricycle");
		Cebu.localTransportation.add("Ferry");
		Cebu.localTransportCost.add(150);
		Cebu.localTransportCost.add(2);
		Cebu.localTransportCost.add(200);
		
		Cebu.description =   "The island of Cebu is known for its rich history,\n"
				           + "beautiful beaches, and vibrant city life. Visitors can\n"
				           + "explore the Spanish colonial architecture of Cebu City,\n"
				           + "enjoy the lively nightlife, or head to the beach for some\n"
				           + "sun and relaxation. Cebu is also home to some of the best\n"
				           + "diving spots in the Philippines, with beautiful coral\n"
				           + "reefs and an abundance of marine life.";
		
		Banaue.hotelNames.add("Batad View Inn");
		Banaue.hotelNames.add("Banaue Hotel");
		Banaue.hotelNames.add("Hillside Inn");
		Banaue.hotelCost.add(27);
		Banaue.hotelCost.add(65);
		Banaue.hotelCost.add(56);
		
		Banaue.restaurantNames.add("Le Bistro");
		Banaue.restaurantNames.add("Hagabi");
		Banaue.restaurantNames.add("Banaue-View Cafe");
		Banaue.restaurantCost.add(13);
		Banaue.restaurantCost.add(8);
		Banaue.restaurantCost.add(5);
		
		Banaue.activities.add("Rice Terrace Adventure");
		Banaue.activities.add("3 Day Trekking Tour");
		Banaue.activities.add("Mt Pulag Private Night Tour");
		Banaue.avtivityCost.add(300);
		Banaue.avtivityCost.add(750);
		Banaue.avtivityCost.add(850);
		
		Banaue.TravelToCity.add("Bus ride");
		Banaue.TravelToCity.add("Fly to Cauayan");
		Banaue.travelCost.add(16);
		Banaue.travelCost.add(50);
		
		Banaue.localTransportation.add("Jeepney");
		Banaue.localTransportation.add("Private Car");
		Banaue.localTransportation.add("Shuttle");
		Banaue.localTransportCost.add(1);
		Banaue.localTransportCost.add(150);
		Banaue.localTransportCost.add(18);
		
		Banaue.description = "Located in the northern part of Luzon island, Banaue is\n"
				           + "famous for its stunning rice terraces, which have been\n"
				           + "cultivated by the Ifugao people for over 2,000 years. The\n"
				           + "terraces are a UNESCO World Heritage Site and a testament\n"
				           + "to the ingenuity and skill of the Ifugao people. Visitors\n"
				           + "can walk through the terraces, learn about the local\n"
				           + "culture, and enjoy the breathtaking scenery.";
		
		Manila.hotelNames.add("Guijo Suites");
		Manila.hotelNames.add("Belmont Hotel");
		Manila.hotelNames.add("Okada Manila");
		Manila.hotelCost.add(30);
		Manila.hotelCost.add(204);
		Manila.hotelCost.add(709);
		
		Manila.restaurantNames.add("Cafe Ilang-Ilang");
		Manila.restaurantNames.add("End Bee Tin");
		Manila.restaurantNames.add("Le Bar");
		Manila.restaurantCost.add(15);
		Manila.restaurantCost.add(12);
		Manila.restaurantCost.add(24);
		
		Manila.activities.add("Manila Ocean Park");
		Manila.activities.add("Mall of Asia");
		Manila.activities.add("Island Hop + Snorkelling");
		Manila.avtivityCost.add(18);
		Manila.avtivityCost.add(40);
		Manila.avtivityCost.add(180);
		
		//Manila.TravelToCity.add("(flight included)");
		//Manila.travelCost.add(0);
		
		Manila.localTransportation.add("Private Car");
		Manila.localTransportation.add("Shuttle");
		Manila.localTransportation.add("Ferry");
		Manila.localTransportCost.add(150);
		Manila.localTransportCost.add(18);
		Manila.localTransportCost.add(200);
		
		Manila.description = "As the capital city of the Philippines, Manila is a\n"
				           + "bustling metropolis that offers a mix of history, culture,\n"
				           + "and modernity. Visitors can explore the colonial\n"
				           + "architecture of the old city, visit museums and art\n"
				           + "galleries, or enjoy the vibrant nightlife and shopping\n"
				           + "scene. Manila is also known for its delicious street food\n"
				           + "and diverse cuisine.";
		
		Siargao.hotelNames.add("Isla Cabana");
		Siargao.hotelNames.add("Puyo Suites");
		Siargao.hotelNames.add("Siargao Inn");
		Siargao.hotelCost.add(170);
		Siargao.hotelCost.add(25);
		Siargao.hotelCost.add(76);
		
		Siargao.restaurantNames.add("Bravo Restaurant");
		Siargao.restaurantNames.add("Sushi Nori");
		Siargao.restaurantNames.add("Mad Monkey");
		Siargao.restaurantCost.add(12);
		Siargao.restaurantCost.add(8);
		Siargao.restaurantCost.add(10);
		
		Siargao.activities.add("Hagukan Cave ride");
		Siargao.activities.add("Jellyfish Sanctuary 1-Day");
		Siargao.activities.add("Sugba Lagoon Day Trip");
		Siargao.avtivityCost.add(20);
		Siargao.avtivityCost.add(85);
		Siargao.avtivityCost.add(119);

		
		Siargao.TravelToCity.add("Fly to Sayak");
		Siargao.TravelToCity.add("Fly to Surigao");
		Siargao.travelCost.add(43);
		Siargao.travelCost.add(40);
		
		Siargao.localTransportation.add("Motorcycle");
		Siargao.localTransportation.add("Jeepney");
		Siargao.localTransportation.add("Private Car");
		Siargao.localTransportCost.add(14);
		Siargao.localTransportCost.add(1);
		Siargao.localTransportCost.add(150);
		
		Siargao.description= "Siargao is a small island located in the east of Mindanao\n"
				           + "and has become known as the surfing capital of the\n"
				           + "Philippines. With its world-class surf breaks and\n"
				           + "laid-back island vibe, Siargao is a must-visit\n"
				           + "destination for surfers and beach lovers. Visitors can\n"
				           + "also explore the island's beaches, lagoons, and rock pools.\n";
		
		Davao.hotelNames.add("Seda Abreeza");
		Davao.hotelNames.add("Club Samal");
		Davao.hotelNames.add("Acacia Hotel");
		Davao.hotelCost.add(182);
		Davao.hotelCost.add(116);
		Davao.hotelCost.add(140);
		
		Davao.restaurantNames.add("Siam Lounge");
		Davao.restaurantNames.add("Madayaw Cafe");
		Davao.restaurantNames.add("Yellow Fin");
		Davao.restaurantCost.add(26);
		Davao.restaurantCost.add(20);
		Davao.restaurantCost.add(13);
		
		Davao.activities.add("Abreeza Mall");
		Davao.activities.add("Roxas Avenue Night Market");
		Davao.activities.add("Mount Apo Hike");
		Davao.avtivityCost.add(40);
		Davao.avtivityCost.add(10);
		Davao.avtivityCost.add(40);
		
		Davao.TravelToCity.add("Fly to Davao");
		Davao.travelCost.add(60);
		
		Davao.localTransportation.add("Bus");
		Davao.localTransportation.add("Jeepney");
		Davao.localTransportation.add("Tricycle");
		Davao.localTransportCost.add(10);
		Davao.localTransportCost.add(1);
		Davao.localTransportCost.add(7);
		
		Davao.description =  "Davao is a lively city located on the southern island of\n"
				           + "Mindanao. Known for its natural attractions, including\n"
				           + "Mt. Apo, the highest mountain in the Philippines, and the\n"
				           + "Philippine Eagle Center, which is home to the endangered\n"
				           + "Philippine eagle. Davao is also famous for its durian\n"
				           + "fruit, which is a delicacy for locals.";
		
		Coron.hotelNames.add("Tag Resort");
		Coron.hotelNames.add("Skylodge");
		Coron.hotelNames.add("Club Paradise");
		Coron.hotelCost.add(100);
		Coron.hotelCost.add(97);
		Coron.hotelCost.add(220);
		
		Coron.restaurantNames.add("Pacifico Coron");
		Coron.restaurantNames.add("Ramen Sakura");
		Coron.restaurantNames.add("Epic Cafe Coron");
		Coron.restaurantCost.add(8);
		Coron.restaurantCost.add(6);
		Coron.restaurantCost.add(7);
		
		Coron.activities.add("Private Safari");
		Coron.activities.add("Island Hopping");
		Coron.activities.add("3 Day Palawan Reefs");
		Coron.avtivityCost.add(216);
		Coron.avtivityCost.add(192);
		Coron.avtivityCost.add(181);
		
		Coron.TravelToCity.add("Fly to Busuanga");
		Coron.travelCost.add(125);
		
		Coron.localTransportation.add("Private Boat");
		Coron.localTransportation.add("Motorcycle");
		Coron.localTransportation.add("Tricycle");
		Coron.localTransportCost.add(40);
		Coron.localTransportCost.add(24);
		Coron.localTransportCost.add(7);
		
		Coron.description =  "Located in the northern part of Palawan island, Coron is\n"
			         	   + "known for its beautiful beaches, crystal-clear waters,\n"
			         	   + "and world-class diving spots. Visitors can explore the\n"
			         	   + "underwater shipwrecks from World War II, go island\n"
			         	   + "hopping, or relax on the pristine beaches. Coron is also\n"
			         	   + "home to the Kayangan Lake, which has been called the\n"
			         	   + "cleanest lake in Asia.";

	}
	public void cityNamesToString() {
		int x=0;
		for(int i=0;i<arr.length;i++) {
			x++;
			System.out.println("("+x+") "+arr[i].name);
		}
		x+=1;
		System.out.println("\n("+x+") I'm done planning\n");
	}
	
	public void LocationDetailsToString(City a) {	
		System.out.println(a.description+"\n");
		System.out.println("Select one from this city's restaurants, hotels, and attractions:");
		int x=0;
		System.out.println("\nHotels:");
		for(int i=0;i<a.hotelNames.size();i++) {
			x++;
			System.out.println("(a"+x+") "+a.hotelNames.get(i)+" - $"+a.hotelCost.get(i));
		}
		x=0;
		System.out.println("\nFood:");
		for(int i=0;i<a.restaurantNames.size();i++) {
			x++;
			System.out.println("(b"+x+") "+a.restaurantNames.get(i)+" - $"+a.restaurantCost.get(i));
		}
		x=0;
		System.out.println("\nThings to do:");
		for(int i=0;i<a.activities.size();i++) {
			x++;
			System.out.println("(c"+x+") "+a.activities.get(i)+" - $"+a.avtivityCost.get(i));
		}
		x=0;
		System.out.println("\nHow to get there:");
		for(int i=0;i<a.TravelToCity.size();i++) {
			x++;
			System.out.println("(d"+x+") "+a.TravelToCity.get(i)+" - $"+a.travelCost.get(i));
		}
		x=0;
		System.out.println("\nLocal transportation:");
		for(int i=0;i<a.localTransportation.size();i++) {
			x++;
			System.out.println("(e"+x+") "+a.localTransportation.get(i)+" - $"+a.localTransportCost.get(i));
		}
		System.out.println("\n(f) go back");
	}
}


