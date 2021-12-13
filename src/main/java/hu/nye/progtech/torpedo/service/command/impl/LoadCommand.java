package hu.nye.progtech.torpedo.service.command.impl;

import hu.nye.progtech.torpedo.model.GameState;
import hu.nye.progtech.torpedo.persistence.GameSavesRepository;
import hu.nye.progtech.torpedo.service.command.Command;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Command used to load a previously saved game state.
 */
public class LoadCommand implements Command {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoadCommand.class);
    private static final String LOAD_COMMAND = "load";

    private GameSavesRepository gameSavesRepository;
    private GameState gameState;

    public LoadCommand(GameSavesRepository gameSavesRepository, GameState gameState) {
        this.gameSavesRepository = gameSavesRepository;
        this.gameState = gameState;
    }

    @Override
    public boolean canProcess(String input) {
        return LOAD_COMMAND.equals(input);
    }

    @Override
    public void process(String input) {
        LOGGER.debug("Load command was called");
        gameState.setBaseTableList(gameSavesRepository.loadGame().getBaseTableList());
        LOGGER.info("Load was successful");
    }

}
