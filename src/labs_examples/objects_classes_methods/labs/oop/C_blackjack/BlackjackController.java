package labs_examples.objects_classes_methods.labs.oop.C_blackjack;
import java.util.Scanner;

public class BlackjackController {

	static Scanner sc = new Scanner(System.in);
	static int gamesPlayed;
	static int p1wins;
	static int p2wins;
	
	public static void main(String[] args) {

		Deck deck = new Deck();
		
		playBlackJack(deck);
		System.out.println("Let's play again!");
	}
	//Tracks how many games each player has won.
	public static void winsCounter(Player a, Player b) {
		System.out.println(a.name+" wins: "+p1wins);
		System.out.println(b.name+" wins: "+p2wins);
	}
	public static void playBlackJack(Deck deck) {
		
		int hv1=0;
		int hv2=0;
		Hand hand = new Hand(hv1);
		Hand hand2 = new Hand(hv2);
		
		System.out.println("Welcome to Blackjack!");
		System.out.println("Enter your name:");
		String p1name = sc.nextLine();
		Player one = new Player(p1name, hand);
		Player two = new Player("computer", hand2);
		one.wallet = 20;
		two.wallet = 20;	
		
		while(one.wallet > 0 && two.wallet > 0) {
			coreGameLoop(one,two,deck);
			gamesPlayed++;
			System.out.println("Games played: "+gamesPlayed);
			winsCounter(one,two);
		}
		if(one.wallet < 1 || two.wallet < 1) {
			System.out.println("\n"+one.name+" has $"+one.wallet+" and the computer has $"+two.wallet+".\nGame over");
			return;
		}
	}
	//Alternate between asking human and computer if they want another card until the game ends.
	public static void coreGameLoop(Player a,Player b,Deck c) {  

		int potValue;
		
			boolean p1hit=true;
			boolean p2hit=true;
			//Placing bets
			System.out.println("\nYou currently have $"+a.wallet+" in your wallet.");
			System.out.println("Place your bet:");
			a.betValue = sc.nextInt();
			a.wallet-=a.betValue;
			
			b.computerAiPlacesBet(b.wallet);
			b.wallet-=b.betValue;
			System.out.println("The computer bets $"+b.betValue);
			
			potValue = a.betValue + b.betValue;
			System.out.println("The pot is $"+potValue);
			
			//Reset the hands and used cards list.
			a.hand.handValue=0;
			b.hand.handValue=0;
			a.hand.emptyHand(a);
			b.hand.emptyHand(b);
			c.usedCards.clear();
			
			c.newDeck();
			//deck.viewDeck();  //Test the newDeck method.
			c.deal(a); 
			c.deal(a);
			c.deal(b);
			c.deal(b);
			//System.out.println("TEST"+a.hand.toString()); //Test the deal method
			//System.out.println("TEST"+b.hand.toString()); //Test the deal method
			System.out.println("The dealer deals two cards to "+a.name+" and two cards to the computer AI.");
		
			//Take turns drawing cards until a single game ends.
			while((a.hand.handValue<22 && b.hand.handValue<22)&&(p1hit || b.computerAi(b.hand.handValue))) {
				//while(a.hand.handValue<22 && b.hand.handValue<22) {	
					a.hand.returnScore(c);
				if(p1hit && a.hand.handValue < 22) {
					

					System.out.println("Your "+a.hand.toString());
					System.out.println("Your current hand is valued at: "+a.hand.returnScore(c)+"\n");
					System.out.println("Do you want to draw another card?\n\"y\" = yes\n\"n\" = no");
						
					if(sc.next().equals("y")) {
					c.deal(a);
					System.out.println("You draw another card.");
					
					}
					else {
					p1hit=false;
					System.out.println("You stand.\n");
					}
				}
				if(p2hit) {
					b.hand.returnScore(c); //
					for(int i=0;i<5;i++) {
						if(b.computerAi(b.hand.handValue)) {
						System.out.println("The computer draws another card.");
						c.deal(b);
						b.hand.returnScore(c);
						//System.out.println("The computer's hand value: "+b.hand.returnScore(c));
						break;
						}
						else {
						p2hit=false;
						System.out.println("The computer AI stands.");
						break;
						}
					}
				}		
			}
			if(a.hand.handValue<22 && b.hand.handValue>21) {
				System.out.println(a.name+"'s "+a.hand.toString()+"\n"+b.name+"'s "+b.hand.toString());
				System.out.println("You have "+a.hand.handValue+" and the computer has "+b.hand.handValue+".\n"+a.name+" wins!");
				a.wallet += potValue;
				p1wins++;
				return;
			}
			if(a.hand.handValue>21 && b.hand.handValue<22) {
				System.out.println(a.name+"'s "+a.hand.toString()+"\n"+b.name+"'s "+b.hand.toString());
				System.out.println("You have "+a.hand.handValue+" and the computer has "+b.hand.handValue+".\nThe computer wins.");
				b.wallet += potValue;
				p2wins++;
				return;
			}
			if(a.hand.handValue>b.hand.handValue && a.hand.handValue<22) {
				System.out.println(a.name+"'s "+a.hand.toString()+"\n"+b.name+"'s "+b.hand.toString());
				System.out.println("You have "+a.hand.handValue+" and the computer has "+b.hand.handValue+".\n"+a.name+" wins!");
				a.wallet += potValue;
				p1wins++;
				return;
			}
			if(a.hand.handValue==b.hand.handValue) {
				System.out.println(a.name+"'s "+a.hand.toString()+"\n"+b.name+"'s "+b.hand.toString());
				System.out.println("You both have "+a.hand.handValue+".\nIt's a draw.");
				a.wallet+=a.betValue;
				b.wallet+=b.betValue;
				return;
			}
			if(b.hand.handValue>a.hand.handValue && b.hand.handValue<22) {
				System.out.println(a.name+"'s "+a.hand.toString()+"\n"+b.name+"'s "+b.hand.toString());
				System.out.println("You have "+a.hand.handValue+" and the computer has "+b.hand.handValue+".\nThe computer wins.");
				b.wallet += potValue;
				p2wins++;
				return;
			}
	}
}
