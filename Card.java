/**
 *
 */

public class Card {
    private String suit;
    private int number;

    /**
     *
     */
    public Card(){
        suit = "";
        number = 0;
    }

    /**
     *
     */
    public Card(String newSuit, int newNumber){
        suit = newSuit;
        number = newNumber;
    }

    /**
     *
     */
    public String getSuit() {
        return suit;
    }

    public int getNumber() {
        return number;
    }

    /**
     *
     */
    public void setSuit(String suit) {
        this.suit = suit;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
