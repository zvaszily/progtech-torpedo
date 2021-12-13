package hu.nye.progtech.torpedo.persistence;

import hu.nye.progtech.torpedo.model.GameState;

/**
 * Interface for storing and retrieving current Torpedo game states.
 */
public interface GameSavesRepository {

    GameState loadGame();

    void saveGame(GameState gameState);
}
