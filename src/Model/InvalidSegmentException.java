package Model;

public class InvalidSegmentException extends Exception
{
    public InvalidSegmentException(String msg)
    {
        super(msg);
    }

    public InvalidSegmentException(String msg, Throwable cause)
    {
        super(msg,cause);
    }
}
