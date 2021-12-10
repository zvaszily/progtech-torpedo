package hu.nye.progtech.torpedo.service;

import hu.nye.progtech.torpedo.model.Player;
import hu.nye.progtech.torpedo.persistence.impl.JdbcUserRepositori;
import hu.nye.progtech.torpedo.ui.PrintWrapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.BDDMockito.given;

public class PlayerCreatorTest {

    private static final String INPUT = "Zsolt";

    private PlayerCreator underTest;

   private UserInputReader userInputReader;
   private PrintWrapper printWrapper;
   private Player player;
   private JdbcUserRepositori jdbcUserRepositori;

    @BeforeEach
    private void init(){
        userInputReader = Mockito.mock(UserInputReader.class);
        printWrapper = Mockito.mock(PrintWrapper.class);
        player = Mockito.mock(Player.class);
        jdbcUserRepositori = Mockito.mock(JdbcUserRepositori.class);
        underTest = new PlayerCreator(userInputReader,printWrapper);

    }

    @Test
    public void testShouldReturnPlayerWhenPlayerIsNew(){
        // Given
        given(userInputReader.readInput()).willReturn(INPUT);
       // given(jdbcUserRepositori.readUser().getNumberOfGamesStarted()).willReturn(0);
        // When
        underTest.createPlayer();
        // Then
    }



}
