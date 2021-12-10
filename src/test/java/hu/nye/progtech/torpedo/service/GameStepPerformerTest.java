package hu.nye.progtech.torpedo.service;

import hu.nye.progtech.torpedo.service.command.InputHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

public class GameStepPerformerTest {

    private static final String INPUT = "fromInput";

    GameStepPerformer underTest;

    private UserInputReader userInputReader;
    private InputHandler inputHandler;

    @BeforeEach
    private void init(){
        userInputReader = Mockito.mock(UserInputReader.class);
        inputHandler = Mockito.mock(InputHandler.class);
        underTest = new GameStepPerformer(userInputReader,inputHandler);
    }

    @Test
    public void testPerformGameStepShouldReadUserInputAndDelegateCallToInputHandler() {
        // given
        given(userInputReader.readInput()).willReturn(INPUT);

        // when
        underTest.performGameStep();

        // then
        verify(userInputReader).readInput();
        verify(inputHandler).handleInput(INPUT);
    }
}
