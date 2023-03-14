package labs_examples.objects_classes_methods.labs.oop.A_inheritance;

public class A_Exercise_01 {

	public static void main(String[] args) {

		Alcohol vodka = new Alcohol(false, "none", 0, 40, false);
		Meat chicken = new Meat(true, "protein", 335, "white");
		Broccoli broccoli = new Broccoli(true, "fiber", 50, "green");
		Drink water = new Drink(true,"hydration", 0, true);
		
		water.takeAdrink();
		vodka.prepareFood();
		vodka.takeAdrink();
		System.out.println("\nYou are drinking a glass of vodka with an alcohol content of "+vodka.alcoholContent+"%.\n");
		
		broccoli.displayRecipe();
		System.out.println();
		chicken.prepareFood();
		System.out.println();
		broccoli.prepareFood();
		System.out.println("\nThe healthiest meal is grilled chicken and broccoli with a total of "+chicken.getCombinedCalories(chicken.caloriesPerServing, broccoli.caloriesPerServing)+" calories per serving.");
		System.out.println("\nChicken is a "+chicken.type+" meat with "+chicken.nutrientValue+" as a main nutrient. Broccoli is a "+broccoli.color+" vegetable with "+broccoli.nutrientValue+" being its main nutrient.");
		System.out.println("\nA less nutrient dense meal would be broccoli and vodka ("+broccoli.getCombinedCalories(vodka.caloriesPerServing, broccoli.caloriesPerServing)+"). Vodka has a nutrient value of "+vodka.nutrientValue+".");
	}

}
class Food {
	
	public boolean healthy;
	String nutrientValue;
    int caloriesPerServing;
	
	Food(boolean healthy, String nutrientValue, int caloriesPerServing){
		this.healthy = healthy;
		this.nutrientValue = nutrientValue;
		this.caloriesPerServing = caloriesPerServing;
	}

	public void prepareFood() {
		System.out.println("You cook the food");
	}
	
	public void displayRecipe() {
		
	}
	public int getCombinedCalories(int a, int b) {
		return a+b;
	}
	
}
class Vegetable extends Food{
	
	String color;

	Vegetable(boolean healthy, String nutrientValue, int caloriesPerServing, String color) {
		super(healthy, nutrientValue, caloriesPerServing);
		
		this.color = color;
	}

}
class Meat extends Food{

	String type;
	
	Meat(boolean healthy, String nutrientValue, int caloriesPerServing, String type) {
		super(healthy, nutrientValue, caloriesPerServing);
		
		this.type = type;
	}
	@Override
	public void prepareFood() {
		System.out.println("You thaw the meat, season it, and fry it in oil.");
	}

}
class Drink extends Food{
	
	boolean isHydrating;

	Drink(boolean healthy, String nutrientValue, int caloriesPerServing, boolean isHydrating) {
		super(healthy, nutrientValue, caloriesPerServing);
		this.isHydrating = isHydrating;
		
	}
	@Override
	public void prepareFood() {
		System.out.println("You pour a drink.");
	}
	public void takeAdrink() {
		System.out.println("You take a drink. You are hydrated.");
	}

}
class Broccoli extends Vegetable{

	Broccoli(boolean healthy, String nutrientValue, int caloriesPerServing, String color) {
		super(healthy, nutrientValue, caloriesPerServing, color);
		
	}
	
	@Override
	public void prepareFood() {
		System.out.println("You combine the chicken and broccoli into a casserole, then bake it.");
	}
public void displayRecipe() {
		System.out.println("casserole:\nchicken\nbroccoli\nolive oil\ngarlic\ncheese\nrice\nsalt\npepper");
	}

}
class Alcohol extends Drink{
	
	int alcoholContent;

	public Alcohol(boolean healthy, String nutrientValue, int caloriesPerServing, int alcoholContent, boolean isHydrating) {
		super(healthy, nutrientValue, caloriesPerServing, isHydrating );
		
		this.alcoholContent = alcoholContent;
	}
	@Override
	public void takeAdrink() {
		System.out.println("You take a drink. You are drunk.");
	}

}