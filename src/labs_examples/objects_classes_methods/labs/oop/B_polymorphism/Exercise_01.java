package labs_examples.objects_classes_methods.labs.oop.B_polymorphism;
import java.util.ArrayList;

//For this exercise, I am using a real video game as an example to model some characters and story events.
//I have used method overriding, method overloading, and and dependency injection with an interface as a constructor parameter.

public class Exercise_01 {

	public static void main(String[] args) {
		
		VideoGame NierAutomata = new VideoGame("controller, game disc", 1, "Complete main quest");
		String[] map = {"Factory","Bunker","City Ruins","Desert","Amusement Park","Machine Village","Forest","Flooded City","Resistance Camp","The Tower"};
		
		Enemy machineEntity = new Enemy(100);
		NPC devola = new NPC();
		PlayableCharacter twoB = new PlayableCharacter(7000, "Beastbane", "2B", new ArrayList<String>());
		PlayableCharacter aTwo = new PlayableCharacter(8000, "Virtuous Contract", "A2", new ArrayList<String>());
		Player John = new Player("jonwpen", 596, 10);
		SwapPartyLeader swap = new SwapPartyLeader(aTwo);
		
//-----------------------------------------------------------------------------------------------------------
		
		John.startPlaying();
		twoB.move();
		twoB.speak();
		devola.speak();
		twoB.shop("Type-4O Sword");
		System.out.println("You equip "+twoB.inventory.get(0));
		NierAutomata.viewWorldMap(map);
		System.out.println("As instructed by Devola, you travel to the "+map[4]); 
		//Dependency injection methods
		swap.setLeader(aTwo);
		swap.attackMethod();
		swap.setLeader(twoB);
		swap.attackMethod();
		
		machineEntity.attackCombo(450, 974);
		twoB.defeatEnemy(machineEntity.HP);
		machineEntity.toString();
		John.stopPlaying();
	}
}