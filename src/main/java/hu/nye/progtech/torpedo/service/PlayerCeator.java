package hu.nye.progtech.torpedo.service;

import hu.nye.progtech.torpedo.model.Player;
import hu.nye.progtech.torpedo.persistence.impl.JdbcUserRepositori;
import hu.nye.progtech.torpedo.ui.PrintWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;

public class PlayerCeator {

    private static final Logger LOGGER = LoggerFactory.getLogger(PlayerCeator.class);

    private static final String HELLO_MESSAGE = "Szia! Mi a neved?";
    private static final String NEW_PAYER = "Ez az 1. játékod.";
    private static final String RETURNING_PAYER = " játékból nyertél: ";

    private final UserInputReader userInputReader;
    private final PrintWrapper printWrapper;

    public PlayerCeator(UserInputReader userInputReader, PrintWrapper printWrapper) {
        this.userInputReader = userInputReader;
        this.printWrapper = printWrapper;
    }

    public Player createPlayer(){
        printWrapper.printLine(HELLO_MESSAGE);
        String player1 = userInputReader.readInput();
        Player player = new Player(player1,0,0);
        if (!player1.equals("")){
            JdbcUserRepositori jdbcUserRepositori = null;
            try {
                jdbcUserRepositori = new JdbcUserRepositori(player);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            assert jdbcUserRepositori != null;
            int started = jdbcUserRepositori.readUser().getNumberOfGamesStarted();
            if(started==0){
                player.setNumberOfGamesStarted(1);
                jdbcUserRepositori.addUser(player);
                printWrapper.printLine(NEW_PAYER);
                LOGGER.info("Add a new player to the database.: "+ player1);
            }else{
                player.setNumberOfGamesStarted(started+1);
                jdbcUserRepositori.modUser(player);
                printWrapper.printLine(player.getNumberOfGamesStarted() + RETURNING_PAYER + player.getNumberOfGamesWon());
                LOGGER.info("Query and modify player information.: " + player1);
            }
        }
        return player;
    }



}
