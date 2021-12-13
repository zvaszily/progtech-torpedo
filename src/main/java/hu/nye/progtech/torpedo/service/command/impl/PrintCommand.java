package hu.nye.progtech.torpedo.service.command.impl;

import hu.nye.progtech.torpedo.model.GameState;
import hu.nye.progtech.torpedo.service.command.Command;
import hu.nye.progtech.torpedo.ui.TablePrinter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Command used to request the printing of the current state
 * of the game map.
 */
public class PrintCommand implements Command {

    private static final Logger LOGGER = LoggerFactory.getLogger(PrintCommand.class);

    private static final String PRINT_COMMAND = "print";

    private final GameState gameState;
    private final TablePrinter tablePrinter;

    public PrintCommand(GameState gameState, TablePrinter tablePrinter) {
        this.gameState = gameState;
        this.tablePrinter = tablePrinter;
    }

    @Override
    public boolean canProcess(String input) {
        return PRINT_COMMAND.equals(input);
    }

    @Override
    public void process(String input) {
        LOGGER.info("Performing print command");
        tablePrinter.printTable(gameState);
    }

}
