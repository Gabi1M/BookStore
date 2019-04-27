package ro.ubb.bookstore.common.domain.valdator;

public class BuyException extends RuntimeException
{
    BuyException(String msg)
    {
        super(msg);
    }

    BuyException(String msg, Throwable cause)
    {
        super(msg,cause);
    }

    BuyException(Throwable cause)
    {
        super(cause);
    }
}
