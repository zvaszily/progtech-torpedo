package hu.nye.progtech.torpedo.configuration;

import hu.nye.progtech.torpedo.model.GameState;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration for XML related components.
 */
@Configuration
public class XmlConfiguration {

    @Bean
    Marshaller marshaller() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(GameState.class);

        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        return marshaller;
    }

    @Bean
    Unmarshaller unmarshaller() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(GameState.class);

        return jaxbContext.createUnmarshaller();
    }
}
