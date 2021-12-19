package hu.nye.progtech.torpedo.service.command.impl;

import hu.nye.progtech.torpedo.model.BaseTable;
import hu.nye.progtech.torpedo.model.GameState;
import hu.nye.progtech.torpedo.persistence.GameSavesRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class LoadCommandTest {

    @Mock
    private GameSavesRepository mockGameSavesRepository;
    @Mock
    private GameState mockGameState;

    private LoadCommand loadCommandUnderTest;

    @BeforeEach
    void setUp() {
        loadCommandUnderTest = new LoadCommand(mockGameSavesRepository, mockGameState);
    }

    @Test
    void testCanProcessShouldReturnTrueWhenInputIsExit() {
        assertTrue(loadCommandUnderTest.canProcess("load"));
    }

    @Test
    void testCanProcessShouldReturnBaseTableList() {
        // given
        // Configure GameSavesRepository.loadGame(...).
        final GameState gameState = new GameState(List.of(new BaseTable(0, 0, new char[][]{{'a'}})));
        when(mockGameSavesRepository.loadGame()).thenReturn(gameState);

        // when
        loadCommandUnderTest.process("load");

        // then
        verify(mockGameState).setBaseTableList(List.of(new BaseTable(0, 0, new char[][]{{'a'}})));
    }
}
