package hu.nye.progtech.torpedo.configuration;

import java.util.List;

import hu.nye.progtech.torpedo.model.GameState;
import hu.nye.progtech.torpedo.persistence.GameSavesRepository;
import hu.nye.progtech.torpedo.service.command.Command;
import hu.nye.progtech.torpedo.service.command.InputHandler;
import hu.nye.progtech.torpedo.service.command.impl.DefaultCommand;
import hu.nye.progtech.torpedo.service.command.impl.ExitCommand;
import hu.nye.progtech.torpedo.service.command.impl.LoadCommand;
import hu.nye.progtech.torpedo.service.command.impl.PrintCommand;
import hu.nye.progtech.torpedo.service.command.impl.SaveCommand;
import hu.nye.progtech.torpedo.service.command.impl.ShotCommand;
import hu.nye.progtech.torpedo.ui.PrintWrapper;
import hu.nye.progtech.torpedo.ui.TablePrinter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Spring Java configuration class for command specific Spring Beans.
 */
@Configuration
public class CommandConfiguration {

    @Bean
    public InputHandler inputHandler(List<Command> commandList) {
        return new InputHandler(commandList);
    }

    @Bean
    SaveCommand saveCommand(GameState gameState, GameSavesRepository gameSavesRepository) {
        return new SaveCommand(gameState, gameSavesRepository);
    }

    @Bean
    LoadCommand loadCommand(GameSavesRepository gameSavesRepository, GameState gameState) {
        return new LoadCommand(gameSavesRepository, gameState);
    }

    @Bean
    ShotCommand shotCommand(GameState gameState, TablePrinter tablePrinter, PrintWrapper printWrapper) {
        return new ShotCommand(gameState, tablePrinter, printWrapper);
    }

    @Bean
    PrintCommand printCommand(GameState gameState, TablePrinter tablePrinter) {
        return new PrintCommand(gameState, tablePrinter);
    }

    @Bean
    public ExitCommand exitCommand(GameState gameState) {
        return new ExitCommand(gameState);
    }

    @Bean
    public DefaultCommand defaultCommand(PrintWrapper printWrapper) {
        return new DefaultCommand(printWrapper);
    }

}
