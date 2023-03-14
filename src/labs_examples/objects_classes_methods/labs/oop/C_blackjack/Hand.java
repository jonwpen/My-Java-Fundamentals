package labs_examples.objects_classes_methods.labs.oop.C_blackjack;

import java.util.ArrayList;

public class Hand {
	ArrayList<Card> cards;
    int handValue=0;
    int[] deckValues = {1,2,3,4,5,6,7,8,9,10,10,10,10,1,2,3,4,5,6,7,8,9,10,10,10,10,1,2,3,4,5,6,7,8,9,10,10,10,10,1,2,3,4,5,6,7,8,9,10,10,10,10};
    
    public Hand(int handValue){
    	this.handValue=handValue;
    	this.cards=new ArrayList<Card>();
    }
	public int returnScore(Deck d) {
		handValue=0;
    	int[] v = new int[cards.size()];
    	
    	for(int i=0;i<cards.size();i++) {            
    		v[i] = d.fullDeck.indexOf(cards.get(i));  
    	}
    	//assign a number value to cards in a hand
    	for(int j=0;j<v.length;j++) {               
    		handValue += deckValues[v[j]];                              
    	}                                
    	return handValue;
   	}
    public boolean checkForTwentyOne() {
    	if(handValue>21) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
	@Override
	public String toString() {
		return "hand = "+ cards.toString();
	}
    public void emptyHand(Player a) {
    	a.hand.cards.clear();
    }
}




