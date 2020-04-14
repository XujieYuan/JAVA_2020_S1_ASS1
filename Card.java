/**
 *
 */

public class Card {
    private int suit;
    private int number;

    /**
     *
     */
    public Card(){
        suit = 0;
        number = 0;
    }

    /**
     *
     */
    public Card(int newSuit, int newNumber){
        suit = newSuit;
        number = newNumber;
    }

    /**
     *
     */
    public int getSuit() {
        return suit;
    }

    public int getNumber() {
        return number;
    }

    /**
     *
     */
    public void setSuit(int suit) {
        this.suit = suit;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Card creatCard()
    {
        Card card = new Card();
        RandomNumber rn = new RandomNumber();
        int randomSuit = rn.getRandomNumber(4, 1);
        card.setSuit(randomSuit);
        int randomNumber = rn.getRandomNumber(13, 1);
        card.setNumber(randomNumber);
        System.out.println("suit is " + randomSuit + " number is " + randomNumber);
        return card;
    }
}
