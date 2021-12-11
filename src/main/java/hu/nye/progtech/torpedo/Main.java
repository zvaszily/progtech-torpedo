package hu.nye.progtech.torpedo;

import java.sql.SQLException;

import hu.nye.progtech.torpedo.model.GameState;
import hu.nye.progtech.torpedo.service.GameController;
import hu.nye.progtech.torpedo.service.PlayerCreator;
import hu.nye.progtech.torpedo.ui.TablePrinter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


/**
 * Entry point of the Torpedo game.
 */
public class Main {

    /**
     * Entrypoint of the game.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) throws SQLException {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("hu.nye.progtech.torpedo");
        PlayerCreator playerCreator = applicationContext.getBean(PlayerCreator.class);
        playerCreator.createPlayer();

        GameState gameState = applicationContext.getBean(GameState.class);

        TablePrinter tablePrinter = new TablePrinter(gameState);
        tablePrinter.printTable();



        GameController gameController = applicationContext.getBean(GameController.class);
        gameController.start();
    }
}
