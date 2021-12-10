package hu.nye.progtech.torpedo.configuration;

import hu.nye.progtech.torpedo.model.GameState;
import hu.nye.progtech.torpedo.service.GameController;
import hu.nye.progtech.torpedo.service.GameStepPerformer;
import hu.nye.progtech.torpedo.service.PlayerCreator;
import hu.nye.progtech.torpedo.service.UserInputReader;
import hu.nye.progtech.torpedo.service.command.InputHandler;
import hu.nye.progtech.torpedo.ui.PrintWrapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public UserInputReader userInputReader() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        return new UserInputReader(bufferedReader);
    }
    @Bean
    public PlayerCreator playerCeator(UserInputReader userInputReader, PrintWrapper printWrapper){
        return  new PlayerCreator(userInputReader, printWrapper);
    }

    @Bean
    public GameController gameController(GameState gameState, GameStepPerformer gameStepPerformer) {
        return new GameController(gameState, gameStepPerformer);
    }

    @Bean
    public GameState gameState(){
        return new GameState();
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
