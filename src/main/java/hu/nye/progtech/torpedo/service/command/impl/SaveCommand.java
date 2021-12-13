package hu.nye.progtech.torpedo.service.command.impl;

import hu.nye.progtech.torpedo.model.GameState;
import hu.nye.progtech.torpedo.service.PlayerCreator;
import hu.nye.progtech.torpedo.service.command.Command;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Command used to save the current game state.
 */
public class SaveCommand implements Command {

    private static final Logger LOGGER = LoggerFactory.getLogger(SaveCommand.class);
    private static final String SAVE_COMMAND = "save";

    private GameState gameState;

    public SaveCommand(GameState gameState) {
        this.gameState = gameState;
    }

    @Override
    public boolean canProcess(String input) {
        return SAVE_COMMAND.equals(input);
    }

    @Override
    public void process(String input) {
        LOGGER.debug("Game Save command was called");
        System.out.println(gameState.toString());
        System.out.println(gameState.getPlayer());
        LOGGER.info("Game Save was successfully persisted");
    }

}