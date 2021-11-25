package hu.nye.progtech.torpedo.service;

import hu.nye.progtech.torpedo.model.Player;
import hu.nye.progtech.torpedo.persistence.impl.JdbcUserRepositori;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.Scanner;

public class PlayerCeator {

    private static final Logger LOGGER = LoggerFactory.getLogger(PlayerCeator.class);

    private final UserInputReader userInputReader;

    public PlayerCeator(UserInputReader userInputReader) {
        this.userInputReader = userInputReader;
    }

    public Player createPlayer(){
        System.out.println("Hogy hívnak?");
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
                System.out.println("Eddig ez az 1. játékod." );
                LOGGER.info("Add a new player to the database.: "+ player1);
            }else{
                player.setNumberOfGamesStarted(started+1);
                jdbcUserRepositori.modUser(player);
                System.out.println("Eddig ez a " + player.getNumberOfGamesStarted() + ". játékod, nyertél: " + player.getNumberOfGamesWon() );
                LOGGER.info("Query and modify player information.: " + player1);
            }
        }
        return player;
    }



}
