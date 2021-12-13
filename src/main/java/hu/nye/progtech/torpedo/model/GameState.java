package hu.nye.progtech.torpedo.model;

import java.util.List;

import jakarta.xml.bind.annotation.XmlRootElement;

/**
 * Represents the current state of the game.
 */
@XmlRootElement(name = "baseTable")
public class GameState {

    private boolean shouldExit;
    private List<BaseTable> baseTableList;
    private Player player;

    public GameState() {
    }

    public GameState(List<BaseTable> baseTableList) {
        this.baseTableList = baseTableList;
    }

    public List<BaseTable> getBaseTableList() {
        return baseTableList;
    }

    public void setBaseTableList(List<BaseTable> baseTableList) {
        this.baseTableList = baseTableList;
    }

    public boolean isShouldExit() {
        return shouldExit;
    }

    public void setShouldExit(boolean shouldExit) {
        this.shouldExit = shouldExit;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    @Override
    public String toString() {
        return "GameState{" +
                "shouldExit=" + shouldExit +
                ", baseTableList=" + baseTableList.get(0) +
                '}';
    }


}
