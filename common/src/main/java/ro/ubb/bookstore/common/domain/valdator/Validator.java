package ro.ubb.bookstore.common.domain.valdator;

public interface Validator<T>
{
    void validate(T entity) throws ValidatorException;
}
