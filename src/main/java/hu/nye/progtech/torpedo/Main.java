package hu.nye.progtech.torpedo;

import hu.nye.progtech.torpedo.model.BaseTable;
import hu.nye.progtech.torpedo.model.Player;
import hu.nye.progtech.torpedo.persistence.impl.JdbcUserRepositori;
import hu.nye.progtech.torpedo.service.ShotTableCreator;
import hu.nye.progtech.torpedo.service.TableCreator;
import hu.nye.progtech.torpedo.ui.TablePrinter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {

        //ApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        Connection connection = DriverManager.getConnection("jdbc:h2:./db./torpedo","sa","password");

        System.out.println("Hogy hívnak?");
        Scanner scanner = new Scanner(System.in);
        String player1 = scanner.nextLine();

        if (!player1.equals("")){
            Player player = new Player(player1,0,0);
            JdbcUserRepositori jdbcUserRepositori = new JdbcUserRepositori(connection,player);
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

        TableCreator tableCreator = new TableCreator(10,10);
        BaseTable baseTable1 = tableCreator.createTable();

        ShotTableCreator shotTableCreator = new ShotTableCreator(10,10);
        BaseTable shotTable1 = shotTableCreator.createTable();

        TablePrinter tablePrinter = new TablePrinter(baseTable1,shotTable1);
        tablePrinter.printTable(baseTable1);
    }
}
