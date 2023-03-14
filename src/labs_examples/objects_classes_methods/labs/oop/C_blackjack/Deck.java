package labs_examples.objects_classes_methods.labs.oop.C_blackjack;

import java.util.ArrayList;
import java.util.Random;

public class Deck {
	 
	Random rando = new Random();
     ArrayList<Integer> usedCards;
     ArrayList<Card> fullDeck;

     char[] suit = {'♠', '♦', '♥', '♣'};
     String[] z = {"Ace","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Jack","Queen","King"};
     
     public Deck(){
    	this.fullDeck = new ArrayList<Card>();
    	this.usedCards = new ArrayList<Integer>();
     }
     public void newDeck() {
    	 for(int i=0;i<suit.length;i++) {
    		 for(int j=0;j<z.length;j++) {
    			 this.fullDeck.add(new Card(suit[i],z[j]));
    		 }
    	 }
     }
     public void viewDeck() {
    	 for(int i=0;i<this.fullDeck.size();i++) {
    		 System.out.println(this.fullDeck.get(i).toString());
    	 }
     }
     public void deal(Player a) {
    	 int rNum =   rando.nextInt(52);
    	 int x = 1;
    	 
    	 while(x < 52) {
    		 x++;
    		 rNum =   rando.nextInt(52);
    		 if(!(usedCards.contains(rNum))) 
        		 break;
    	 }
    	 a.hand.cards.add(this.fullDeck.get(rNum));
     		 usedCards.add(rNum);
     }
     public void viewUsedCards() {
    	 for(int i=0;i<usedCards.size();i++) {
    		 System.out.println(usedCards.get(i).toString());
    	 }
     }
	public ArrayList<Card> getFullDeck() {
		return fullDeck;
	}
	public void setFullDeck(ArrayList<Card> fullDeck) {
		this.fullDeck = fullDeck;
	}
}


