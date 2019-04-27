package ro.ubb.bookstore.common.domain.valdator;

public class ValidatorException extends BuyException
{
    public ValidatorException(String msg)
    {
        super(msg);
    }

    public ValidatorException(String msg, Throwable cause)
    {
        super(msg,cause);
    }

    public ValidatorException(Throwable cause)
    {
        super(cause);
    }
}
