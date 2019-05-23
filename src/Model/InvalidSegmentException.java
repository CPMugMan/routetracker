package Model;

//Exception gets thrown when a segment attempts to have the description start with *
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
