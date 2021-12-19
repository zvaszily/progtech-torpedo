package hu.nye.progtech.torpedo.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class GameEndValidatorTest {

    private GameEndValidator gameEndValidatorUnderTest;

    @BeforeEach
    void setUp() {
        gameEndValidatorUnderTest = new GameEndValidator(new char[][]{{'a'}});
    }

    @Test
    void testIsGameEnd() {
        // Given
        final char[][] map = new char[][]{{'a'}};

        // When
        final boolean result = gameEndValidatorUnderTest.isGameEnd(map);

        // Then
        assertTrue(result);
    }
}
