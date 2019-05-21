package Controller;

public abstract class GPSLocator
{
    protected abstract void locationRecieved(double latitude, double longitude, double altitude);
}
