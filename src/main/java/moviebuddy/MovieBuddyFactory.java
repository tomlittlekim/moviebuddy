package moviebuddy;

import moviebuddy.data.CsvMovieReader;
import moviebuddy.data.XmlMovieReader;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.oxm.Unmarshaller;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
@PropertySource("/application.properties")
@ComponentScan(basePackages = { "moviebuddy" })
@Import({ MovieBuddyFactory.DomainModuleConfig.class, MovieBuddyFactory.DataSourceModuleConfig.class })
public class MovieBuddyFactory {

    @Bean
    public Jaxb2Marshaller jaxb2Marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setPackagesToScan("moviebuddy");

        return marshaller;
    }

    @Configuration
    static class DomainModuleConfig {

    }

    @Configuration
    static class DataSourceModuleConfig {

    }

}
