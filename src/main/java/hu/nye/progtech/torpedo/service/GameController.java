package hu.nye.progtech.torpedo.service;

import hu.nye.progtech.torpedo.model.GameState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GameController {

    private static final Logger LOGGER = LoggerFactory.getLogger(GameController.class);

    private final GameState gameState;
    private final GameStepPerformer gameStepPerformer;

    public GameController(GameState gameState, GameStepPerformer gameStepPerformer) {
        this.gameState = gameState;
        this.gameStepPerformer = gameStepPerformer;
    }

    /**
     * Starts the game loop.
     */
    public void start() {
        LOGGER.info("Starting game loop");
        while (isGameInProgress()) {
            gameStepPerformer.performGameStep();
        }
        LOGGER.info("Game loop finished");
    }

    private boolean isGameInProgress() {
        return !gameState.isShouldExit();
    }

}
