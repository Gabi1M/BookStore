package ro.ubb.bookstore.server.config;

import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.remoting.rmi.RmiServiceExporter;
import ro.ubb.bookstore.common.service.BookService;
import ro.ubb.bookstore.common.service.ClientService;
import ro.ubb.bookstore.server.service.BookServiceS;
import ro.ubb.bookstore.server.service.ClientServiceS;

@Configuration
@Import({JPAConfig.class})
@PropertySources({@PropertySource(value = "classpath:local/db.properties"),})
public class ServerAppConfig
{
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer()
    {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    ClientServiceS clientServiceS()
    {
        return new ClientServiceS();
    }

    @Bean
    BookServiceS bookServiceS()
    {
        return new BookServiceS();
    }

    @Bean
    RmiServiceExporter rmiServiceExporterClient()
    {
        RmiServiceExporter exporter = new RmiServiceExporter();
        exporter.setServiceName("ClientService");
        exporter.setServiceInterface(ClientService.class);
        exporter.setService(clientServiceS());

        return exporter;
    }

    @Bean
    RmiServiceExporter rmiServiceExporterBook()
    {
        RmiServiceExporter exporter = new RmiServiceExporter();
        exporter.setServiceName("BookService");
        exporter.setServiceInterface(BookService.class);
        exporter.setService(bookServiceS());

        return exporter;
    }
}
