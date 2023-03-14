package labs_examples.objects_classes_methods.labs.oop.B_polymorphism;
import java.util.ArrayList;
import java.util.Scanner;

class PlayableCharacter implements GameCharacter{
	
	Scanner playerInput = new Scanner(System.in);
	int HP;
	int wallet;
	String equippedWeapon;
	ArrayList<String> inventory = new ArrayList<String>();
	
	
	public PlayableCharacter(int HP,String equippedWeapon, String name, ArrayList<String> inventory) {
		this.HP = HP;
		this.inventory = inventory;
		this.equippedWeapon = equippedWeapon;
	}

	
	@Override
	public void attack() {
		System.out.println("You attack the enemy with "+equippedWeapon+".");
	}

	@Override
	public void speak() {
		System.out.println("You speak");
	}

	@Override
	public void move() {
		System.out.println("You begin walking");
	}

	@Override
	public void flee() {
		System.out.println("Your HP is too low. You flee from the battle");
	}
	public void shop(String a) {
		System.out.println("You enter the weapons shop and purchase a "+a+".");
		inventory.add(a);
		System.out.println(a+" has been added to your inventory.");
		
	}
	public void defeatEnemy(int enemyHP) {
		int i = 0;
		while(i<enemyHP) {
			System.out.println("You deal +20 damage");
			i+=20;
			
		}
		System.out.println("You defeated the enemy");
	}
}



