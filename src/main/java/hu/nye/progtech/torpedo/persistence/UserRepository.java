package hu.nye.progtech.torpedo.persistence;

import hu.nye.progtech.torpedo.model.Player;

public interface UserRepository {

    void addUser(Player player);

    void modUser(Player player);

    Player readUser();

}
