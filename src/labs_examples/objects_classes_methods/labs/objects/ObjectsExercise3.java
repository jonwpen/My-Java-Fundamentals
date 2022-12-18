package labs_examples.objects_classes_methods.labs.objects;

public class ObjectsExercise3 {

	public static void main(String[] args) {
		GameConsole gc = new GameConsole("Playstation 4");
		VideoGame vg = new VideoGame("Nier: Automata");
		
		System.out.println("I am currently playing "+vg.game+" on the "+gc.console+".");
		

	}

}
class GameConsole{
	String console;
	public GameConsole(String console) {
		this.console = console;
		
	}
	
}
class VideoGame{
	String game;
	public VideoGame(String game) {
		this.game = game;
	}
}