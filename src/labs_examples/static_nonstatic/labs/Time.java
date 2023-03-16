package labs_examples.static_nonstatic.labs;

public class Time {

	public static void main(String[] args) {
		
		Movie a = new Movie("Interstellar",169, 2.8);
		Movie b = new Movie("Skyfall",143, 2.3);
		Movie c = new Movie("Arrival",116, 1.9);
		
		//1) A static method calling another static method in the same class
		System.out.println(Time.hoursToMinutes(a.runtimeHours));
		
		//2) A static method calling a non-static method in the same class
		Time time = new Time();
		time.remainingTime(a,34);
		
		//3) A static method calling a static method in another class
		Movie.totalMovieswatched();
		
		//4) A static method calling a non-static method in another class
		b.mainCharWins();
		
		time.remainingTime(b, 100);

	}
	public static int minutesToSeconds(int a) {
		
		int x = a * 60;
		return x;
	}
	
	public static double hoursToMinutes(double a) {
		double x = a * 60;	
		return x;
	}

	//6) A non-static method calling a non-static method in another class
	public void remainingTime(Movie a, int b) {
		int x = a.runtime - b;
		System.out.println(x);
		System.out.println("In the next "+x+" minutes, ");
		a.defeatBadGuy();
		
		//7) A non-static method calling a static method in the same class
		System.out.println("In seconds, that is "+minutesToSeconds(x)+".");
		
		//8) A non-static method calling a static method in another class
		Movie.totalMovieswatched();
	}
}
