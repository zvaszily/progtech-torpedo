package hu.nye.progtech.torpedo.service.command.impl;

import java.util.regex.Pattern;

import hu.nye.progtech.torpedo.model.GameState;
import hu.nye.progtech.torpedo.service.GameEndValidator;
import hu.nye.progtech.torpedo.service.MachinePlayerShooter;
import hu.nye.progtech.torpedo.service.command.Command;
import hu.nye.progtech.torpedo.ui.PrintWrapper;
import hu.nye.progtech.torpedo.ui.TablePrinter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Command used to shot the current game state.
 */
public class ShotCommand implements Command {

    private static final Logger LOGGER = LoggerFactory.getLogger(ShotCommand.class);

    private static final String SHOT_COMMAND_REGEX = "^[A-J]{1}[1-9]{1}($|[0])$";
    private static final String SHOT_FOUND = "A topedó talált!";
    private static final String SHOT_NOT_FOUND = "A tordedó nem talált!";
    private static final String PLAYER_VON = "Győtzél!!!";
    private static final String MACHINE_VON = "Vesztettél!!!";
    private static final char shipChar = '\u2587';

    private final GameState gameState;
    private TablePrinter tablePrinter;
    private PrintWrapper printWrapper;


    public ShotCommand(GameState gameState, TablePrinter tablePrinter, PrintWrapper printWrapper) {
        this.gameState = gameState;
        this.tablePrinter = tablePrinter;
        this.printWrapper = printWrapper;
    }

    @Override
    public boolean canProcess(String input) {
        return Pattern.matches(SHOT_COMMAND_REGEX, input);
    }

    @Override
    public void process(String input) {
        int shotX = (int) input.charAt(0);
        shotX = shotX - 65;
        int shotY = Integer.parseInt(input.substring(1));
        shotY = shotY - 1;
        char[][] mapM = gameState.getBaseTableList().get(2).getMap();
        char[][] mapP = gameState.getBaseTableList().get(1).getMap();
        String responseToPlayer;
        if (mapM[shotY][shotX] == shipChar) {
            mapP[shotY][shotX] = '+';
            gameState.getBaseTableList().get(1).setMap(mapP);
            gameState.getBaseTableList().get(2).setMap(mapM);
            responseToPlayer = SHOT_FOUND;
        } else {
            mapP[shotY][shotX] = 'X';
            gameState.getBaseTableList().get(1).setMap(mapP);
            gameState.getBaseTableList().get(2).setMap(mapM);
            responseToPlayer = SHOT_NOT_FOUND;
        }
        tablePrinter.printTable(gameState);
        printWrapper.printLine(responseToPlayer);
        GameEndValidator gameEndValidator = new GameEndValidator(mapM);
        if (gameEndValidator.isGameEnd(mapM)) {
            printWrapper.printLine(PLAYER_VON);
            gameState.setShouldExit(true);
        }
        MachinePlayerShooter machinePlayerShooter = new MachinePlayerShooter(gameState);
        if (machinePlayerShooter.machineShot()) {
            printWrapper.printLine(MACHINE_VON);
            gameState.setShouldExit(true);
        }
        tablePrinter.printTable(gameState);

    }
}
