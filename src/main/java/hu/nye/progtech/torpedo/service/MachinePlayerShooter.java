package hu.nye.progtech.torpedo.service;

import hu.nye.progtech.torpedo.model.GameState;

/**
 * The machine bounces back.
 */
public class MachinePlayerShooter {

    private static final char shipChar = '\u2587';

    private GameState gameState;

    public MachinePlayerShooter(GameState gameState) {
        this.gameState = gameState;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    /**
     * The machine bounces back.
     */
    public boolean machineShot() {
        boolean gameEnd = true;
        int max = gameState.getBaseTableList().get(0).getNumberOfRows();
        int shotX = randomCoordinate(max);
        int shotY = randomCoordinate(max);
        char[][] mapM = gameState.getBaseTableList().get(3).getMap();
        char[][] mapP = gameState.getBaseTableList().get(0).getMap();
        if (mapP[shotY][shotX] == shipChar) {
            mapP[shotY][shotX] = '+';
            gameState.getBaseTableList().get(0).setMap(mapP);
            gameState.getBaseTableList().get(3).setMap(mapM);
        } else {
            mapP[shotY][shotX] = 'X';
            gameState.getBaseTableList().get(0).setMap(mapP);
            gameState.getBaseTableList().get(3).setMap(mapM);
        }
        GameEndValidator gameEndValidator = new GameEndValidator(mapP);
        gameEnd = gameEndValidator.isGameEnd(mapP);
        return gameEnd;
    }

    private int randomCoordinate(int max) {
        return (int) (Math.random() * max);
    }
}
