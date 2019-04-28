package ro.ubb.bookstore.client;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ro.ubb.bookstore.client.ui.Console;

import java.io.IOException;

public class ClientApp
{
    public static void main(String[] args)
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("ro.ubb.bookstore.client.config");
        Console console = context.getBean(Console.class);
        try
        {
            console.runConsole();
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }
}
