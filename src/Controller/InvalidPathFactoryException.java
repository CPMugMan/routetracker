package Controller;

//Exception gets thrown when GeoUtils provides bad data
public class InvalidPathFactoryException extends Exception
{
    public InvalidPathFactoryException(String msg)
    {
        super(msg);
    }

    public InvalidPathFactoryException(String msg, Throwable cause)
    {
        super(msg,cause);
    }

}
