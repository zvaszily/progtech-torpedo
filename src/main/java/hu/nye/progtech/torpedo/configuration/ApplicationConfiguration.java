package hu.nye.progtech.torpedo.configuration;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import hu.nye.progtech.torpedo.model.BaseTable;
import hu.nye.progtech.torpedo.model.GameState;
import hu.nye.progtech.torpedo.model.ShotTableCreator;
import hu.nye.progtech.torpedo.model.TableCreator;
import hu.nye.progtech.torpedo.service.GameController;
import hu.nye.progtech.torpedo.service.GameStepPerformer;
import hu.nye.progtech.torpedo.service.PlayerCreator;
import hu.nye.progtech.torpedo.service.UserInputReader;
import hu.nye.progtech.torpedo.service.command.InputHandler;
import hu.nye.progtech.torpedo.ui.PrintWrapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * Spring Java configuration class for generic application related Spring Beans.
 */
@Configuration
public class ApplicationConfiguration {

    @Bean
    public UserInputReader userInputReader() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        return new UserInputReader(bufferedReader);
    }

    @Bean
    public PlayerCreator playerCreator(UserInputReader userInputReader, PrintWrapper printWrapper) {
        return  new PlayerCreator(userInputReader, printWrapper);
    }

    @Bean
    public GameController gameController(GameState gameState, GameStepPerformer gameStepPerformer) {
        return new GameController(gameState, gameStepPerformer);
    }

    /**
     * Spring Java configuration create gameState table.
     */
    @Bean
    public GameState gameState(List<BaseTable> baseTableList) {
        TableCreator tableCreator = new TableCreator(10, 10);
        ShotTableCreator shotTableCreator = new ShotTableCreator(10, 10);
        baseTableList.add(tableCreator.createTable());
        baseTableList.add(shotTableCreator.createTable());
        baseTableList.add(tableCreator.createTable());
        baseTableList.add(shotTableCreator.createTable());
        return new GameState(baseTableList);
    }

    @Bean
    public GameStepPerformer gameStepPerformer(UserInputReader userInputReader, InputHandler inputHandler) {
        return new GameStepPerformer(userInputReader, inputHandler);
    }

    @Bean
    public PrintWrapper printWrapper() {
        return new PrintWrapper();
    }

}
