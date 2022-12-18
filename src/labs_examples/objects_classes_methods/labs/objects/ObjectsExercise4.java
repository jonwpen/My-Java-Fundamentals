package labs_examples.objects_classes_methods.labs.objects;

public class ObjectsExercise4 {

	public static void main(String[] args) {
		
		SpaceShip tinyShip = new SpaceShip();
		SpaceShip mediumShip = new SpaceShip(10);
		SpaceShip largeShip = new SpaceShip(10, 5);
		SpaceShip motherShip = new SpaceShip(10000, 1000);
		
		System.out.println("The medium ships fires all "+mediumShip.rockets+" rockets at the tiny ship, destroying it."+
		"\nIt is then itself destroyed by "+largeShip.rockets+" rockets and "+largeShip.missiles+" missiles from a large ship.");
		
		System.out.println();
		System.out.println(tinyShip.toString());
		System.out.println(mediumShip.toString());
		System.out.println(largeShip.toString());
		System.out.println(motherShip.toString());
		

	}

}
class SpaceShip{
	String name;
	int rockets;
	int missiles;
	
	public SpaceShip(){
		
	}
	public SpaceShip(int rockets) {
		this.rockets=rockets;
		
	}
	public SpaceShip(int rockets, int missiles) {
		this.rockets=rockets;
		this.missiles=missiles;
	}
	@Override
	public String toString() {
		return "SpaceShip [name=" + name + ", rockets=" + rockets + ", missiles=" + missiles + "]";
	}
	
}