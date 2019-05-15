package Model;

public class InvalidSegmenException extends Exception
{
    public InvalidSegmenException(String msg)
    {
        super(msg);
    }

    public InvalidSegmenException(String msg, Throwable cause)
    {
        super(msg,cause);
    }
}
