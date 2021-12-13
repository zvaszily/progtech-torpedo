package hu.nye.progtech.torpedo.model;

/**
 * Model class used to Player.
 */
public class Player {
    private String playerName;
    private int numberOfGamesStarted;
    private int numberOfGamesWon;

    public Player(String playerName, int numberOfGamesStarted, int numberOfGamesWon) {
        this.playerName = playerName;
        this.numberOfGamesStarted = numberOfGamesStarted;
        this.numberOfGamesWon = numberOfGamesWon;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getNumberOfGamesStarted() {
        return numberOfGamesStarted;
    }

    public int getNumberOfGamesWon() {
        return numberOfGamesWon;
    }

    public void setNumberOfGamesStarted(int numberOfGamesStarted) {
        this.numberOfGamesStarted = numberOfGamesStarted;
    }

    public void setNumberOfGamesWon(int numberOfGamesWon) {
        this.numberOfGamesWon = numberOfGamesWon;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public Player() {}

    @Override
    public String toString() {
        return "Player{" +
                "playerName='" + playerName + '\'' +
                ", numberOfGamesStarted=" + numberOfGamesStarted +
                ", numberOfGamesWon=" + numberOfGamesWon +
                '}';
    }
}
