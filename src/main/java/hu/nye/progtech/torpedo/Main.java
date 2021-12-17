package hu.nye.progtech.torpedo;

import java.sql.SQLException;

import hu.nye.progtech.torpedo.service.GameController;
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

        GameController gameController = applicationContext.getBean(GameController.class);
        gameController.start();
    }
}
