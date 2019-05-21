package Controller;

import Model.TrackingProgress;
import java.util.List;

public class GPSWrapper extends GPSLocator
{
    private List<GPSObserver> observers;
    private TrackingProgress trackingProgress;


    public GPSWrapper(TrackingProgress trackingProgress)
    {
        this.trackingProgress = trackingProgress;

    }

    public void attach(GPSObserver observer)
    {
        observers.add(observer);
    }

    @Override
    protected void locationRecieved(double latitude, double longitude, double altitude)
    {

    }


}
