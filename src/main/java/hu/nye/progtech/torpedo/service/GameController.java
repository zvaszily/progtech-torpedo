package hu.nye.progtech.torpedo.service;

import hu.nye.progtech.torpedo.model.GameState;
import hu.nye.progtech.torpedo.model.Player;
import hu.nye.progtech.torpedo.ui.TablePrinter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Component that controls the flow of a game.
 */
public class GameController {

    private static final Logger LOGGER = LoggerFactory.getLogger(GameController.class);

    private final GameState gameState;
    private final GameStepPerformer gameStepPerformer;
    private final PlayerCreator playerCreator;

    public GameController(GameState gameState, GameStepPerformer gameStepPerformer, PlayerCreator playerCreator) {
        this.gameState = gameState;
        this.gameStepPerformer = gameStepPerformer;
        this.playerCreator = playerCreator;
    }

    /**
     * Starts the game loop.
     */
    public void start() {
        Player player = playerCreator.createPlayer();
        gameState.setPlayer(player);
        TablePrinter tablePrinter = new TablePrinter(gameState);
        tablePrinter.printTable(gameState);

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
