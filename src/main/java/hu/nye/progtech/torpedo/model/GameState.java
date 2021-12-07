package hu.nye.progtech.torpedo.model;

public class GameState {

    private boolean shouldExit;

    public GameState() {

    }

    public boolean isShouldExit() {
        return shouldExit;
    }

    public void setShouldExit(boolean shouldExit) {
        this.shouldExit = shouldExit;
    }
}
