package Controller;

import Model.InvalidPointException;
import Model.Point;
import Model.TrackingProgress;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class GPSWrapper extends GPSLocator
{
    private List<GPSObserver> observers;


    public GPSWrapper()
    {
        observers = new ArrayList<>();

    }

    public void notify(Point inLocation)
    {
        for(GPSObserver observer : observers)
        {
            observer.update(inLocation);
        }
    }

    public void attach(GPSObserver observer)
    {
        observers.add(observer);
    }

    @Override
    protected void locationReceived(double latitude, double longitude, double altitude)
    {
        try
        {
            Point point = new Point(longitude,latitude,altitude);
            notify(point);
        }
        catch (InvalidPointException e)
        {
            System.out.println("Point recieved was out of bounds");
        }


    }

    public void fakeTracking() throws InterruptedException
    {

        TimeUnit.SECONDS.sleep(2);
        locationReceived(-31.94, 115.75, 48.5);
        TimeUnit.SECONDS.sleep(2);
        locationReceived(-31.94, 115.75, 49.3);
        TimeUnit.SECONDS.sleep(2);
        locationReceived(-31.94, 115.75, 50.3);
        TimeUnit.SECONDS.sleep(2);
        locationReceived(-31.94, 115.75, 54.3);
        TimeUnit.SECONDS.sleep(2);
        locationReceived(-31.94, 115.75, 60.3);
        TimeUnit.SECONDS.sleep(2);
        locationReceived(-31.94, 115.75, 70.3);
        TimeUnit.SECONDS.sleep(2);
        locationReceived(-31.94, 115.75, 80.3);
        TimeUnit.SECONDS.sleep(2);
        locationReceived(-31.94, 115.75, 90.3);
        TimeUnit.SECONDS.sleep(2);
        locationReceived(-31.94, 115.75, 120.3);
        TimeUnit.SECONDS.sleep(2);
        locationReceived(-31.94, 115.75, 130.3);
        System.out.println("End of Route");

    }


}
