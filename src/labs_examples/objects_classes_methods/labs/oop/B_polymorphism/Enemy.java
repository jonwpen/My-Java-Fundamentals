package labs_examples.objects_classes_methods.labs.oop.B_polymorphism;

class Enemy implements GameCharacter{
	
	int HP;
	
	Enemy(int HP){
		this.HP = HP;
	}

	@Override
	public void attack() {
		System.out.println("The enemy attacks and deals minor damage.");
	}

	@Override
	public void speak() {
		System.out.println("The enemy taunts you.");
	}

	@Override
	public void move() {
		System.out.println("The enemy rushes toward you.");
	}

	@Override
	public void flee() {
		System.out.println("The enemy runs away.");
	}
	public void attackCombo(int a) {
		System.out.println("The enemy does "+a+" damage");
	}
	public void attackCombo(int a, int b) {
		int sum = a+b;
		System.out.println("The enemy chains two attacks and does +"+sum+" damage.");
	}
	public void attackCombo(int a, int b, int c) {
		int sum=a+b+c;
		System.out.println("The enemy chains three attacks and does +"+sum+" damage.");
	}
}


