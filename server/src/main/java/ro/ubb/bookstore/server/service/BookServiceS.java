package ro.ubb.bookstore.server.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ro.ubb.bookstore.common.domain.Book;
import ro.ubb.bookstore.common.service.BookService;
import ro.ubb.bookstore.server.repository.BookRepository;

import java.util.HashSet;
import java.util.Set;

public class BookServiceS implements BookService
{
    private static final Logger log = LoggerFactory.getLogger(BookServiceS.class);

    @Autowired
    private BookRepository bookRepository;

    @Override
    public void addBook(Book book)
    {
        log.trace("addBook: book = {}",book);

        bookRepository.save(book);

        log.trace("addBook --- method finished");
    }

    @Override
    public void removeBook(Long id)
    {
        log.trace("removeBook: id = {}",id);

        bookRepository.deleteById(id);

        log.trace("removeBook --- method finished");
    }

    @Override
    public void updateBook(Book book)
    {
        log.trace("updateBook: book = {}",book);

        bookRepository.findById(book.getId()).ifPresent(book1 ->
        {
            book1.setTitle(book.getTitle());
            book1.setAuthor(book.getAuthor());
            book1.setGenre(book.getGenre());
            book1.setYear(book.getYear());
            bookRepository.save(book1);

            log.debug("updateBook --- book updated? --- book = {}",book1);
        });

        log.trace("updateBook --- method finished");
    }

    @Override
    public Set<Book> getAllBooks()
    {
        log.trace("getAllBooks --- method entered");
        return new HashSet<>(bookRepository.findAll());
    }
}
