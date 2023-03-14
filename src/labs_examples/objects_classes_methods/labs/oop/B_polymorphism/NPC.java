package labs_examples.objects_classes_methods.labs.oop.B_polymorphism;

class NPC implements GameCharacter{

	@Override
	public void attack() {
	}

	@Override
	public void speak() {
		System.out.println("The NPC gives you a side quest.");
	}

	@Override
	public void move() {
	}

	@Override
	public void flee() {
	}
	
}