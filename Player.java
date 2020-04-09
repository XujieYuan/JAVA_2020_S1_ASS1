/**
 *
 * @author
 * @version
 *
 */

public class Player {
    private String name;
    private int score;
    private int guess;
    private int highestScore;
    private int numberOfGamesPlayed;
    private int numberOfGamesWon;

    /**
     *
     */
    public Player(){
        name = "";
        score = 40;
        guess = 0;
        highestScore = 0;
        numberOfGamesPlayed = 0;
        numberOfGamesWon = 0;
    }

    /**
     *
     */
    public Player(String newName, int newScore, int newGuess, int newHighestScore, int newNumberOfGamesPlayed, int newNumberOfGamesWon){
        name = newName;
        score = newScore;
        guess = newGuess;
        highestScore = newHighestScore;
        numberOfGamesPlayed = newNumberOfGamesPlayed;
        numberOfGamesWon = newNumberOfGamesWon;
    }

    /**
     *
     */
    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public int getGuess() {
        return guess;
    }

    public int getHighestScore() {
        return highestScore;
    }

    public int getNumberOfGamesPlayed() {
        return numberOfGamesPlayed;
    }

    public int getNumberOfGamesWon() {
        return numberOfGamesWon;
    }

    /**
     *
     */
    public void setName(String name) {
        this.name = name;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setGuess(int guess) {
        this.guess = guess;
    }

    public void setHighestScore(int highestScore) {
        this.highestScore = highestScore;
    }

    public void setNumberOfGamesPlayed(int numberOfGamesPlayed) {
        this.numberOfGamesPlayed = numberOfGamesPlayed;
    }

    public void setNumberOfGamesWon(int numberOfGamesWon) {
        this.numberOfGamesWon = numberOfGamesWon;
    }
}
