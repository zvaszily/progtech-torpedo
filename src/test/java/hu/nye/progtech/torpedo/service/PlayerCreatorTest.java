package hu.nye.progtech.torpedo.service;

import hu.nye.progtech.torpedo.model.Player;
import hu.nye.progtech.torpedo.ui.PrintWrapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PlayerCreatorTest {

    @Mock
    private UserInputReader mockUserInputReader;
    @Mock
    private PrintWrapper mockPrintWrapper;

    private PlayerCreator playerCreatorUnderTest;

    @BeforeEach
    void setUp() {
        playerCreatorUnderTest = new PlayerCreator(mockUserInputReader, mockPrintWrapper);
    }

    @Test
    void testCreatePlayer() {
        // Given
        when(mockUserInputReader.readInput()).thenReturn("user");

        // When
        final Player result = playerCreatorUnderTest.createPlayer();

        // Then
        verify(mockPrintWrapper).printLine("Szia! Mi a neved?");
    }
}
