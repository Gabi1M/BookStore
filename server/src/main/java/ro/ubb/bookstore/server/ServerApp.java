package ro.ubb.bookstore.server;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ServerApp
{
    public static void main(String[] args)
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("ro.ubb.bookstore.server.config");
        System.out.println("Server starting...");
    }
}
