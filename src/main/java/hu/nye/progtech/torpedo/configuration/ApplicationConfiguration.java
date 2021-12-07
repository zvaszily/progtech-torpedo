package hu.nye.progtech.torpedo.configuration;

import hu.nye.progtech.torpedo.service.PlayerCeator;
import hu.nye.progtech.torpedo.service.UserInputReader;
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
    public PlayerCeator playerCeator(UserInputReader userInputReader,PrintWrapper printWrapper){
        return  new PlayerCeator(userInputReader, printWrapper);
    }

    @Bean
    public PrintWrapper printWrapper() {
        return new PrintWrapper();
    }

}
