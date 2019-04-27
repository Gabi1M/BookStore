package ro.ubb.bookstore.common.domain.valdator;
import ro.ubb.bookstore.common.domain.Book;

import java.util.List;

public class BookValidator implements Validator<Book>
{
    @Override
    public void validate(Book book) throws ValidatorException
    {
        List<String> errors = new Validations().notEmpty(book.getTitle()).notEmpty(book.getAuthor()).notEmpty(book.getGenre()).idInvalid(book.getId()).getErrors();
        if(!errors.isEmpty())
        {
            throw new ValidatorException(errors.toString());
        }
    }
}
