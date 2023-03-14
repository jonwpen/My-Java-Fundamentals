package labs_examples.objects_classes_methods.labs.oop.B_polymorphism;

public class Player{
	String username;
	int ranking;
	int totalPlaytime;
	
	public Player(String username,int ranking,int totalPlaytime) {
		this.username = username;
		this.ranking = ranking;
		this.totalPlaytime = totalPlaytime;
	}
	public void startPlaying() {
		System.out.println("You turn the console on and start playing a game.");
	}
	public void stopPlaying() {
		System.out.println("You save the game and turn the console off.");
	}
	
}