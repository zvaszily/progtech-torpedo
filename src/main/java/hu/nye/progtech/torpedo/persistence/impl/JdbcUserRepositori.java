package hu.nye.progtech.torpedo.persistence.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import hu.nye.progtech.torpedo.model.Player;
import hu.nye.progtech.torpedo.persistence.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * JDBC based implementation of {@link UserRepository}.
 */
public class JdbcUserRepositori implements UserRepository {

    Connection connection = DriverManager.getConnection("jdbc:h2:./db./torpedo", "sa", "password");

    static final String INSERT_STATEMENT = "INSERT INTO Users (Name, Started, Won) VALUES (?, ?, ?,);";
    static final String SELECT_STATEMENT = "SELECT * FROM Users WHere Name = ?;";
    static final String UPDATE_STATEMENT = "UPDATE Users SET Started = ?, Won = ? Where Name = ?;";

    private static final Logger LOGGER = LoggerFactory.getLogger(JdbcUserRepositori.class);

    private Player player;

    public JdbcUserRepositori(Player player) throws SQLException {
        this.player = player;
    }

    @Override
    public void addUser(Player player) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STATEMENT)) {
            preparedStatement.setString(1, player.getPlayerName());
            preparedStatement.setString(2, String.valueOf(player.getNumberOfGamesStarted()));
            preparedStatement.setString(3, String.valueOf(player.getNumberOfGamesWon()));
            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            LOGGER.debug(String.valueOf(throwables));
        }
    }

    @Override
    public void modUser(Player player) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STATEMENT)) {
            preparedStatement.setString(3, player.getPlayerName());
            preparedStatement.setString(1, String.valueOf(player.getNumberOfGamesStarted()));
            preparedStatement.setString(2, String.valueOf(player.getNumberOfGamesWon()));
            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            LOGGER.debug(String.valueOf(throwables));
        }
    }

    @Override
    public Player readUser() {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_STATEMENT)) {
            preparedStatement.setString(1, player.getPlayerName());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                player.setNumberOfGamesStarted(resultSet.getInt("Started"));
                player.setNumberOfGamesWon(resultSet.getInt("Won"));
            }

        } catch (SQLException throwables) {
            LOGGER.debug(String.valueOf(throwables));
        }

        return player;
    }
}
