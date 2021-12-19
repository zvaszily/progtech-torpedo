package hu.nye.progtech.torpedo.service.command.impl;

import hu.nye.progtech.torpedo.model.GameState;
import hu.nye.progtech.torpedo.persistence.GameSavesRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class SaveCommandTest {

    @Mock
    private GameState mockGameState;
    @Mock
    private GameSavesRepository mockGameSavesRepository;

    private SaveCommand saveCommandUnderTest;

    @BeforeEach
    void setUp() {
        saveCommandUnderTest = new SaveCommand(mockGameState, mockGameSavesRepository);
    }

    @Test
    void testCanProcessShouldReturnTrueWhenInputIsExit() {
        assertTrue(saveCommandUnderTest.canProcess("save"));
    }

    @Test
    void testProcess() {
        // when
        saveCommandUnderTest.process("save");

        // then
        verify(mockGameSavesRepository).saveGame(any(GameState.class));
    }
}
