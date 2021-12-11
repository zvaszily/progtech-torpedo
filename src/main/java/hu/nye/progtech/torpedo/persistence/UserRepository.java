package hu.nye.progtech.torpedo.persistence;

import hu.nye.progtech.torpedo.model.Player;

/**
 * Interface for storing and retrieving current User.
 */
public interface UserRepository {

    void addUser(Player player);

    void modUser(Player player);

    Player readUser();

}
