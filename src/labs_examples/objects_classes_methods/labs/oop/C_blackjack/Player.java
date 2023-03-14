package labs_examples.objects_classes_methods.labs.oop.C_blackjack;

import java.util.Random;

public class Player {
	String name;
    Hand hand;
    Deck deck;
    int wallet;
    int betValue;
    
    public Player(String name, Hand hand){
    	this.name=name;
    	this.hand=hand;
    }
    public boolean computerAi(int score) {
    	boolean b = true;
    	if(score<16) {
    		b = true;
    		return b;
    	}
    	if(score>=16) {
    		b = false;
    	}
		return b;
    }
    public void computerAiPlacesBet(int w) {
    	Random random = new Random();
    	if(w==1) {
    		betValue = 1;
    	}
    	else {
    		betValue = random.nextInt(1,w);
    	}
    }
}