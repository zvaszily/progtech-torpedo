package hu.nye.progtech.torpedo.service;

import java.sql.SQLException;

import hu.nye.progtech.torpedo.model.Player;
import hu.nye.progtech.torpedo.persistence.impl.JdbcUserRepositori;
import hu.nye.progtech.torpedo.ui.PrintWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Create a Player.
 */
public class PlayerCreator {

    private static final Logger LOGGER = LoggerFactory.getLogger(PlayerCreator.class);

    static final String HELLO_MESSAGE = "Szia! Mi a neved?";
    static final String NEW_PAYER = "Ez az 1. játékod.";
    static final String RETURNING_PAYER = ". játékod ebből nyertél: ";

    private final UserInputReader userInputReader;
    private final PrintWrapper printWrapper;

    public PlayerCreator(UserInputReader userInputReader, PrintWrapper printWrapper) {
        this.userInputReader = userInputReader;
        this.printWrapper = printWrapper;
    }

    /**
     * Create a Player with db.
     */
    public Player createPlayer() {
        printWrapper.printLine(HELLO_MESSAGE);
        String player1 = userInputReader.readInput();
        Player player = new Player(player1, 0, 0);
        if (!player1.equals("")) {
            JdbcUserRepositori jdbcUserRepositori = null;
            try {
                jdbcUserRepositori = new JdbcUserRepositori(player);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            assert jdbcUserRepositori != null;
            int started = jdbcUserRepositori.readUser().getNumberOfGamesStarted();
            if (started == 0) {
                player.setNumberOfGamesStarted(1);
                jdbcUserRepositori.addUser(player);
                printWrapper.printLine(NEW_PAYER);
                LOGGER.info("Add a new player to the database.: " + player1);
            } else {
                player.setNumberOfGamesStarted(started + 1);
                jdbcUserRepositori.modUser(player);
                printWrapper.printLine("Ez a " + player.getNumberOfGamesStarted() + RETURNING_PAYER + player.getNumberOfGamesWon());
                LOGGER.info("Query and modify player information.: " + player1);
            }
        }
        return player;
    }



}
