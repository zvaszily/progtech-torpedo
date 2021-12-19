package hu.nye.progtech.torpedo.service.command.impl;

import hu.nye.progtech.torpedo.model.GameState;
import hu.nye.progtech.torpedo.ui.TablePrinter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class PrintCommandTest {

    @Mock
    private GameState mockGameState;
    @Mock
    private TablePrinter mockTablePrinter;

    private PrintCommand printCommandUnderTest;

    @BeforeEach
    void setUp() {
        printCommandUnderTest = new PrintCommand(mockGameState, mockTablePrinter);
    }

    @Test
    void testCanProcessShouldReturnTrueWhenInputIsExit() {
        assertTrue(printCommandUnderTest.canProcess("print"));
    }

    @Test
    void testProcess() {
        // when
        printCommandUnderTest.process("print");

        // then
        verify(mockTablePrinter).printTable(any(GameState.class));
    }
}
