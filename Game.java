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

    }
}
