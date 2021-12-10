package hu.nye.progtech.torpedo.persistence.impl;

import hu.nye.progtech.torpedo.model.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcUserRepositoriTest {

    private JdbcUserRepositori underTest;

    private Connection connection;
    private Player player;

    @BeforeEach
    public void init() throws SQLException {
        connection = Mockito.mock(Connection.class);
        player = Mockito.mock(Player.class);
        underTest = new JdbcUserRepositori(player);
    }

    @Test
    public void testAddUser() throws SQLException{
        // Given
        PreparedStatement preparedStatement = Mockito.mock(PreparedStatement.class);

        Mockito.when(connection.prepareStatement(JdbcUserRepositori.INSERT_STATEMENT))
                .thenReturn(preparedStatement);

        // When
       // underTest.addUser(player);

        // Then
       //Mockito.verify(connection).prepareStatement(JdbcUserRepositori.INSERT_STATEMENT);
        //Mockito.verify(preparedStatement).setString(1,String.valueOf(player.getPlayerName()));

        //Mockito.verify(preparedStatement).executeUpdate();
        //Mockito.verify(preparedStatement).close();

    }
}
