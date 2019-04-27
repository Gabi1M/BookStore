package ro.ubb.bookstore.server.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"ro.ubb.bookstore.server.repository","ro.ubb.bookstore.server.service"})
public class StoreConfig
{

}
