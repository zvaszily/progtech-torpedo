package hu.nye.progtech.torpedo.persistence.impl;

import hu.nye.progtech.torpedo.model.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class JdbcUserRepositoriTest {

    @Mock
    private Player mockPlayer;

    private JdbcUserRepositori jdbcUserRepositoriUnderTest;

    @BeforeEach
    void setUp() throws Exception {
        jdbcUserRepositoriUnderTest = new JdbcUserRepositori(mockPlayer);
    }

    @Test
    void testAddUser() {
        // Given
        final Player player = new Player("playerName", 0, 0);

        // When
        jdbcUserRepositoriUnderTest.addUser(player);

    }

    @Test
    void testModUser() {
        // Given
        final Player player = new Player("playerName", 0, 0);

        // When
        jdbcUserRepositoriUnderTest.modUser(player);

    }

    @Test
    void testReadUser() {
        // Given
        when(mockPlayer.getPlayerName()).thenReturn("result");

        // When
        final Player result = jdbcUserRepositoriUnderTest.readUser();

    }
}
