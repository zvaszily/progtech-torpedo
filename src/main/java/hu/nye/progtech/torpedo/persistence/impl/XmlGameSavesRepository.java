package hu.nye.progtech.torpedo.persistence.impl;

import java.io.File;

import hu.nye.progtech.torpedo.model.GameState;
import hu.nye.progtech.torpedo.persistence.GameSavesRepository;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

/**
 * XML based implementation of {@link GameSavesRepository}.
 */
public class XmlGameSavesRepository implements GameSavesRepository {

    private final Marshaller marshaller;
    private final Unmarshaller unmarshaller;


    public XmlGameSavesRepository(Marshaller marshaller, Unmarshaller unmarshaller) {
        this.marshaller = marshaller;
        this.unmarshaller = unmarshaller;
    }


    @Override
    public GameState loadGame() {
        try {
            GameState loadState = (GameState) unmarshaller.unmarshal(new File("state.xml"));
            return (GameState) loadState;
        } catch (JAXBException e) {
            e.printStackTrace();
            throw new RuntimeException("XML betöltés nem sikerült!");
        }
    }

    @Override
    public void saveGame(GameState gameState) {
        try {
            marshaller.marshal(gameState, new File("state.xml"));
        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }
}
