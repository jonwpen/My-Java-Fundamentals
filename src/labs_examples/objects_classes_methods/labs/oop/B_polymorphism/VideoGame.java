package labs_examples.objects_classes_methods.labs.oop.B_polymorphism;

public class VideoGame{
	
	String[] worldMap; 
	String[] soundtrack;
	String genre;
	String platform;
	GameCharacter gChar;

	public VideoGame(String gameComponents, int numOfPlayers, String goal) {
		
		
	}
	
	public String[] viewWorldMap(String[] a) { //this one can be used for any game
		
		System.out.println("You open the map:");
		System.out.println();
		
		for(int i=0;i<a.length;i++) {
			System.out.println(a[i]);
		}
		return null;
	}
}