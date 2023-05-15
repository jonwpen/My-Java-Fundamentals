package labs_examples.multi_threading.labs;

/**
 * Multithreading Exercise 5:
 *
 *      Demonstrate the use of a wait() and notify()
 */

public class Exercise_05{
	public static void main(String[] args) {
		
		Player p = new Player();
		Enemy e = new Enemy(p);
		
		Thread pThread = new Thread(p);
		Thread eThread = new Thread(e);
		
		pThread.start();
		eThread.start();
		
		try {
			pThread.join();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}
}
//Player synchronizes on itself and waits for enemy to respond.
class Player implements Runnable{

	public void attack() {
		System.out.println("Player attacks");
	}
	@Override
	public void run() {
		attack();
		synchronized(this) {
			try {
				wait();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Player evades incoming counter attack");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
//Enemy synchronizes on the same player object
class Enemy implements Runnable{
	Player player;
	
	Enemy(Player p){
		this.player = p;
	}

	public void blockAttack() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Enemy blocks the attack");
	}
	@Override
	public void run() {
		blockAttack();
		synchronized(player) {
			player.notify();
		}
	}
}