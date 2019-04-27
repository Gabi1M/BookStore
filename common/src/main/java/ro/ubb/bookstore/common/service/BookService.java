package ro.ubb.bookstore.common.service;

import ro.ubb.bookstore.common.domain.Book;
import ro.ubb.bookstore.common.domain.valdator.ValidatorException;

import java.util.Set;

public interface BookService
{
    void addBook(Book book) throws ValidatorException;

    void removeBook(Long id);

    void updateBook(Book book);

    Set<Book> getAllBooks();
}
