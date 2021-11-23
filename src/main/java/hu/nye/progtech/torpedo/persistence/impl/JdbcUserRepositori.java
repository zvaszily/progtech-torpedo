package hu.nye.progtech.torpedo.persistence.impl;

import hu.nye.progtech.torpedo.model.Player;
import hu.nye.progtech.torpedo.persistence.UserRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcUserRepositori implements UserRepository {

    private static final String INSERT_STATEMENT = "INSERT INTO Users (Name, Started, Won) VALUES (?, ?, ?,);";
    private static final String SELECT_STATEMENT = "SELECT * FROM Users WHere Name = ?;";
    private static final String UPDATE_STATEMENT = "UPDATE Users SET Started = ?, Won = ? Where Name = ?;";

    private Connection connection;
    private Player player;

    public JdbcUserRepositori(Connection connection, Player player) {
        this.connection = connection;
        this.player = player;
    }

    @Override
    public void addUser(Player player) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STATEMENT)){
            preparedStatement.setString(1,player.getPlayerName());
            preparedStatement.setString(2, String.valueOf(player.getNumberOfGamesStarted()));
            preparedStatement.setString(3, String.valueOf(player.getNumberOfGamesWon()));
            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void modUser(Player player) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STATEMENT)){
            preparedStatement.setString(3,player.getPlayerName());
            preparedStatement.setString(1, String.valueOf(player.getNumberOfGamesStarted()));
            preparedStatement.setString(2, String.valueOf(player.getNumberOfGamesWon()));
            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Player readUser() {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_STATEMENT)){
            preparedStatement.setString(1,player.getPlayerName());
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                player.setNumberOfGamesStarted(resultSet.getInt("Started"));
                player.setNumberOfGamesWon(resultSet.getInt("Won"));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return player;
    }
}
