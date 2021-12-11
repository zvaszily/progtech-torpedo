package hu.nye.progtech.torpedo.model;

import java.util.List;

/**
 * Represents the current state of the game.
 */
public class GameState {

    private boolean shouldExit;
    private List<BaseTable> baseTableList;

    public GameState(List<BaseTable> baseTableList) {
        this.baseTableList = baseTableList;
    }

    public List<BaseTable> getBaseTableList() {
        return baseTableList;
    }

    public void setBaseTableList(List<BaseTable> baseTableList) {
        this.baseTableList = baseTableList;
    }

    /*
                public GameState() {

                }
            */
    public boolean isShouldExit() {
        return shouldExit;
    }

    public void setShouldExit(boolean shouldExit) {
        this.shouldExit = shouldExit;
    }

    @Override
    public String toString() {
        return "GameState{" +
                "shouldExit=" + shouldExit +
                ", baseTableList=" + baseTableList.get(0) +
                '}';
    }
}
