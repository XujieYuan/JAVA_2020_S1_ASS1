import java.util.Scanner;

/**
 *
 *
 */

public class Game {
    private Player cardGamePlayer;

    /**
     *
     */
    public Game() {
        cardGamePlayer = new Player();
    }

    /**
     *
     */
    public Game(Player newCardGamePlayer) {
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
    public void start() {
        displayWelcomeMessage();
        registerPlayer();
        playGame();
        System.exit(0);
    }

    public void playGame() {
        int time = 1;
        int winTime = 0;
        int highestScore = 0;
        while (true) {
            Card cd = new Card();
            Card card = cd.creatCard();
            compareSuit(card);
            if (compareNumber(card))
            {
                if (cardGamePlayer.getScore() > highestScore)
                {
                    highestScore = cardGamePlayer.getScore();
                }
                winTime++;
            }
            System.out.println("Do you want to play another game?");
            System.out.println("Press 'y' for 'Yes'");
            System.out.println("Press 'n' for 'No'");
            Scanner console = new Scanner(System.in);
            String input = console.nextLine();
            if (playAgain(input)) {
                cardGamePlayer.setScore(40);
                time++;
                continue;
            }
            if (!playAgain(input)) {
                endGame();
                break;
            }
        }
        System.out.println("The number of games you have played is " + time);
        System.out.println("The number of games you have won is " + winTime);
        System.out.println("The highest score for the games you played is " + highestScore);
    }

    public void displayWelcomeMessage() {
        System.out.println("Welcome to Guess a Card Game!");
    }

    public void registerPlayer() {
        System.out.println("Please enter your name!");
        Scanner console = new Scanner(System.in);
        String name = console.nextLine();
        for (int i = 0; i < name.length(); i++) {
            while (!((name.charAt(i) >= 'a' && name.charAt(i) <= 'z') || (name.charAt(i) >= 'A' && name.charAt(i) <= 'Z'))) {
                System.out.println("The player’s name cannot be blank and can contain only alphabetic characters.");
                name = console.nextLine();
            }
        }
        cardGamePlayer.setName(name);
    }

    public void compareSuit(Card card) {
        int wrongTime = 3;
        for (int i = 0; i < 3; i++) {
            enterSuit();
            if (cardGamePlayer.getGuess() == card.getSuit()) {
                System.out.println("Congratulations! This is a correct guess!");
                break;
            } else if ((cardGamePlayer.getGuess() != card.getSuit()) && (wrongTime != 1)) {
                System.out.println("Incorrect guess!");
                System.out.println("You still have " + (wrongTime - 1) + " chances.");
                System.out.println();
                wrongTime--;
            } else if ((cardGamePlayer.getGuess() != card.getSuit()) && (wrongTime == 1)) {
                System.out.println("You did 3 incorrect guesses. The correct suit is " + card.getSuit() + ".");
                wrongTime--;
                break;
            }
        }
        if (wrongTime == 2)
            cardGamePlayer.setScore(cardGamePlayer.getScore() - 5);
        else if (wrongTime == 1)
            cardGamePlayer.setScore(cardGamePlayer.getScore() - 15);
        else if (wrongTime == 0) {
            cardGamePlayer.setScore(cardGamePlayer.getScore() - 30);
        }
        System.out.println("Your current score is " + cardGamePlayer.getScore() + "!");
        System.out.println();
    }

    public void enterSuit()//Can add IOException in this method
    {
        System.out.println("Please enter a suit.");
        System.out.println("Press 1 for H (Hearts)");
        System.out.println("Press 2 for D (Diamonds)");
        System.out.println("Press 3 for C (Clubs)");
        System.out.println("Press 4 for S (Spades)");
        Scanner console = new Scanner(System.in);
        int suit = console.nextInt();
        while (suit < 1 || suit > 4) {
            System.out.println("Invalid value! Your choice must between 1-4! Please enter again!");
            suit = console.nextInt();
        }
        cardGamePlayer.setGuess(suit);
        System.out.println("Your guess is " + cardGamePlayer.getGuess() + ".");
    }

    public boolean compareNumber(Card card) {
        int wrongTime = 4;
        boolean win = true;
        for (int i = 0; i < 4; i++) {
            enterCardNumber();
            if (cardGamePlayer.getGuess() == card.getNumber()) {

                if (checkScore()) {
                    System.out.println("Congratulations! This is a correct guess! !WIN!");
                    break;
                }
            } else if ((cardGamePlayer.getGuess() != card.getNumber()) && (wrongTime != 1)) {
                System.out.println("Incorrect guess!");
                System.out.println("You still have " + (wrongTime - 1) + " chances.");
                wrongTime--;
                if (wrongTime == 3) {
                    cardGamePlayer.setScore(cardGamePlayer.getScore() - 2);
                } else if (wrongTime == 2) {
                    cardGamePlayer.setScore(cardGamePlayer.getScore() - 6);
                } else if (wrongTime == 1) {
                    cardGamePlayer.setScore(cardGamePlayer.getScore() - 12);
                }
                if (checkScore()) {
                    if (card.getNumber() > cardGamePlayer.getGuess()) {
                        System.out.println("The correct card number is higher than your last guess.");
                    }
                    if (card.getNumber() < cardGamePlayer.getGuess()) {
                        System.out.println("The correct card number is lower than your last guess.");
                    }
                    continue;
                }
                if (!(checkScore())) {
                    System.out.println("But your score is not greater than 0 now! !LOSE!");
                    cardGamePlayer.setScore(0);
                    win = false;
                    break;
                }
            } else if ((cardGamePlayer.getGuess() != card.getNumber()) && (wrongTime == 1)) {
                cardGamePlayer.setScore(cardGamePlayer.getScore() - 20);
                System.out.println("!LOSE! You did 4 incorrect guesses. The correct number is " + card.getNumber() + ".");//Can write a switch method in Class Card to transfer the number to character
                cardGamePlayer.setScore(0);
                win = false;
                break;
            }
        }
        System.out.println("Your current score is " + cardGamePlayer.getScore() + "!");
        System.out.println();
        return win;
    }

    public void enterCardNumber()//Can add IOException in this method
    {
        System.out.println("Please enter a card number from 1 to 13.");
        Scanner console = new Scanner(System.in);
        int cardNumber = console.nextInt();
        while (cardNumber < 1 || cardNumber > 13) {
            System.out.println("Invalid value! Your choice must between 1-13! Please enter again!");
            cardNumber = console.nextInt();
        }
        cardGamePlayer.setGuess(cardNumber);
    }

    public boolean checkScore() {
        if (cardGamePlayer.getScore() > 0)
            return true;
        else
            return false;
    }

    public boolean playAgain(String input) {
        boolean whetherPlayAgain = true;
        switch (input) {
            case "y":
                break;
            case "n":
                whetherPlayAgain = false;
                break;
            default:
                System.out.println("Invalid option! Please enter again!");//error
                break;
        }
        return whetherPlayAgain;
    }

    public void endGame() {
        System.out.println("Stop program...");
    }
}
