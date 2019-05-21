package Controller;

public abstract class GPSLocator
{
    protected abstract void locationReceived(double latitude, double longitude, double altitude);
}
