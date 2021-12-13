package hu.nye.progtech.torpedo.configuration;

import hu.nye.progtech.torpedo.persistence.GameSavesRepository;
import hu.nye.progtech.torpedo.persistence.impl.XmlGameSavesRepository;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Spring Java configuration class for persistence layer specific Spring Beans.
 */
@Configuration
public class RepositoryConfiguration {

    @Bean
    GameSavesRepository gameSavesRepository(Marshaller marshaller, Unmarshaller unmarshaller) {
        return new XmlGameSavesRepository(marshaller, unmarshaller);
        }
}
