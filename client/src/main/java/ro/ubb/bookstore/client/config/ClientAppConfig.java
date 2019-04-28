package ro.ubb.bookstore.client.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;
import ro.ubb.bookstore.client.service.BookServiceC;
import ro.ubb.bookstore.client.service.ClientServiceC;
import ro.ubb.bookstore.common.service.BookService;
import ro.ubb.bookstore.common.service.ClientService;

@Configuration
@ComponentScan({"ro.ubb.bookstore.client.ui"})
public class ClientAppConfig
{
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer()
    {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    ClientServiceC clientService()
    {
        return new ClientServiceC();
    }

    @Bean
    BookServiceC bookService()
    {
        return new BookServiceC();
    }

    @Bean
    RmiProxyFactoryBean rmiProxyFactoryBeanClient()
    {
        RmiProxyFactoryBean rmiProxyFactoryBean = new RmiProxyFactoryBean();
        rmiProxyFactoryBean.setServiceInterface(ClientService.class);
        rmiProxyFactoryBean.setServiceUrl("rmi://localhost:1099/ClientService");

        return rmiProxyFactoryBean;
    }

    @Bean
    RmiProxyFactoryBean rmiProxyFactoryBeanBook()
    {
        RmiProxyFactoryBean rmiProxyFactoryBean = new RmiProxyFactoryBean();
        rmiProxyFactoryBean.setServiceInterface(BookService.class);
        rmiProxyFactoryBean.setServiceUrl("rmi://localhost:1099/BookService");

        return rmiProxyFactoryBean;
    }
}
