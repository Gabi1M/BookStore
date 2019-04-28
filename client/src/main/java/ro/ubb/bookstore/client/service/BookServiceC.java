package ro.ubb.bookstore.client.service;

import org.springframework.beans.factory.annotation.Autowired;
import ro.ubb.bookstore.common.domain.Book;
import ro.ubb.bookstore.common.domain.valdator.ValidatorException;
import ro.ubb.bookstore.common.service.BookService;

import java.util.Set;

public class BookServiceC implements BookService
{
    @Autowired
    private BookService bookService;

    @Override
    public void addBook(Book book) throws ValidatorException
    {
        bookService.addBook(book);
    }

    @Override
    public void removeBook(Long id)
    {
        bookService.removeBook(id);
    }

    @Override
    public void updateBook(Book book)
    {
        bookService.updateBook(book);
    }

    @Override
    public Set<Book> getAllBooks()
    {
        return bookService.getAllBooks();
    }
}
