package labs_examples.static_nonstatic.labs;

public class Movie {
	
	public int runtime;
	public String mainCharacter;
	public String leadingMan;
	String title;
	static int totalMovieswatched;
	double runtimeHours;
	
	public static void totalMovieswatched() {
		System.out.println("You have watched "+totalMovieswatched+" movies.");
	}
	
	Movie(String title, int runtime, double runtimeHours){
		this.title=title;
		this.runtime=runtime;
		this.runtimeHours = runtimeHours;
		totalMovieswatched++;
	}
	
	//5) A non-static method calling a non-static method in the same class
	public void mainCharWins() {
		defeatBadGuy();
		System.out.println("The main character saves the world");
	}
	
	public void defeatBadGuy() {
		System.out.println("The main character defeats the bad guy");
	}
}
