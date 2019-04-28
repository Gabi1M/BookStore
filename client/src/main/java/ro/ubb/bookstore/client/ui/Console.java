package ro.ubb.bookstore.client.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.ubb.bookstore.common.domain.Book;
import ro.ubb.bookstore.common.domain.Client;
import ro.ubb.bookstore.common.service.BookService;
import ro.ubb.bookstore.common.service.ClientService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;

@Component
public class Console
{
    @Autowired
    private ClientService clientService;

    @Autowired
    private BookService bookService;

    private void printMenu()
    {
        System.out.println("1. Add client.");
        System.out.println("2. Remove client");
        System.out.println("3. Update client");
        System.out.println("4. Add book");
        System.out.println("5. Remove book");
        System.out.println("6. Update book");
        System.out.println("7. Print all clients");
        System.out.println("8. Print all books");
        System.out.println("0. Exit");
    }

    private Client readClient(BufferedReader bufferedReader) throws IOException
    {

        //System.out.println("Give id: ");
        //Long id = Long.parseLong(bufferedReader.readLine());
        System.out.println("Give name: ");
        String name = bufferedReader.readLine();
        System.out.println("Give gender: ");
        String gender=  bufferedReader.readLine();
        System.out.println("Give age: ");
        int age = Integer.parseInt(bufferedReader.readLine());

        Client client = new Client(name,gender,age);
        //client.setId(id);

        return client;
    }

    private Book readBook(BufferedReader bufferedReader) throws IOException
    {
        //System.out.println("Give id: ");
        //Long id = Long.parseLong(bufferedReader.readLine());
        System.out.println("Give title: ");
        String title = bufferedReader.readLine();
        System.out.println("Give author: ");
        String author = bufferedReader.readLine();
        System.out.println("Give genre: ");
        String genre = bufferedReader.readLine();
        System.out.println("Give year: ");
        int year = Integer.parseInt(bufferedReader.readLine());

        Book book = new Book(title,author,genre,year);
        //book.setId(id);

        return book;
    }

    public void runConsole() throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int option=0;
        printMenu();
        do
        {
            //printMenu();
            try
            {
                System.out.println("Give option: ");
                option = Integer.parseInt(bufferedReader.readLine());

            }
            catch (IOException ex)
            {
                ex.printStackTrace();
            }

            switch (option)
            {
                case 0:
                {
                    break;
                }

                case 1:
                {
                    Client client;
                    try
                    {
                        client = readClient(bufferedReader);
                        clientService.addClient(client);
                    }
                    catch (IOException ex)
                    {
                        ex.printStackTrace();
                    }
                    break;
                }

                case 2:
                {
                    System.out.println("Give id: ");
                    Long id = Long.parseLong(bufferedReader.readLine());
                    clientService.removeClient(id);
                    break;
                }

                case 3:
                {
                    System.out.println("Give id: ");
                    Long id = Long.parseLong(bufferedReader.readLine());
                    Client client;
                    try
                    {
                        client = readClient(bufferedReader);
                        client.setId(id);
                        clientService.updateClient(client);
                    }
                    catch (IOException ex)
                    {
                        ex.printStackTrace();
                    }
                    break;
                }

                case 4:
                {
                    Book book;
                    try
                    {
                        book = readBook(bufferedReader);
                        bookService.addBook(book);
                    }
                    catch (IOException ex)
                    {
                        ex.printStackTrace();
                    }
                    break;
                }

                case 5:
                {
                    System.out.println("Give id: ");
                    Long id = Long.parseLong(bufferedReader.readLine());
                    bookService.removeBook(id);
                    break;
                }

                case 6:
                {
                    System.out.println("Give id: ");
                    Long id = Long.parseLong(bufferedReader.readLine());
                    Book book;
                    try
                    {
                        book = readBook(bufferedReader);
                        book.setId(id);
                        bookService.updateBook(book);
                    }
                    catch (IOException ex)
                    {
                        ex.printStackTrace();
                    }
                    break;
                }

                case 7:
                {
                    Set<Client> clients = clientService.getAllClients();
                    clients.forEach(System.out::println);
                    break;
                }

                case 8:
                {
                    Set<Book> books = bookService.getAllBooks();
                    books.forEach(System.out::println);
                    break;
                }
            }

        }while (option != 0);
    }
}
