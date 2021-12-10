package hu.nye.progtech.torpedo.service;

import hu.nye.progtech.torpedo.model.GameState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verifyNoInteractions;

public class GameControllerTest {

    GameController underTest;

    private GameState gameState;
    private GameStepPerformer gameStepPerformer;

    @BeforeEach
    public void init(){
        gameStepPerformer = Mockito.mock(GameStepPerformer.class);
        gameState = new GameState();
    }

    @Test
    public void testStartShouldLoopTheGameUntilTheUserDoesNotForceExit() {
        // given
        gameState.setShouldExit(true);
        underTest = new GameController(gameState, gameStepPerformer);

        // when
        underTest.start();

        // then
        verifyNoInteractions(gameStepPerformer);
    }

}
