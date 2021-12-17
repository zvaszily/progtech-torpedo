package hu.nye.progtech.torpedo.persistence.impl;

import java.io.File;

import hu.nye.progtech.torpedo.model.GameState;
import hu.nye.progtech.torpedo.persistence.GameSavesRepository;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * XML based implementation of {@link GameSavesRepository}.
 */
public class XmlGameSavesRepository implements GameSavesRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(XmlGameSavesRepository.class);

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
            LOGGER.debug(String.valueOf(e));
            throw new RuntimeException("XML betöltés nem sikerült!");
        }
    }

    @Override
    public void saveGame(GameState gameState) {
        try {
            marshaller.marshal(gameState, new File("state.xml"));
        } catch (JAXBException e) {
            LOGGER.debug(String.valueOf(e));
        }

    }
}
