package hu.nye.progtech.torpedo;

import hu.nye.progtech.torpedo.model.BaseTable;
import hu.nye.progtech.torpedo.model.Player;
import hu.nye.progtech.torpedo.service.PlayerCeator;
import hu.nye.progtech.torpedo.service.ShotTableCreator;
import hu.nye.progtech.torpedo.service.TableCreator;
import hu.nye.progtech.torpedo.ui.TablePrinter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        //ApplicationContext applicationContext = new AnnotationConfigApplicationContext("hu.nye.progtech.torpedo");

        PlayerCeator playerCeator = new PlayerCeator();
        Player player = playerCeator.createPlayer();

        TableCreator tableCreator = new TableCreator(10,10);
        BaseTable baseTable1 = tableCreator.createTable();

        ShotTableCreator shotTableCreator = new ShotTableCreator(10,10);
        BaseTable shotTable1 = shotTableCreator.createTable();

        TablePrinter tablePrinter = new TablePrinter(baseTable1,shotTable1);
        tablePrinter.printTable(baseTable1);
    }
}
