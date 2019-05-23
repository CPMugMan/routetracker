package Model;

//This exception gets thrown when a Point is attempted to be created with lat > 90 || < -90 or a long > 180 || < -180
public class InvalidPointException extends Exception
{
    public InvalidPointException(String msg)
    {
        super(msg);
    }

    public InvalidPointException(String msg, Throwable cause)
    {
        super(msg,cause);
    }

}
