package labs_examples.objects_classes_methods.labs.oop.B_polymorphism;

public class SwapPartyLeader {

	GameCharacter gChar;
	
	SwapPartyLeader(GameCharacter gChar){
		this.gChar = gChar;
	}
	
	
	public void setLeader(GameCharacter gChar) {
		
		this.gChar = gChar;
		System.out.println("You switch the party leader to "+gChar+".");
	}
	public void attackMethod() {
		gChar.attack();
	}
}
