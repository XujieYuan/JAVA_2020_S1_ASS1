import java.util.Scanner;

/**
 *
 */

public class Game {
    private Player cardGamePlayer;

    /**
     *
     */
    public Game(){
        cardGamePlayer = new Player();
    }

    /**
     *
     */
    public Game(Player newCardGamePlayer){
        cardGamePlayer = newCardGamePlayer;
    }

    /**
     *
     */
    public Player getCardGamePlayer() {
        return cardGamePlayer;
    }

    /**
     *
     */
    public void setCardGamePlayer(Player cardGamePlayer) {
        this.cardGamePlayer = cardGamePlayer;
    }

    /**
     *
     */
    public void start(){
        displayWelcomeMessage();
        registerPlayer();
        Card cd = new Card();
        Card card = cd.creatCard();
        compareSuit(card);
        //compareNumber(card);
        System.exit(0);
    }

    public void displayWelcomeMessage(){
        System.out.println("Welcome to Guess a Card Game!");
    }

    public Player registerPlayer(){
        System.out.println("Please enter your name!");
        Scanner console = new Scanner(System.in);
        String name = console.nextLine();
        for(int i = 0; i < name.length(); i++)
        {
            while (!((name.charAt(i) >= 'a' && name.charAt(i) <= 'z') || (name.charAt(i) >= 'A' && name.charAt(i) <= 'Z')))
            {
                System.out.println("The player’s name cannot be blank and can contain only alphabetic characters.");
                name = console.nextLine();
            }
        }
        cardGamePlayer.setName(name);
        return cardGamePlayer;
    }



    public void compareSuit(Card card)
    {
        int attemptTime = 1;
        int wrongTime = 0;

        while (attemptTime < 3)
        {
            enterSuit();
            if (cardGamePlayer.getGuess() != card.getSuit())
            {
                System.out.println("Incorrect guess!");
                System.out.println(" Wrong ATTEMPT " + attemptTime);
                wrongTime++;
                attemptTime++;
                enterSuit();
            }
            if (cardGamePlayer.getGuess() == card.getSuit())
            {
                System.out.println("Congratulations! This is a correct guess!");
                break;
            }
        }
        if (wrongTime == 1)
            cardGamePlayer.setScore(cardGamePlayer.getScore() - 5);
        else if (wrongTime == 2)
            cardGamePlayer.setScore(cardGamePlayer.getScore() - 15);
        else if (wrongTime == 3)
        {
            cardGamePlayer.setScore(cardGamePlayer.getScore() - 30);
            System.out.println("You did 3 incorrect guesses.");
        }
        System.out.println("Your current score is " + cardGamePlayer.getScore());
    }

    public boolean checkCorrectSuitGuess(int suit)
    {
        if (cardGamePlayer.getGuess() == suit)
            return true;
        else
            return false;
    }

    public void enterSuit()
    {
        System.out.println("Please enter a suit.");
        System.out.println("Press 1 for H (Hearts)");
        System.out.println("Press 2 for D (Diamonds)");
        System.out.println("Press 3 for C (Clubs)");
        System.out.println("Press 4 for S (Spades)");
        Scanner console = new Scanner(System.in);
        int suit = console.nextInt();
        while (suit < 1 || suit > 4)
        {
            System.out.println("Invalid value! Your choice must between 1-4! Please enter again!");
            suit = console.nextInt();
        }
        cardGamePlayer.setGuess(suit);
        System.out.println("Your guess is " + cardGamePlayer.getGuess());
    }

    /**
    public void compareNumber(Card card)
    {
        int attemptTime = 0;
        enterSuit();
        while ((cardGamePlayer.getGuess() != card.getSuit()) && (attemptTime <= 3))
        {
            System.out.println("Incorrect guess!");
            attemptTime++;
            enterSuit();
        }
        if (cardGamePlayer.getGuess() == card.getSuit())
        {
            System.out.println("Congratulations! This is a correct guess!");
        }
        if (attemptTime == 0)
            cardGamePlayer.setScore(cardGamePlayer.getScore() - 0);
        else if (attemptTime == 1)
            cardGamePlayer.setScore(cardGamePlayer.getScore() - 5);
        else if (attemptTime == 2)
            cardGamePlayer.setScore(cardGamePlayer.getScore() - 15);
        else
            cardGamePlayer.setScore(cardGamePlayer.getScore() - 30);
        System.out.println("Your current score is " + cardGamePlayer.getScore());
    }
     */

    public void enterCardNumber()
    {
        System.out.println("Please enter a card number from 1 to 13.");
        Scanner console = new Scanner(System.in);
        int cardNumber = console.nextInt();
        while (cardNumber < 1 || cardNumber > 13)
        {
            System.out.println("Invalid value! Your choice must between 1-13! Please enter again!");
            cardNumber = console.nextInt();
        }
        cardGamePlayer.setGuess(cardNumber);
    }


}
