package labs_examples.multi_threading.labs;

/**
 * Multithreading Exercise 4:
 *
 *      Demonstrate the use of a synchronized block and a synchronized method - ensure that the synchronization is
 *      working as expected
 */

//Using a synchronized block
public class Exercise_04{
	public static void main(String[] args) {
		AttackWave aW = new AttackWave();
		CombatAircraft fighterJet = new CombatAircraft(3,aW,"F-22 Raptor");
		CombatAircraft fighterJet2 = new CombatAircraft(5,aW,"F-35 Lightning II");
		
		fighterJet.start();
		fighterJet2.start();
		
		try {
			fighterJet.join();
			fighterJet2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//Reproducing the result using synchronized method instead of block.
		AttackWave2 aW2 = new AttackWave2();
		CombatAircraft2 Jet = new CombatAircraft2(3,aW2,"F-22 Raptor");
		CombatAircraft2 Jet2 = new CombatAircraft2(5,aW2,"F-35 Lightning II");
		
		Jet.start();
		Jet2.start();
		
		try {
			Jet.join();
			Jet2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
class AttackWave{
	int missile=0;
	public void attack(String name,int missile) {
		int firingSpeed = 1000;
		for(int i=0;i<5;i++) {
			missile++;
			firingSpeed-=(firingSpeed/2);
			try {
				Thread.sleep(firingSpeed);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(name+" firing "+missile+" missiles");
		}
	}
}
class CombatAircraft extends Thread{
	private int missile;
	AttackWave attackWave;
	String name;
	
	CombatAircraft(int m, AttackWave obj, String name){
		missile = m;
		this.name = name;
		attackWave = obj;
	}
	public void run() {
		synchronized(attackWave){
			attackWave.attack(this.name,missile);
		}
	}
}
//Using a synchronized method
class AttackWave2{
	int missile=0;
	public synchronized void attack(String name,int missile) {
		int firingSpeed = 1000;
		for(int i=0;i<5;i++) {
			missile++;
			firingSpeed-=(firingSpeed/2);
			try {
				Thread.sleep(firingSpeed);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(name+" firing "+missile+" missiles");
		}
	}
}
class CombatAircraft2 extends Thread{
	private int missile;
	AttackWave2 attackWave2;
	String name;
	
	CombatAircraft2(int m, AttackWave2 obj, String name){
		missile = m;
		this.name = name;
		attackWave2 = obj;
	}
	public void run() {
			attackWave2.attack(this.name,missile);
	}
}