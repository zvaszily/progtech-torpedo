package hu.nye.progtech.torpedo.service;

/**
 * Validate current game state is end.
 */
public class GameEndValidator {

    private static final char shipChar = '\u2587';

    private final char[][] map;

    public GameEndValidator(char[][] map) {
        this.map = map;
    }

    /**
     * Validate current game state is end.
     */
    public boolean isGameEnd(char[][] map) {
        boolean gameEnd = true;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == shipChar) {
                    gameEnd = false;
                    return gameEnd;
                }
            }
        }
        return gameEnd;
    }

}
