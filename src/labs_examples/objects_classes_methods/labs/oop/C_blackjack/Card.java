package labs_examples.objects_classes_methods.labs.oop.C_blackjack;

public class Card {
	char[] suit = {'♠', '♦', '♥', '♣'};
    int cardValue;
    char c;
    String d;
    
    public Card(char c, String d){
    	this.c=c;
    	this.d=d;
    }

	@Override
	public String toString() {  
		return " " + c
				+ " " + d + "";
	}
    
}
