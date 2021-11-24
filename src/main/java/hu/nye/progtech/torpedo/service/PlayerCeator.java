package hu.nye.progtech.torpedo.service;

import hu.nye.progtech.torpedo.model.Player;
import hu.nye.progtech.torpedo.persistence.impl.JdbcUserRepositori;

import java.sql.SQLException;
import java.util.Scanner;

public class PlayerCeator {

    public Player createPlayer(){
        System.out.println("Hogy hívnak?");
        Scanner scanner = new Scanner(System.in);
        String player1 = scanner.nextLine();
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
            }else{
                player.setNumberOfGamesStarted(started+1);
                jdbcUserRepositori.modUser(player);
                System.out.println("Eddig ez a " + player.getNumberOfGamesStarted() + ". játékod, nyertél: " + player.getNumberOfGamesWon() );
            }
        }
        return player;
    }



}
